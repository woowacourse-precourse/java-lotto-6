Model → Lotto.java

- 유저가 입력하는 로또와 컴퓨터의 출력 로또가 공통적으로 가지고 있는 특징
- Lotto 관련 validation
  - 로또 입력이 1~45 사이의 숫자가 아닐 경우
  - 로또 입력이 6개의 숫자를 넘어가는 경우 (,의 개수로 판별 가능)
  - 한 라인에 중복안됨
- 보너스 번호

View

- InputView
    - ~~requestPrice()~~
    - ~~requestLottoNumber()~~
    - ~~requestLottoBonusNumber()~~

- OutputView
    ~~- printRandomNumber()~~
    - printPrizeStatic()
    - printProfitRate()
    ~~- generateRandomNumber()~~
      - 오름차순으로 정렬하여 로또 번호 보여줌
      - Lotto.java의 성질 가지고 있음

Util

- PrizeStatic
  - 로또 번호 일치 개수 세는 기능
  - 일치 개수에 맞춰 1~5등 판별

- ~~ProfitRate~~
  ~~- 수익률 계산 기능 ((당첨 금액/투자금액) *100)~~


  
Control

- Control

- InputValidation
모든 Validation 목록 ("[ERROR]"로 문구시작해야함)

  - 로또 구입 금액 입력 시,
    ~~- 입력이 1000원으로 나누어떨어지지 않는 경우~~
    ~~- 숫자가 아닌 경우~~

  - 당첨 번호 입력 시,
    ~~- 6개의 당첨 번호 그 이상을 작성했을 시, (","의 개수가 5개 초과면 -> 위의 ,로 끝날 경우랑 일맥상통)~~
    ~~- 로또 번호의 숫자 범위를 넘어간 경우~~
    ~~- 숫자가 중복되었을 경우~~
    ~~- 숫자가 아닌 경우~~

  - 보너스 번호 입력 시,
    - 하나 이상의 번호 작성 시
    - 로또 번호의 숫자 범위 넘어간 경우
    - 위의 당첨 번호와 숫자 중복되었을 경우
    - 숫자가 아닌 경우
