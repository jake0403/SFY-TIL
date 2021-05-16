# JavaScript 01

---



## DOM

* HTML, XML 등과 같은 문서를 다루기 위한 언어 독립적인 문서 모델 인터페이스
* 문서를 구조화하고 구조화된 구성 요소를 하나의 객체로 취급하여 다루는 **논리적 트리 모델**
* 문서가 구조화되어 있으며 각 요소는 객체(object)로 취급
* 단순한 속성 접근, 메서드 활용 뿐만 아니라 프로그래밍 언어적 특성을 활용한 조작 가능
* 주요 객체
  * window : DOM을 표현하는 창, 가장 최상위 객체(생략 가능)
  * document : 페이지 콘텐츠의 Entry Point 역할을 하며, <body> 등과 같은 수많은 다른 요소들을 포함
  * navigator, location, history, screen



## BOM

* Browser Object Model
* 자바스크립트가 브라우저와 소통하기 위한 모델
* 브라우저의 창이나 프레임을 추상화해서 프로그래밍적으로 제어할 수 있도록 제공하는 수단
  * Button, URL 입력창, 타이틀 바 등 브라우저 윈도우 및 웹 페이지의 일부분을 제어 가능
* Window 객체는 모든 브라우저로부터 지원받으며 브라우저 window 자체를 지칭



## DOM 조작 - 개념

* Document는 문서 한 장(HTML)에 해당하고 이를 조작
* DOM 조작 순서
  1. 선택 (Select)
  2. 변경 (Manipulation)



## DOM 관련 객체의 상속 구조

* **EventTarget**
  * Event Listener를 가질 수 있는 객체가 구현하는 DOM 인터페이스
* **Node**
  * 여러 가지 DOM 타입들이 상속하는 인터페이스
* **Element**
  * Document 안의 모든 객체가 상속하는 가장 범용적인 기반 클래스
  * 부모인 Node와 그 부모인 EventTarget의 속성을 상속
* **Document**
  * 브라우저가 불러온 웹 페이지를 나타냄
  * DOM 트리의 진입점(entry point) 역할을 수행
* **HTMLElement**
  * 모든 종류의 HTML 요소
  * 부모인 element 속성 상속



## DOM 선택 - 선택 관련 메서드

* **Document.querySelector( )**
  * 제공한 선택자와 일치하는 element 하나 선택
  * 제공한 CSS selector를 만족하는 첫 번째 element 객체를 반환 (없다면 null)
* **Document.querySelectorAll( )**
  * 제공한 선택자와 일치하는 여러 element를 선택
  * 매칭할 하나 이상의 셀렉터를 포함하는 유효한 CSS selector를 인자(문자열)로 받음
  * 지정된 셀렉터에 일치하는 NodeList를 반환

이 외에도 `getElementById()`, `getElementsByTagName()`, `getElementsByClassName()` 등 선택 관련 메서드가 존재하지만 `querySelector`를 사용하는 이유는 더 구체적이고 유연하게 선택이 가능하기 때문이다.



## DOM 선택 - 선택 메서드별 반환 타입

* **단일 element**
  * getElementById()
  * querySelector()
* **HTMLCollection (live collection)**
  * getElementsByTagName()
  * getElementsByClassName()
* **NodeList(static collection)**
  * querySelectorAll()



## HTML Collection과 NodeList

* 둘 다 배열과 같이 각 항목을 접근하기 위한 인덱스를 제공 (유사 배열)
* **HTMLCollection**
  * name, id, 인덱스 속성으로 각 항목들에 접근 가능

* **NodeList**
  * 인덱스 번호로만 각 항목들에 접근 가능
  * 단, HTMLCollection과 달리 배열에서 사용하는 for each 함수 및 다양한 메서드 사용 가능
* 둘 다 Live Collections으로 DOM의 변경사항을 실시간으로 반영하지만, `querySelectorAll()`에 의해 반환되는 NodeList는 Static Collection



## DOM 선택 - Collection

