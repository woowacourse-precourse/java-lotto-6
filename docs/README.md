# 로또

## 기능 목록

- 로또 구입
  - 1000원 단위로 입력받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. Input - askHowManyLottoPurchase()
    - 로또 구입 금액 입력값을 옳게 입력됐는지 검증한다. LottoNumber - validateMoneyUnit()
- 당첨 번호 입력
  - 1부터 45까지 서로 다른 임의의 숫자 6개를 입력받는다. Input - askTheWinningLotteryNumbers()
  - 위에서 입력한 6개의 번호와 다른 보너스 번호 1개를 입력받는다. Input - askTheWinningLotteryBonusNumber()
  - 당첨 번호가 옳게 입력됐는지 검증한다. Lotto - validate()
  - 보너스 번호가 옳게 입력됐는지 검증한다. Lotto - validateBonusNumber

- 로또를 발행 할 때 1부터 45까지 서로 다른 임의의 수 6개를 구매한 로또 수 만큼 생성한다. NumberGenerator - pickRandomLottoNumber()
- 발행한 로또 번호와 당첨 번호를 비교한다. Draw - compare()
- 수익률을 구한다.(당첨 금액/구입 금액)


### 예외 상황
- 로또 구입 금액 입력값
  - 1000원으로 나누어 떨어지지 않는 경우[v]
  - 0원이 입력된 경우[v]
  - 음수가 입력된 경우[v]
- 당첨 번호 6개
  - 쉼표로 구분했을때 6개가 아닌경우[v]
  - 1미만 45초과의 값을 입력한 경우[v]
  - 정수 자료형이 아닌 경우[v]
  - 쉼표(,)를 제외한 문자가 있는 경우[v]
  - 중복 값을 입력한 경우[v]
- 보너스 번호 1개
  - 위에서 입력한 당첨번호와 중복되는 값을 입력한 경우
  - 1미만 45초과의 값을 입력한 경우[v]
  - 정수 자료형이 아닌 경우[v]