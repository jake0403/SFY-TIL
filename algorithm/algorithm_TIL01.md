# Algorithm 학습 Day01

---

## 정렬



### 버블 정렬 (Bubble Sort)

* 인접한 두 개의 원소를 비교하며 자리를 계속 교환하는 방식



* 정렬 과정
  * 첫 번째 원소부터 인접한 원소끼리 계속 자리를 교환하면서 맨 마지막 자리까지 이동한다.
  * 한 단계가 끝나면 가장 큰 원소가 마지막 자리로 정렬된다.
  * 교환하며 자리를 이동하는 모습이 물 위에 올라오는 거품 모양과 같다고 하여 버블 정렬이라고 한다



* 시간 복잡도
  
* O(n^2)
  
* 예제)

  * [55, 7, 78, 12, 42]를 버블 정렬로 진행해보자.

  1. [**7**, **55**, 78, 12, 42]로 인접해 있는 7과 55를 비교하여 바꿈

     [7, **55**, **78**, 12, 42]로 55와 78을 비교했지만 그대로여서 그냥 진행

     [7, 55, **12**, **78**, 42]로 78과 12를 비교하여 바꿈

     [7, 55, 12, **42**, **78**]로 78과 42를 비교하여 바꿈

  2. [7, **12**, **55**, 42, 78]로 55와 12를 비교하여 바꿈

     [7, 12, **42**, **55**, 78]로 55와 42를 비교하여 바꿈

     [7, 12, 42, **55**, **78**]로 55와 78을 비교했지만 그대로여서 그냥 진행

  3. [7, **12**, **42**, 55, 78]에서는 12와 42를 비교하지만 변화가 없으므로 그대로 진행

  4. [**7**, **12**, 42, 55, 78]에서는 7과 12를 비교하여 변화가 없으므로 그대로 진행.

  5개의 요소를 버블 정렬을 진행할 때는 4개의 cycle만 진행하면 됨.

  **버블 정렬은 끝자리의 숫자를 정하는 것임**

* 소스코드

  ```python
  def BubbleSort(a) : # 정렬할 List
      for i in range(len(a)-1, 0, -1):	#범위의 끝 위치
          for j in range(0,i) :
              if a[j] > a[j+1]:
                  a[j], a[j+1] = a[j+1], a[j]
  ```

  



### 카운팅 정렬 (Counting Sort)

* 항목들의 순서를 결정하기 위해 집합에 각 항목이 몇 개씩 있는지 세는 작업을 하여, 선형 시간에 정렬하는 효율적인 알고리즘
* 보통 정렬할 값이 양의 정수이고, 자료의 범위를 알고 있을 때 사용한다.

* 제한 사항
  * 정수나 정수로 표현할 수 있는 자료에 대해서만 적용 가능 : 각 항목의 발생 회수를 기록하기 위해, 정수 항목으로 인덱스 되는 카운트들의 배열을 사용하기 때문이다.
  * 카운트들을 위한 충분한 공간을 할당하려면 집합 내의 **가장 큰 정수를 알아야 한다.**

* 시간 복잡도
  * O(n + k) : n은 리스트의 길이, k는 정수의 최대값

* 예제 [0, 4, 1, 3, 1, 2, 4, 1]
  * 우선 count라는 배열을 하나 생성한다.





### 완전 검색 (Exhaustive Search)

* 완전 검색 방법은 문제의 해법으로 생각할 수 있는 모든 경우의 수를 나열해보고 확인하는 기법이다.

* Brute-force 혹은 Generate-and-Test 기법이라고도 불리 운다.

* 모든 경우의 수를 테스트한 후, 최종 해법을 도출한다.

* 일반적으로 경우의 수가 상대적으로 작을 때 유용하다.

* 주어진 문제를 풀 때, 우선 완전 검색으로 접근하여 해답을 도출한 후, 성능 개선을 위해 다른 알고리즘을 사용하고 해답을 확인하는 것이 바람직하다.





### 탐욕(Greedy) 알고리즘

* 탐욕 알고리즘은 최적해를 구하는 데 사용되는 근시안적인 방법
* 여러 경우 중 하나를 결정해야 할 때마다 그 순간에 최적이라고 생각되는 것을 선택해 나가는 방식으로 진행하여 최종적인 해답에 도달한다.
* 각 선택의 시점에서 이루어지는 결정은 지역적으로는 최적이지만, 그 선택들을 계속 수집하여 최종적인 해답을 만들었다고 하여, 그것이 최적이라는 보장은 없다.
* 일반적으로, 머릿속에 떠오르는 생각을 검증 없이 바로 구현하면 Greedy 접근이 된다.
* 탐욕 알고리즘의 동작 과정
  1. **해 선택** : 현재 상태에서 부분 문제의 최적 해를 구한 뒤, 이를 부분해 집합(Solution Set)에 추가한다.
  2. **실행 가능성 검사** : 새로운 부분해 집합이 실행 가능한지를 확인한다. 곧 문제의 제약 조건을 위반하지 않는지를 검사한다.
  3. **해 검사** : 새로운 부분해 집합이 문제의 해가 되는지를 확인한다. 아직 전체 문제의 해가 완성되지 않았다면 1)의 해 선택부터 다시 시작한다.
