# Stack-1

---

## Memoization

피보나치 수열을 재귀 호출로 구현하게 되면 중복 호출로 인해 연산량이 많아지고 비효율적이다.

```python
def fibo_recur(n):
    if n < 2:
        return n
    else:
        return fibo_recur(n-1) + fibo_recur(n-2)
    
```



* 메모이제이션(Memoization)은 컴퓨터 프로그램을 실행할 때 이전에 계산한 값을 메모리에 저장해서 매번 다시 계산하지 않도록 하여 전체적인 실행속도를 빠르게 하는 기술이다.
* 동적 계획법(Dynamic Programming)의 핵심이 되는 기술이다.
* Memoization은 글자 그대로 해석하면 '메모리에 넣기(to put in memory)'라는 의미이며 '기억되어야 할 것' 이라는 뜻의 라틴어 memorandum에서 파생되었다.

```python
# memoization 방법을 적용한 구현
# memo를 위한 배열을 할당하고, 모두 0으로 초기화 한다.
# memo[0]을 0으로 memo[1]는 1로 초기화 한다.
def fibo_memo(n):
    global memo		# global 설정해도 되고 안 해도 된다. 
    # len(memo) <= n 은 이미 값이 있다는 뜻
    # n >=2는 memo에 이미 0과 1 이 있기 때문
    if n >= 2 and len(memo) <= n:
        memo.append(fibo_memo(n-1) + fibo_memo(n-2))
    return memo[n]
memo = [0,1]

def fibo2(n):
    if memo2[n] == -1 :
        memo2[n] = fibo2(n-1) + fibo2(n-2)
    return memo2[n]
memo2 = [-1] * 21
memo2[0] = 0
memo2[1] = 1
```

* 위의 재귀 피보나치 수를 구하는 알고리즘에서 fibo_recur(n)의 값을 계산하자마자 저장하면(memoize), 실행시간을 O(n)으로 줄일 수 있다.



### DP (Dynamic Programming)

* 동적 계획 알고리즘은 그리디 알고리즘과 같이 **최적화 문제**를 해결하는 알고리즘이다.
* 동적 계획 알고리즘은 먼저 입력 크기가 작은 부분 문제들을 모두 해결한 후에  그 해들을 이용하여 보다 큰 크기의 부분 문제들을 해결하여, 최종적으로 원래 주어진 입력의 문제를 해결하는 알고리즘이다.
* 작은 문제부터 큰 문제를 해결해 나가는 과정

```python
def fibo_DP(n) :
    f = [0,1]
    
    for i in range(2, n + 1):
        f.append(f[i-1] + f[i-2])
    return f[n]
```

* DP의 구현 방식
  * recursive 방식 : fibo_recur()
  * iterative 방식 : fibo_memo()
* memoization을 재귀적 구조에 사용하는 것보다 반복적으로 DP를 구현한 것이 성능 면에서 보다 효율적이다.
* 재귀적 구조는 내부에 시스템 호출 스택을 사용하는 오버헤드가 발생하기 때문이다.



## DFS(깊이우선탐색)

* 비선형구조인 그래프 구조는 그래프로 표현된 모든 자료를 빠짐없이 검색하는 것이 중요하다.
* 두 가지 방법
  * 깊이 우선 탐색 (Depth Frist Search, DFS)
  * 넓이 우선 탐색 (Breadth Frist Search, BFS)
* 시작 정점의 한 방향으로 갈 수 있는 경로가 있는 곳까지 깊이 탐색해 가다가 더 이상 갈 곳이 없게 되면, 가장 마지막에 만났던 갈림길 간선이 있는 정점으로 되돌아와서 다른 방향의 정점으로 탐색을 계속 반복하여 결국 모든 정점을 방문하는 순회 방법
* 가장 마지막에 만났던 갈림길의 정점으로 되돌아가서 다시 깊이 우선 탐색을 반복해야 하므로 후입선출(First In Last Out, FILO or LIFO)구조의 스택 사용

#### 구현 순서

1) 시작 정점 V를 결정하여 방문한다.

2) 정점 V에 인접한 정점 중에서

	1. 방문하지 않은 정점 W가 있으면, 정점 V를 스택에 push하고 정점 W를 방문한다. 그리고 W를 V로 하여 다시 2)를 반복한다.
 	2. 방문하지 않은 정점이 없으면, 탐색의 방향을 바꾸기 위해서 스택을 pop하여 받은 가장 마지막 방문 정점을 V로 하여 다시 2)를 반복한다.

3) 스택이 공백이 될 때까지 2)를 반복한다.

* 구현

  ```python
  visited = []	# 방문한 장소
  stack = []		# 아직 방문할 자식 노드가 있는 노드 담을 변수
  def iterative_DFS(start_v):
      stack = [v]
      while stack:
          v = stack.pop()
      if
  ```

  

