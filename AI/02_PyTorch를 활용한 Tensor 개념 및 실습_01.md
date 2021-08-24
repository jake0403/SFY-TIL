# PyTorch를 활용한 Tensor 개념

---

### PyTorch란?

> PyTorch는 Python을 위한 오픈소스 머신 러닝 라이브러리이다. Torch를 기반으로 하며, 자연어 처리와 같은 애플리케이션을 위해 사용된다. GPU 사용이 가능하기 때문에 속도가 상당히 빠르고 Tensorflow의 사용자도 많지만, 비관적인 구조와 난이도 때문에 Pytorch 사용자도 늘어나고 있는 추세이다.

PyTorch에는 두 가지 주요한 특징이 있다.

* Numpy와 유사하지만 GPU 상에서 실행 가능한 n-차원 Tensor (50배 이상 차이)
* 신경망을 구성하고 학습하는 과정에서의 자동 미분 (Automatic differentiation)



## PyTorch 패키지의 기본 구성

### 1. Torch

- 메인 네임스페이스이다. 텐서 등의 다양한 수학 함수가 포함되어져 있으며 Numpy와 유사한 구조를 가진다.

### 2. torch.autograd

* 자동 미분을 위한 함수들이 포함되어져 있다. 자동 미분의 on/off를 제어하는 콘텍스트 매니저 (enable_grad / no_grad)나 자체 미분 가능 함수를 정의할 때 사용하는 기반 클래스인 `Function` 등이 포함되어져 있다.

### 3. torch.nn

* 신경망을 구축하기 위한 다양한 데이터 구조나 레이어 등이 정의되어져 있다. 예를 들어 RNN, LSTM과 같은 레이어, ReLu와 같은 활성화 함수, MSELoss와 같은 손실 함수들이 있다.

### 4. torch.optim

- 확률적 경사 하강법(Stochastic Gradient Descent, SGD)를 중심으로 한 파라미터 최적화 알고리즘이 구현되어져 있다.

### 5. torch.utils.data

- SGD의 반복 연산을 실행할 때 사용하는 미니 배치용 유틸리티 함수가 포함되어져 있다.

### 6. torch.onnx

- ONNX(Open Neural Network Exchange)의 포맷으로 모델을 export할 때 사용한다. ONNX는 서로 다른 딥 러닝 프레임워크 간에 모델을 공유할 때 사용하는 포멧이다.

