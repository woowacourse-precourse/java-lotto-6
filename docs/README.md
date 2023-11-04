# 기능 목록

---

### 사용자 입력 검증 기능 (예외처리)
- [ ] 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. - invalidLottoPurchaseAmount()
- [ ] 로또 번호의 숫자 범위는 1~45까지이다. - validateLottoNumberRange()
- [ ] 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. - uniqueLottoNumbers()
- [ ] 당첨 번호는 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다. - winningNumbersAndBonusNumber()
### 조건
- 예외 상황 시 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

--- 

### 입력 기능
- [ ] 로또 구입금액을 입력한다. - enterLottoPurchaseAmount()
- [ ] 당첨 번호를 입력 받는다. - enterWinningNumbers()
- [ ] 보너스 번호를 입력받는다. - enterBonusNumber()

---

### 출력 기능
- [ ] 사용자가 구매한 로또 번호와 당첨 번호 비교하여 당첨 내역 및 수익률을 출력 후 종료 -  printCompareUserLottoNumbersAndWinning()
- [ ] 발행한 로또 수량 및 번호를 오르차순으로 출력한다. - printIssuedLottoNumbersInAscendingOrder()
- [ ] 당첨 내역을 출력한다. - printWinningDetails()
- [ ] 수익률을 출력한다. - printReturnOnInvestment()

---

### 로또 플레이
- [ ] 로또 번호를 랜덤으로 생성한다. - generateRandomLottoNumbers()
- [ ] 수익률은 소수점 둘째 자리에서 반올림한다. - rateOfReturn()
- [ ] 당첨 내역을 구한다. - getWinningDetails()
- [ ] 당첨 내역의 총 수익률을 구한다. - getTotalReturnWinningDetails()

---

### 도메인 모델
- User - 사용자 입력 한 값을 관리는 역할
- lotto machine - 로또 기계 역할
- lotto - 로또 번호를 관리하는 역할
- lottoNumbers - 자동으로 로또 번호를 생성