# 기능 목록

---

### 사용자 입력 검증 기능 (예외처리)
- [x] 로또 구입 금액이 1,000원 단위가 아닐 경우 예외를 처리한다. - invalidLottoPurchaseAmount()
- [x] 로또 번호는 1~45 범위 내의 숫자만 가능하다. - validateLottoNumberRange()
- [x] 로또 발행 시, 중복되지 않는 6개의 숫자를 선택한다 - validateLottoNumbersDuplication()
- [ ] 당첨 번호는 중복되지 않는 6개의 숫자와 추가로 1개의 보너스 번호를 선택한다. - validateWinningNumbersAndBonusNumber()
### 조건
- 예외가 발생하면 "[ERROR]"로 시작하는 에러 메시지를 출력하고, 해당 부분의 입력을 다시 받는다.

--- 

### 입력 기능
- [x] 로또 구입 금액을 사용자로부터 입력 받는다. - enterLottoPurchaseAmount()
- [ ] 당첨 번호를 사용자로부터 입력 받는다. - enterWinningNumbers()
- [ ] 보너스 번호를 사용자로부터 입력 받는다. - enterBonusNumber()

---

### 출력 기능
- [ ] 사용자가 구매한 로또 번호와 당첨 번호 비교하여 당첨 내역 및 수익률을 출력 후 종료 -  printCompareUserLottoNumbersAndWinning()
- [x] 발행한 로또 수량 및 번호를 오르차순으로 출력한다. - printIssuedLottoNumbersInAscendingOrder()
- [ ] 당첨 내역을 출력한다. - printWinningDetails()
- [ ] 수익률을 출력한다. - printReturnOnInvestment()

---

### 로또 플레이 기능
- [ ] 로또 번호를 랜덤으로 생성한다. - generateRandomLottoNumbers()
- [ ] 수익률은 소수점 둘째 자리에서 반올림하여 계산한다. - rateOfReturn()
- [ ] 당첨된 로또의 내역을 확인한다. - getWinningDetails()
- [ ] 당첨 내역의 총 수익률을 구한다. - getTotalReturnWinningDetails()

---

### 도메인 모델
- lotto - 로또 번호를 관리하는 역할
- ReadPurchaseAmount - 구매 금액을 관리하는 역할
- LottoRamdomNumbers - 랜덤 로또 번호 관리하는 역할