# 06_인공지능 CNN(Convolution Neural Networks)

---

## Fully Connected Layer VS Locally Connected Neural Networks

![Deep Learning 05: Talk about Convolutional Neural Networks（CNN）](06_인공지능 CNN(Convolution Neural Networks).assets/cnn1.png)

* Convolution 뉴런은 Perceptron의 일반화 된 형태
  * Local 연산을 학습
  * Parameter 공유

Fully Connected Layer는 하나의 Feature를 뽑기 위해서(하나의 hidden node를 정의하기 위해서) 모든 연결 즉, 모든 Data들을 활용한다. 하지만 CNN의 전 단계인 Locally Connected Neural Network에서는 한 국부적인 영역 내에서만 정의를 한다. 따라서 학습해야 하는 Parameter 수가 줄어들게 될 뿐만 아니라 해당 영역을 재사용할 수 있다. 이러한 영역을 **Receptive field = filter**라고 하는 하이퍼파라미터이다.

### CNN의 Keywords

* CNN의 구성 layers
  * Convolution Layer
  * Pooling Layer
  * Activation Function(Hidden nodes, Feature, Neurons)

![CNN, Convolutional Neural Network 요약](06_인공지능 CNN(Convolution Neural Networks).assets/head.png)



### Convolution Layer

* 행렬 내적
* filter
* stride
* padding

행렬 내적이 필요한 이유는 filter 사이즈에 맞게 해당 input 값에 대한 행렬 내적 값을 연산하기 때문이다. 연산한 값은 hidden layer에 전달하게 된다.

stride는 filter가 한 번의 연산을 끝내고 얼만큼 이동할지를 나타내는 수치이다.

padding은 input 값의 주위에 0을 넣어 공간을 크게 만들 때 사용한다.



### Pooling layer

데이터가 축소나 확대(Scale)가 되었을 때 고려할 수 있는 Layer가 Pooling Layer이다. 많이 쓰이는 Pooling Layer는 Max Pooling 또는 Average Pooling을 사용한다. filter에서 가장 큰 값을 가져오는 것을 max Pooling, filter의 평균 값을 가져오는 것을 average Pooling이라고 한다.



### Fully Connected Layer

![image-20210902135813144](06_인공지능 CNN(Convolution Neural Networks).assets/image-20210902135813144.png)

모든 Input에 대해 고려한 결과이기 때문에 fully connected layer로 볼 수 있다.