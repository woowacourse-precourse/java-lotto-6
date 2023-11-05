# 로또

## 기능 목록
### BuyLotto.class
- [x] 로또 구입 금액 입력 (1장 1000원) - #inputMoney()
    - [x] 1000원으로 나누어떨어지지 않는 경우 에러 처리 #validateInputMoney
- [x] 발행한 로또 수량 출력 - #quantityLotto()
- [ ] 로또 번호(오름차순, 중복 X) 출력 - #numberLotto()

### WinLotto.class
- [ ] 당첨 번호 및 보너스 번호 입력 - #winningNumber()
  - [ ] 1 ~ 45 사이의 숫자가 아닐 경우 에러 처리
- [ ] 당첨 내역 출력 - #winningDetail()
- [ ] 수익률 출력(소수점 둘째 자리에서 반올림) - #rateOfRevenue()