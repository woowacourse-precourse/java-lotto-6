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
- [ ] 당첨 내역 출력 - #showDetail()
- [ ] 일치하는 로또 번호 개수 - #countMatchingNumber()
  - [ ] 당첨번호와 일치하는지 확인 - #matching()

### Revenue.class
- [ ] 수익률 출력(소수점 둘째 자리에서 반올림) - #rateOfRevenue()
  - Prize.enum 이용