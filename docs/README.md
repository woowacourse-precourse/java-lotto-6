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
    - printRandomNumber()
    - printPrizeStatic()
    - printReturnRate()
    - generateRandomNumber()
      - 오름차순으로 정렬하여 로또 번호 보여줌
      - Lotto.java의 성질 가지고 있음

Util

- PrizeStatic
  - 로또 번호 일치 개수 세는 기능
  - 일치 개수에 맞춰 1~5등 판별

- ReturnRate
  - 수익률 계산 기능 ((당첨 금액/투자금액) *100)

- InputValidation
  - 사용자의 입력에 대한 validation
    - 금액에 숫자가 아닌 입력이 있는 경우
    - 금액이 1000으로 나누어 떨어지지 않을 경우


Control

- Control