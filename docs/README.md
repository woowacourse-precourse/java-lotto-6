#### 나를 읽어요. 리드미!
# 구성은 이렇게 생겼어요! 
# src
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
####
## Controller 는 main View(Application) 으로 전달 하는 역할
## Service 는 domain <-> 상호 작용을 하며, 다양한 로직을 처리 하는 형태
# ExceptionHandler 는 예외들을 받아서 처리하는 형태로 제작하고 싶었지만
# - 코드가 완성 되면, 분리 해야 하는 기능으로 인식함
####
# 이번 회차는 1주차 2주차 리뷰를 보고 이쁘다 싶은 것은 다 시도를 하였습니다.
####
