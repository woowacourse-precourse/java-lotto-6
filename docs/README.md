#### 나를 읽어요. 리드미!
# MVC2 패턴을 모방 적용하여 만들었습니다.
# 각 기능들의 의미는 패키지만 봐도 알 수 있도록 구상하고 디자인 했습니다
# 어느정도의 주석을 혼합하여 사용하였습니다.
# 주석에는 제가 학습해서 복습할 때 도움이 되도록 주석을 단 부분도 있습니다. 
----
src
└── main
└── java
└── lotto
├── controller
│   └── LottoController
├── io
│   ├── LottoInputReader
│   └── LottoPrizeResult
├── model
│   ├── dao
│   │   └── LottoDAO
│   └── dto
│       ├── BuyInfo
│       ├── Lotto
│       ├── LottoBonus
│       └── Yield
├── vo
│   └── SeasonLottoResultVO
├── service
│   ├── convert
│   │   └── ConvertService
│   └── domain
│       ├── lotto
│       │   ├── CreateAutoLottoNumber
│       │   ├── LottoIoService
│       │   └── LottoService
│       └── random
│           └── CreateRandomNumber
├── exceptionhandler
│   └── LottoErrorMessage
└── view
├── LottoOutputPrint
├── LottoResultPrint
└── Application
----
## 기능서 1
 Controller 는 main View(Application) 으로 전달 하는 역할
 Service 는 domain <-> 상호 작용을 하며, 다양한 로직을 처리 하는 형태
 ExceptionHandler 는 예외들을 받아서 처리하는 형태로 제작하고 싶었지만 기술의 부족
 - 전가시켜서 하는 방법을 구상중 
####
## 기능서 2
    LottoService : 로또와 관련된 로직들을 처리하는 형태
    Lotto Io Service : 로또의 입출력에 연결된 로직들을 처리
    
    1. 랜덤 로또 번호를 생성하는 로직 구현 / 낫이꼴 메서드 사용
    2. 랜덤 로또 번호를 필요할 때 마다 만들어 줄 객체를 생성 / 생성하면서 오름차순 정렬
    3. 원하는 값을 입력하면 입력한 횟수만큼 결과를 저장할 List<>를 생성
    4. 결과 값을 담을 객체 생성
    
    5. 유저에게 로또 6자리를 입력을 받는 Lotto 객체 구현 완료
    6. 유저에게 보너스번호를 받을 객체를 생성
    7. 유저의 구매에 관련 된 정보를 담아 둘 객체를 생성
        8. 유저의 입력 값을 변환시켜주는 클래스를 생성
        9. 유저의 입력 값과 랜덤 로또를 비교하는 클래스/메서드 생성
        10. 유저의 입력 값이 다를 시 예외를 처리하는 부분을 생성 / 루프형식
    
    11. 유저의 입력 값과 랜덤Auto 로또 번호를 비교하는 로직을 생성
    12. 유저의 보너스 번호를 랜덤Auto 번호를 비교하는 로직을 생성
    13. 유저의 총 결과 값을 저장할 수 있는 enum(열거형) 을 생성
    14. 유저의 입력한 금액과 수익을 기록할 수 있는 객체를 생성
    
    15. 유저가 입력한 금액만큼 로또의 번호를 출력해줄 출력문 생성
    16. 유저가 입력한 값이 다를 때 반복시키는 형태와 [ERROR] 출력문들을 생성
    17. 예외 문들을 필요한 부분에서 로직을 추가함
        - 일급컬렉션에서는 생성함과 동시에 예외들을 비교하기에
        - 익셉션 핸들러에 따로 익셉션을 빼야하나 고민이 들었음
    18. 익셉션 핸들러를 만들긴 했지만 애매하여 우선적으로 예외 메세지들을 상수로 담아둠
    
이 글만 읽어도 각 패키지 별 생성해둔 클래스가 무슨 역할을 하는지 알 수 있도록 제작하였음.
                    