* **Live Collection**
  * 문서가 바뀔 때 실시간으로 업데이트
  * DOM의 변경사항을 실시간으로 collection에 반영
  * ex) HTMLCollection, NodeList
* **Static Collection**(non - live)
  * DOM이 변경되어도 collection 내용에는 영향을 주지 않음
  * querySelectorAll()의 반환 NodeList만 static



## DOM 변경 - 변경 관련 메서드

* **Document.createElement( )**
  * 주어진 태그명을 사용해 HTML 요소를 만들어 반환
* **ParentNode.append( )**
  * 특정 부모 노드의 자식 노드 리스트 중 마지막 자식 다음에 Node 객체나 DOMString을 삽입(반환값 없음)
  * **여러 개의 Node** 객체, DOMString을 추가할 수 있음
* **Node.appendChild( )**
  * **한 노드**를 특정 부모 노드의 자식 노드 리스트 중 마지막 자식으로 삽입 (Node만 추가 기능)
  * 만약 주어진 노드가 이미 문서에 존재하는 다른 노드를 참조한다면 새로운 위치로 이동
* **ChildNode.remove( )**
  * 이를 포함하는 트리로부터 특정 객체를 제거
* **Node.removeChild( )**
  * DOM에서 자식 노드를 제거하고 제거된 노드를 **반환** (변수 값으로 사용 가능)
  * Node는 인자로 들어가는 자식 노드의 **부모 노드**
* **Element.setAttribute(name, value)**
  * 지정된 요소의 값을 설정
  * 속성이 이미 존재하면 값을 업데이트, 그렇지 않으면 지정된 이름과 값으로 새 속성 추가
* **Element.getAttribute()**
  * 해당 요소의 지정된 값(문자열)을 반환
  * 인자는 값을 얻고자 하는 속성의 이름



## DOM 변경 - 변경 관련 속성 (property)

* **Node.textContent**
  * 노드와 그 자손의  텍스트 컨텐츠(DOMString)를 표현(해당 요소 내부의 raw text)
  * 노드의 모든 요소 컨텐츠를 가져옴
* **Node.innerText**
  * textContent와 동일하지만 raw text가 최종적으로 렌더링 된 모습을 표현(사람이 읽을 수 있는 요소만 남김)
  * 즉, 줄 바꿈을 인식하고 숨겨진 내용을 무시하는 등 최종적으로 스타일링이 적용된 모습으로 표현
* **Node.innerHTML**
  * 요소(element) 내에 포함된 HTML 마크업을 반환
  * XSS 공격에 취약점이 있으므로 사용시 주의

## Event

* 네트워크 활동 혹은 사용자와의 상호작용 같은 사건의 발생을 알리기 위한 객체
* 이벤트는 마우스를 클릭하거나 키보드를 누르는 등 사용자 행동에 의해 발생할 수도 있고, 특정 메서도를 호출(HTMLElement.click() )하여 프로그래밍적으로도 만들어낼 수 있음
* 이벤트 처리기(Event - handler)
  * EventTarget.addEventListener()
  * 해당 메서드를 통해 다양한 요소에서 이벤트를 붙일 수 있음
  * removeEventListener()를 통해 이벤트를 제거 가능

### Event 기반 인터페이스

* AnimationEvent, ClipboardEvent, DragEvent 등
* 그 중에서도 'UIEvent'
  * 간단한 사용자 인터페이스 이벤트
  * Event의 상속을 받음
  * MouseEvent, KeyboardEvent, InputEvent, ForcusEvent 등의 부모 객체 역할을 함



### Event handler

* **EventTarget.addEventListener(type, listener)**
* 지정한 이벤트가 대상에 전달될 때마다 호출할 함수를 설정
* 이벤트를 지원하는 모든 객체(Element, Document, Window 등)를 대상으로 지정 가능
* target.addEventListener(type, listener[, options])
  * type : 반응할 이벤트 유형(대소문자 구분 문자열)
  * listener : 지정된 타입의 이벤트가 발생했을 때 알림을 받는 객체
  * EventListener 인터페이스 혹은 JS function 객체(콜백 함수)여야 함

