# 절차

- 구입 금액을 입력받는다.
- 로또를 발행한다.
- 로또를 출력한다.
- 당첨 번호를 입력받는다.
- 보너스 번호를 입력받는다.
- 당첨 내역을 계산한다.
- 당첨 내역을 출력한다.
- 수익률을 계산한다.
- 수익률을 출력한다.

# 객체

- 구입 금액
- 로또
- 당첨 번호
- 보너스 번호
- 당첨 내역
- 수익률

# 기능

- getMoney
- getLotteryNumbers
- getBonusNumber
- calculateResult
- calculateIncomeRate
- printLotto
- printResult
- printIncomeRate

# 기능 분배

- Money
- Lotto
- LottoPack
  - calculateResult
- LotteryNumber
- Result
- IncomeRate
- InputView
  - getMoney
  - getLotteryNumber
  - getBonusNumber
- OutputView
  - printLotto
  - printResult
  - printIncomeRate