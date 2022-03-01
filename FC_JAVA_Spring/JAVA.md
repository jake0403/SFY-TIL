# JAVA

---

### JDK (Java Development Kit)

- 자바에서 제공되는 개발용 라이브러리

### JRE(Java Runtime Environment)

* 자바 프로그램이 실행되는 환경

### JVM(Java Virtual Machine)

- 자바 가상 머신으로 프로그램이 실행되는 환경인 JRE가 설치되어 있어야 함



자바에서 10진수 10을  2진수, 8진수, 16진수로 사용하려면 다음과 같은 선언이 필요하다.

```java
int num = 10;
int bNum = 0b1010;
int oNum = 012;
int xNum = 0XA;
```



## 자료형

(맨날 헷갈림....)

### 자료형 종류

|        | 정수형 | 문자형 | 실수형 | 논리형  |
| :----: | :----: | :----: | :----: | :-----: |
| 1 byte |  byte  |        |        | boolean |
| 2 byte | short  |  char  |        |         |
| 4 byte |  int   |        | float  |         |
| 8 byte |  long  |        | double |         |



### 문자

**'** single Quotation을 사용해서 씀. **"** double Quotation은 문자열임(String Class)



### 지역 변수 (Local Variable)

java 10버전 부터는 지역변수를 선언할 수 있고 사용이 가능하다.

```java
package ch01;

public class LocalVariable {
	
	public static void main(String [] args) {
		
		var i = 10;
		var j = 10.0;
		var str = "test";
		
		System.out.println(i);			// 10
		System.out.println(j);			// 10.0
		System.out.println(str);		// test
		
		var str2 = str;
		System.out.println(str2);		// test
		
		str = "test123";
		System.out.println(str);
		// str = 3; 	=> 이미 선언된 지역변수는 변경이 type 변경이 불가능하다.
		System.out.println(str2);
		
	}

}

/*
10
10.0
test
test
test123
test
*/
```







### 변하지 않는 상수와 리터럴, 변수의 형 변환



* 상수는 변하지 않는 수
* `final` 예약어를 사용하여 선언
* 상수를 사용하면 변하지 않는 값을 반복하여 사용할 때 의미있는 문자로 인식하기 쉽고
* 혹, 변하더라도 선언한 부분만 변경하면 되므로 여러부분을 수정할 필요가 없음
* 상수는 대게 모두 대문자로 선언함

```java
package ch01;

public class ConstantTest {
	
	public static void main(String [] args) {
		
		final int MAX_NUM = 100;
		final int MIN_NUM;
		
		MIN_NUM = 0;
		
		System.out.println(MAX_NUM);
		System.out.println(MIN_NUM);
		
		// MAX_NUM = 1000;	=> 오류 발생
	}

}
```



### 리터럴(Literal)

* 프로그램에서 사용하는 숫자, 문자, 논리값을 뜻함

* 리터럴은 상수 풀(Constant Pool)에 있음

  > 하드 디스크에서 프로그램을 실행할 때 메모리로 load를 하게 된다. 이 때 프로그램 안에 있는 자료들의 일부는 메모리를 할당 받는 것들이 있다. 물론 코드들이 실행되면서 메모리를 할당받는 자료들도 있지만 프로그램이 실행되면서 메모리를 잡아두는 것을 `Data영역` 또는 `Constant Pool`이라고 한다. 여기에 들어가는 것들은 **리터럴(Literal)**과 **Static**이 있다.



* 정수 리터럴은 int로 실수 리터럴은 double로 저장됨

```java
package ch01;

public class TypeConversionTest {
	
	public static void main(String [] args) {
		
		byte bNum = 10;
		int num = bNum;
		
		System.out.println(bNum);
		System.out.println(num);
		
		
		int mNum = 255;
		byte mbNum = (byte)mNum;
		
		System.out.println(mNum);
		System.out.println(mbNum);		// 강제 형변환
		
		double dNum = 1.2;
		float fNum = 0.9f;
		
		int num1 = (int) (dNum + fNum);
		int num2 = (int)dNum + (int)fNum;
		
		System.out.println(num1);
		System.out.println(num2);
		
	}

}
```





## 논리 연산에서 모든 항이 실행되지 않는 경우  - 단락 회로 평가 (short circuit evaluation)



* 논리 곱(&&)은 두 항의 결과가 모두 True일 때만 결과가 True이다.
  * 따라서 앞의 항의 결과가 false이면 뒤 항의 결과를 평가하지 않는다.
* 논리 합(||)은 두 항의 결과가 모두 false일 때만 결과가 false이다.
  * 따라서 앞의 항의 결과가 True 이면 뒤 항의 결과를 평가하지 않는다.

```java
package ch01;

public class LogicalTest {

	public static void main(String[] args) {
		
		int num1 = 10;
		int i = 2;
		
		boolean value = ((num1 += 10) < 10) && ((i += 2) < 10); // 앞에가 false이므로 뒤에 값 계산 X
		System.out.println(value);		// false
		System.out.println(num1);		// 20
		System.out.println(i);			// 2
		
		int num2 = 10;
		int j = 2;
		
		boolean value2 = (((num2+=10) < 10 ) || ((j+=2) < 10)); // 앞에 값이 false여도 뒤에 계산
		System.out.println(value2);		//True
		System.out.println(num2);		// 20
		System.out.println(j);			// 4
	}

}
```



## for문의 문장들은 생략 가능

---

* 초기화식 생략 : 이미 이전에 값이 초기화 되어 for문 내부에서 값을 지정할 필요가 없는 경우

``` java
int i = 0;

for( ; i < 5; i++ ) {
    ....
}
```



* 조건식 생략 : 반복 수행에 대한 조건이 수행문 내부에 있는 경우

```java
for(i = 0; ; i++){
    sum += i;
    if(sum > 200) break;
}
```



* 증감식 생략 : 증감식에 대한 연산이 복잡하거나 다른 변수의 연산 결과값에 결정되는 경우

```java
for(i = 0; i < 5; ){
    ...
    i = (++i) % 10;
}
```



* 무한 반복

```java
for( ; ; ) {
    ...
    //무한반복
}
```

