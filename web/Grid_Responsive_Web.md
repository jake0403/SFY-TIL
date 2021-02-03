# CSS Layout

---

## Grid / Responsive Web



> CSS layout : 웹 페이지에 포함되는 요소들을 취합하고, 그것들이 어느 위치에 놓일 것인지를 제어하는 기술

### Float

* Float된 이미지 좌, 우측 주변으로 텍스트를 둘러싸는 레이아웃을 위해 도입
* 더 나아가 이미지가 아닌 다른 요소들에도 적용해 웹 사이트의 전체 레이아웃을 만드는데까지 발전
  * none : 기본값
  
  * left : 요소를 왼쪽으로 띄움
  
    ```html
    <!--ex-->
    <style>
        .left {
            float: left;
        }
    </style>
    ```
  
    
  
  * right : 요소를 오른쪽으로 띄움
  
    ```html
    <style>
        .right {
            float: right;
        }
    </style>
    ```
  
    

* clearfix => float으로 인해 box가 뜨면 그 공간에 겹쳐 있던 다른 박스가 위로 올라오게 됨 그것을 방지하고자 보이지 않는 막으로 올라오지 못하게 막음

  * clearfix는 style 태그 안에 `.clearfix ::after {  }`로 정한다.
  * `<header>`의 클래스로 `clearfix`로 정하고 해당 box를 감싸준다.

  ```html
  <style>
      .clearfix::after {
          content: "";
          display: block;
          clear : both;
      }
  </style>
  
  
  <!-- 바디 태그 안-->
  
  <head class="clearfix">
      <div class = "box1">
          상자 1
      </div>
  </head>
  
  ```

  



### Flexbox

* 요소 간 공간 배분과 정렬 기능을 위한 1차원(단방향) 레이아웃

* 크게 두 가지만 기억하면 됨!

  * 요소
    * Flex Container (부모 요소) 부모를 통해서 모든 걸 결정
    * Flex Item (자식 요소)
  * 축
    * main axis(메인 축 (왼에서 오로))
    * cross axis(교차 축)

  

  **flex 자체는 block 요소임**

  

### flexbox의 시작

```html
<style>
    .flex-container {
        display: flex;
    }
</style>
```



### flexbox

> content & items & self

* content : 여러 줄
* items : 한 줄
* self : flex item 개별 요소





**flex에 적용하는 속성**

* 배치 방향 설정

  * `flex-direction`
    * row
    * row-reverse
    * column
    * colunm-reverse
* 메인축 방향 정렬

  * `justify-content`
    * flex-start (default)
    * flex-end
    * center
    * space-between
    * space-around
* 교차축 방향 정렬

  * `align-items`, `align-self`, `align-content`
  * stretch (default)
    * flex-start
    * flex-end
    * center
    * space-between
    * space-around
  
* `flex-flow` : `flex-direction`과 `flex-wrap`을 간략히 한 속성
* `order` : flex 요소의 순서를 정함 (default = 0)











# Grid system

---

* Bootstrap Grid System은 flexbox로 제작됨
* container, rows, column으로 컨텐츠를 배치하고 정렬
* 반드시 기억해야 할 2 가지!
  1. 12개의 column		=> 약수가 많아서 (12)
  2. 6개의 gird breakpoints

```html
<div class="container">
    <div class="row">
        <div class="col"></div>
        <div class="col"></div>
        <div class="col"></div>
    </div>
</div>
```

