## 기능 목록

---

#### 비즈니스 기능

- [x] 금액에 맞는 로또를 발행하는 기능 - Store#sellLottos
    - [x] 가격이 나누어 떨어지는 지 판단하는 기능 - Store#validateDividedByPrice


- [x] 로또 추첨을 받는 기능 - BroadCastingStation#drawLotto
    - 중복되지 않는 숫자 6개와 보너스 번호 1개여야 한다. - BroadCastingStation#validateDuplicate


- [ ] 당첨 결과를 확인하는 기능 - Buyer#checkWinning


- [ ] 수익률을 계산하는 기능 - Calculator#returnRate
    - 소수점 둘째 자리에서 반올림 되어야 한다.


- [x] 로또 번호가 6개 인지 판단하는 기능 - Lotto#validateSixNumbers
- [x] 로또 번호가 중복되지 않는지 판단하는 기능 - Lotto#validateDuplicate
- [x] 로또 번호 입력이 숫자 1~45인지 판단하는 기능 - Lotto#validateRange

---

#### UI 기능

- [ ] 구입 금액을 입력받는다. - UI#inputMoney
- [ ] 구매 내역을 보여준다. - UI#printPurchases
- [ ] 당첨 번호를 입력받는다. - UI#inputWinningNumbers
- [ ] 보너스 번호를 입력받는다. - UI#inputBonusNumber
- [ ] 당첨 통계를 보여준다. - UI#printWinningStats
- [ ] 수익률을 보여준다. - UI#printReturnRates
