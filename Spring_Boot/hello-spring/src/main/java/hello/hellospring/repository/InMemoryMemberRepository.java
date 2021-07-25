package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class InMemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> repo = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        repo.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(repo.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return repo.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(repo.values());
    }
}
