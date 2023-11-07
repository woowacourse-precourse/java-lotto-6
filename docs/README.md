# 로또

## 기능 목록
### BuyLotto.class
- [x] 로또 구입 금액 입력 (1장 1000원) - #inputMoney()
    - [x] 1000원으로 나누어떨어지지 않는 경우 에러 처리 #validateInputMoney
- [x] 발행한 로또 수량 출력 - #quantityLotto()
- [x] 로또 번호(오름차순, 중복 X) 출력 - #numberLotto()

### InputNumber.class
- [x] 당첨 번호 입력 - #inputWinningNumber()
- [x] 보너스 번호 입력 - #inputBonusNumber()
- [x] 입력된 숫자가 올바르지 않을 경우 에러 처리

### ResultLotto.class
- [x] 당첨 내역 출력 - #showDetail()
- [x] 당첨된 로또 등수 각각 몇개인지 확인 - #categorizeRank
- [x] 구매한 로또 번호 6개씩 나눠서 각각 등수 확인 - #checkRank
- [x] 로또 한 장이 몇 개의 당첨 번호와 일치하는지 매치 - #matchingNumber
  - [x] 당첨 번호 일치 개수에 따른 등수 - #matchingPrize
    - [x] 당첨 번호 5개가 일치할 때 보너스 번호 매치 - #matchingBonus

### Revenue.class
- [x] 수익률 출력(소수점 둘째 자리에서 반올림) - #rateOfRevenue()