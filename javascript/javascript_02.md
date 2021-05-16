# JavaScript_02

---

## ECMAScript 6



## 변수와 식별자



### 식별자 작성 스타일

* 카멜 케이스 (camelCase)
  * 변수, 객체, 함수에 사용
* 파스칼 케이스 (PascalCase)
  * 클래스, 생성자에 사용 (class JavaScript(), new JavaScript() )
* 대문자 스네이크 케이스 (SNAKE_CASE)
  * 상수(constant)에 사용



## 함수 활용법

### 함수 선언식

- 함수의 이름과 함께 정의하는 방식

- 3가지 부분으로 구성

  - 함수의 이름(name)
  - 매개변수(args)
  - 몸통(중괄호 내부)

- ```javascript
  function name(args) {
      // do something
  }
  ```

  

- ```javascript
  function add(num1, num2){
      return num1 + num2
  }
  const result = add(1,2)
  console.log(result)
  ```





### 함수 표현식

* 함수를 표현식 내에서 정의하는 방식

* 함수의 이름을 생략하고 익명 함수로 정의 가능

* 3가지 부분으로 구성

  * 함수의 이름
  * 매개변수
  * 몸통( 중괄호 내부 )

* ```javascript
  const myFunction = function (args){
      //do something
  }
  ```

  

* ```javascript
  const add = function (num1, num2){
      return num1 + num2
  }
  const result = add(1,2)
  console.log(result)
  ```

  

## 호이스팅



### 함수 선언식

* 함수 선언식으로 선언한 함수는 var로 정의한 변수처럼 hoisting 발생
* 함수 호출 이후에 선언해도 동작



### 함수 표현식

* 반면 함수 표현식으로 선언한 함수는 함수 정의 전에 호출 시 에러 발생
* 함수 표현식으로 정의된 함수는 변수로 평가되어 변수의 scope 규칙을 따름





## 배열 (Arrays)

----

### 배열의 정의와 특징

* 키와 속성들을 담고 있는 참조 타입의 객체(object)
* **순서를 보장하는 특징이 있음**
* 주로 대괄호를 이용하여 생성하고, 0을 포함한 양의 정수 인덱스로 특정 값에 접근 가능
* 배열의 길이는 **array.length 형태**로 접근 가능



### 배열 관련 주요 메서드

* **reverse**

```javascript
// arrary.reverse() => 원본 배열의 요소를 반대로 정렬
const numbers = [1,2,3,4,5]
numbers.reverse()
// [5,4,3,2,1]
```



* **push & pop**

```javascript
const numbers = [1,2,3,4,5]
numbers.push(100)
//[1,2,3,4,5,100]
numbers.pop()
// [1,2,3,4,5]
```



* **unshift & shift**

```javascript
// arrary.unshift() => 배열의 가장 앞에 요소 추가
// arrary.shift() => 배열의 첫 번째 요소 제거 === pop(0)
const number = [1,2,3,4,5]
```



* **includes**

```javascript
const number = [1,2,3,4,5]

console.log(numbers.includes(1)) // true
console.log(numbers.includes(100)) // false

```



* **indexOf**

```javascript
// array.indexOf(value)
// 배열에 특정 값이 존재하는지 확인 후 가장 첫 번째로 찾은 요소의 인덱스 반환
// 해당 값이 없으면 -1 반환

const numbers = [1,2,3,4,5]
let result

result = numbers.indexOf(3)		// 2
result = numbers.indexOf(6)		// -1
```





### 배열 관련 심화 메서드 목록

* 배열을 순회하며 특정 로직을 수행하는 메서드
* 메서드 호출 시 인자로 **callback 함수**를 받는 것이 특징



* **for each**
  * 배열의 각 요소에 대해 콜백 함수를 한 번씩 실행
  * 콜백 함수는 3가지 매개변수로 구성
    * element : 배열의 요소
    * index : 배열 요소의 인덱스
    * array : 배열 자체
  * **반환 값이 없는 메서드**

```javascript
const district = ['서울', '광주', '대전', '구미', '부산']

district.forEach((region, idx)=>{
    console.log(region, idx)
    // 서울 0
    // 광주 1
    //	...
    // 부산 4
})
```

