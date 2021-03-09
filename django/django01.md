# Django 01 

---

## Python Web Framework

* Why django?
  * Ridiculosuly fast
  * Fully loaded
  * Reassuringly secure
  * Exceedingly scalable
  * Incredibly versatile
* django는 Python으로 작성된 오픈소스 웹 어플리케이션 프레임워크로, MVC(MTV) 모델 패턴을 따르고 있다.
* Model => 데이터베이스 관리
* Template => 레이아웃(화면)
* View => 중심 컨트롤러(심장)

![image-20210308092010163](django01.assets/image-20210308092010163.png)



### 프로젝트 생성

```bash
$ django-admin startproject 프로젝트 이름			# 프로젝트 생성

$ python manage.py runserver					# 서버 가동

$ python manage.py startapp 앱 이름			    # 앱 이름 관련 MTV 파일 생김
```



## Template

> Django Template Language ( DTL )



1. App 이름은 복수형
2. App 생성(startapp) 후 등록