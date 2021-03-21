# Queue

---

* 큐의 특성
  * 스택과 마찬가지로 삽입과 삭제의 위치가 제한적인 자료구조
    - 큐의 뒤에서는 삽입만 하고, 큐의 앞에서는 삭제만 이루어지는 구조
  * 선입 선출 구조 (FIFO : First In Firtst Out)



* 큐의 기본 연산

  * 삽입 : enQueue
  * 삭제 : deQueue

* 큐의 주요 연산

  

  |     연산      | 기능 |
  | :-----------: | :--: |
  | enQueue(item) |      |
  |               |      |
  |               |      |
  |               |      |
  |               |      |
  |               |      |

  

선형 큐

* 1차원 배열을 이용한 큐
  * 큐의 크기 = 배열의 크기
  * front : 마지막에 꺼내진 원소의 인덱스
  * rear : 저장된 마지막 원소의 인덱스