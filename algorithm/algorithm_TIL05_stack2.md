#  Stack-2

---

## 백 트래킹(Backtracking)

* 백트래킹 기법은 해를 찾는 도중에 '막히면' (즉, 해가 아니면) 되돌아가서 다시 해를 찾아 가는 기법이다.
* 백트래킹 기법은 최적화(optimization) 문제와 결정 (decision) 문제를 해결할 수 있다.
* 결정 문제 : 문제의 조건을 만족하는 해가 존재하는지의 여부를 'yes' 또는 'no'가 답하는 문제
  * 미로찾기
  * n-Queen 문제
  * Map coloring
  * 부분 집합의 합(Subset Sum)문제 등



#### 백트래킹과 깊이우선탐색과의 차이

* 어떤 노드에서 출발하는 경로가 해결책으로 이어질 것 같지 않으면 더 이상 그 경로를 따라가지 않음으로써 시도의 횟수를 줄임(Prunning 가지치기)
* 깊이우선탐색이 모든 경로를 추적하는데 비해 백트래킹은 불필요한 경로를 조기에 차단.
* 깊이우선탐색을 가하기에는 경우의 수가 너무나 많음. 즉, N!가지의 경우의 수를 가진 문제에 대해 깊이우선탐색을 가하면 당연히 처리 불가능한 문제.
* 백트래킹 알고리즘을 적용하면 일반적으로 경우의 수가 줄어들지만 이 역시 최악의 경우에는 여전히 지수함수 시간(Exponential Time)을 요하므로 처리 불가능



### 백트래킹 기법

* 어떤 노드의 유망성을 점검한 후에 유망(promising)하지 않다고 결정되면 그 노드의 부모로 되돌아가(backtracking) 다음 자식 노드로 감
* 어떤 노드를 방문하였을 때 그 노드를 포함한 경로가 해답이 될 수 없으면 그 노드는 유망하지 않다고 하며, 반대로 해답의 가능성이 있으면 유망하다고 한다.
* 가지치기(pruning) : 유망하지 않는 노드가 포함되는 경로는 더 이상 고려하지 않는다.

#### 백트래킹 절차

1. 상태 공간 트리의 깊이 우선 검색을 실시한다.
2. 각 노드가 유망한지를 점검한다.
3. 만일 그 노드가 유망하지 않으면, 그 노드의 부모 노드로 돌아가서 검색을 계속한다.

#### sudo-code

```
def checknode (v) : 	# node
if promising(v) :
	if there is a solution at V :
	else :
		for u in each child of V :
			checknode(u)
```



## 분할 정복 알고리즘

* 설계 전략
  * 분할(Divide) : 해결할 문제를 여러 개의 작은 부분으로 나눈다.
  * 정복(Conquer) : 나눈 작은 문제를 각각 해결한다.
  * 통합(Combine) : (필요하다면) 해결된 해답을 모은다.



* 거듭 제곱(Exponentiation) : O(n)

  ```python
  def Power(Base, Exponent):
      if Base == 0: return 1
      result = 1
      for i in range(Exponent):
          result *= Base
      return result
  ```

* 분할 정복 기반의 알고리즘 : O(log2n)

  ```python
  def Power(Base, Exponent):
      if Exponent == 0 or Base == 0 :
          return 1
      if Exponent % 2==0:
          NewBase = Power(Base, Exponent/2)
          return NewBase**2
      else:
          NewBase = Power(Base, (Exponent-1)/2)
          return (NewBase**2) * Base
  ```

  

## 퀵 정렬 (Quick sort)

* 주어진 배열을 두 개로 분할하고, 각각을 정렬한다.
* Merge sort와 다른 점은 그냥 두 부분으로 나누는 반면에, 퀵정렬은 분할할 때, 기준 아이템(pivot item)을 중심으로, 이보다 작은 것은 왼편, 큰 것은 오른편에 위치시킨다.
* 각 부분 정렬이 끝난 후, 합병정렬은 '합병'이란 후처리 작업이 필요하나, 퀵 정렬은 필요로 하지 않는다.

```python
def quickSort(a, begin, end):
    if begin < end:
        p = partition(a, begin, end)
        quickSort(a, begin, p-1)
        quickSort(a, p+1, end)
        
       
def partition(a, begin, end):
    pivot = (begin + end)//2
    L = begin
    R = end
    while L < R:
        while(a[L] < a[pivot] and L < R) : L += 1
        while(a[R] >= a[pivot] and L < R) : R -= 1
        if L < R:
            if L == pivot : pivot = R
            a[L], a[R] = a[R], a[L]
    a[pivot], a[R] = a[R], a[pivot]
    return R
```

