## MVC Model Study

Model, View, Controller, User가 서로 작용하는 모델 구조이다.
View -> User -> Controller -> Model -> View

Model : 
- 모든 데이터를 가지고 있어야한다
- 독립적이어야 한다.
==> 내가 알고 있던 service, DAO의 개념이다.
- DTO는 데이터의 폼이다

Controller :
client의 요청을 받아 model에서의 값을 바꾸거나 행위를 한다.

View :
값을 가져다가 출력한다.


사용하는 이유 : 
- 프로젝트의 분업화를 위해서
- 대규모 프로젝트를 진행시에는 일의 효율을 위해서 분업을 하게 되는데, 각각의 기능이 중복되어 개발되지 않도록 한다.
- 또한 프로젝트의 값들이 꼬이지 않게된다.
- 이로써 프로젝트의 확장성과 유연성에서 이득을 본다.
- 