# PyTorch 텐서 조작하기_01

---

Pytorch의 Tensor를 조작하기 전에 Numpy에 대해서 알아보자.

Numpy는 n-차원 배열 객체와 이러한 배열들을 조작하기 위한 다양한 함수들을 제공한다. Numpy는 연산 그래프(computation graph)나 딥러닝, 변화도(Gradient)에 대해서는 알지 못한다. 하지만 Numpy 연산을 사용하여 신경망의 순전파 단계와 역전파 단계를 직접 구현함으로써, 3차 다항식이 사인(sine)함수에 근사하도록 만들 수 있다.

**Numpy 예제**

```python
import numpy as np
import math

# 입력과 출력 데이터 무작위 생성
x = np.linspace(-math.pi, math.pi, 2000)
y = np.sin(x)

# 무작위로 weight 초기화
a = np.random.randn()
b = np.random.randn()
c = np.random.randn()
d = np.random.randn()

# 학습률 (0.000001)
learning_rate = 1e-6

for t in range(2000):
    # Forward propagation(순전파) => 예측값 y를 계산
    # y = a + b x + c x^2 + d x^3
    y_pred = a + b*x + c*x**2 + d*x**3
    
    # 손실(loss)을 계산하고 출력
    # np.square는 배열의 원소들을 제곱해서 나타낼 수 있음
    # 손실 = 예측 값 - 실제 값
    loss = np.square(y_pred - y).sum()
    if t % 100 == 99:
        print(t, loss)
        
    # 손실에 따른 a, b, c, d의 변화도(gradient)를 계산하고 역전파(back propagation)함.
    grad_y_pred = 2.0 * (y_pred - y)
    grad_a = grad_y_pred.sum()
    grad_b = (grad_y_pred * x).sum()
    grad_c = (grad_y_pred * x ** 2).sum()
    grad_d = (grad_y_pred * x ** 3).sum()
    
    # 가중치를 갱신
    a -= learning_rate * grad_a
    b -= learning_rate * grad_b
    c -= learning_rate * grad_c
    d -= learning_rate * grad_d
    
    
    print(f'Result: y = {a} + {b} x + {c} x^2 + {d} x^3')
    #####################################################
    # Result: y = 0.008108495148374492 + 0.8309440182063866 x + -0.001398850339036266 x^2 + -0.08966101534393887 x^3
```



### Pytorch : Tensor

numpy는 GPU를 사용하여 수치 연산을 가속화할 수는 없다. 따라서 Pytorch의 Tensor를 활용할 것이다. GPU를 사용하고 안 하고에 따라 50배 이상의 속도 차이가 나기 때문이다. Pytorch의 Tensor는 개념적으로 Numpy 배열과 동일하다. Tensor는 n-차원의 배열이며, Pytorch는 이러한 텐서들의 연산을 위해 다양한 기능들을 제공한다.

**Pytorch Tensor를 사용한 3차 다항식을 sine 함수에 근사하게 적용**

```python
import torch
import math

dtype = torch.float
# device = torch.device("cpu")    # cpu에서 실행
device = torch.device("cuda:0")    # gpu에서 실행


# 무작위 데이터 생성
x = torch.linspace(-math.pi, math.pi, 2000, device=device, dtype=dtype)
y = torch.sin(x)

# 무작위 가중치 초기화
a = torch.randn((), device=device, dtype=dtype)
b = torch.randn((), device=device, dtype=dtype)
c = torch.randn((), device=device, dtype=dtype)
d = torch.randn((), device=device, dtype=dtype)

learning_rate = 1e-06
for t in range(2000):
    y_pred = a + b*x + c*x**2 + d*x**3
    # 손실(loss)을 계산하고 출력
    loss = (y_pred - y).pow(2).sum().item()
    if t % 100 == 99:
        print(t, loss)

    # 손실에 따른 a, b, c, d의 변화도(gradient)를 계산하고 역전파
    grad_y_pred = 2.0 * (y_pred - y)
    grad_a = grad_y_pred.sum()
    grad_b = (grad_y_pred * x).sum()
    grad_c = (grad_y_pred * x ** 2).sum()
    grad_d = (grad_y_pred * x ** 3).sum()

    # 가중치를 갱신
    a -= learning_rate * grad_a
    b -= learning_rate * grad_b
    c -= learning_rate * grad_c
    d -= learning_rate * grad_d


print(f'Result: y = {a.item()} + {b.item()} x + {c.item()} x^2 + {d.item()} x^3')
    
```





## 1. 벡터, 행렬 그리고 텐서 (Vector, Matrix and Tensor)

----



딥 러닝을 하게 되면 다루게 되는 가장 기본적인 단위는 벡터, 행렬, 텐서이다.

 차원이 없는 값을 스칼라 

1차원으로 구성된 값을 벡터라고 한다.

2차원으로 구성된 값을 행렬(Matrix)라고 한다.

그리고 3차원이 되면 Tensor라고 부른다.