# HTML & CSS 스터디

* 스터디 참고 자료
  * [MDN web Docs](https://developer.mozilla.org/ko/)
  * [w3schools](https://www.w3schools.com/)

> 참고 [JSFiddle](https://jsfiddle.net/)

## HTML

> Markup language

* 태그 등을 이용하여 문서나 데이터의 구조를 명시하는 언어
* 프로그래밍 언어와





* `<span>인라인 설정 </span>` 데이터가 가지고 있는 넓이만큼
* 블록 요소



a = anchor (링크)

href = hyper reference

ul = unordered list

ol = ordered list

input =  사용자로부터 데이터를 받음 타입 지정 가능!!



h1 태크 : 블럭 속성 

span 태그 : 인라인 속성







## CSS

----

HTML이 웹 사이트에서 화면에 표시되는 정보를 약속한 것이라고 했다면 `css`는 구체적으로 어떤 스타일로 요소가 표시 되는지를 정하는 규격이라고 할 수 있다.

초기 웹은 HTML 하나로 문서의 뼈대도 만들고 꾸미기도 함께 하였지만, 공통적인 디자인을 갖는 문서가 여럿 존재할 경우 하나의 디자인이 변경되면 모드 파일을 수정해야 하는 등의 번거로움이 있었다.

CSS는 이런 문제를 해결함과 동시에 웹 페이지의 내용과 스타일(표현)을 분리하여 역할 분담도 되는 효과를 가지고 있다.



### 사용법

CSS는 내부적으로 사용되는 문법은 동일하며, 어디에 기술하느냐의 차이가 존재한다. 이를 **CSS 정의 방법**이라고 한다.

CSS 정의 방법은 3가지가 있다.

1. HTML 태그의 `style 속성`을 사용하는 **inline**

   ```html
   <body>
       <h1 style="color: blue; font-size: 100px;">    <!--body 태그 안에 style 요소-->
           hello
       </h1>
   </body>
   ```

   

2. `<style>` 태그를 통해 HTML 문서 내부에 기술 (`<style>` 태그는 주로 `<head>` 태그 내부에 사용) : **내부참조**

   ```html
   <head>
       <style>
           h1 {
               color: blue;
               font-size: 100px;
           }
       </style>
   </head>
   ```

3. `.css`파일로 분리하여 HTML 문서에 연결 : **외부 참조(link file)**





#### CSS position

* 문서 상에 요소를 배치하는 방법을 지정한다.
  * static(디폴트 값)
  * relative : 내가 원래 있어야 되는 위치로부터 이동하는 것 처럼
  * absolute : 부모를 대상으로 (절대적으로)이동
  * fixed : 무조건 고정 값 ( 스크롤을 내려도 위치는 유지 )





#### Box model 구성

* Margin : 테두리 바깥의 외부 여백,  배경색을 지정할 수 없다.
* Border : 테두리 영역
* Padding : 테두리 안쪽의 내부 여백 요소에 적용된 배경색, 이미지는 padding까지 적용
* content : 글이나 이미지 등 요소의 실제 내용



#### display

* `display : block`
  * 줄 바꿈이 일어나는 요소
  * 화면 크기 전체의 가로 폭을 차지한다.
  * 블록 레벨 요소 안에 인라인 레벨 요소가 들어갈 수 있음.

대표적인 블록레벨 요소

* div  /  ul, ol, li  / p  /  hr  /  form  /



* `display : inline`
  * 줄 바꿈이 일어나지 않는 행의 일부 요소
  * content 너비만큼 가로 폭을 차지한다.
  * `width`, `height`, `magin-top`, `margin-bottom`을 지정할 수 없다.
  * 상하 여백은 `line-height`로 지정한다.

대표적인 인라인 레벨 요소

* span  /  a  /  img  /  input,  label  /  b,  em,  i,  strong 등