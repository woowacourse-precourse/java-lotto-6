# 기능구현 🎯

## 로또 번호를 생성

- [x] 임의의 숫자 6개를 중복없이 생성 - NumberGenerator#getNumbers()
- [x] 몇 개의 숫자가 같은지 알 수 있는 기능 - Judgement#compareNumbers()

## 로또의 구매금액을 입력받는다. - LottoService#getMoney()
- [x] 공백 제거 -trim()
- [x] 음수면 Error - Error#isNegative()
- [x] 1000단위 아니면 에러 - Error#isRemainder()
- [x] 숫자가 아닌 글자 포함 시 에러 - Error#isDigit()
- [x] 구매 금액만큼 로또 번호 생성 - LottoService#getLottoCount()

## 당첨번호 숫자와 보너스 숫자를 입력받는다. -LottoGame#winningNumberInit()
- [x] 공백 제거 -trim()
- [x] 범위는 1~45밖이면 에러 -Error# isInRange()
- [x] 음수 에러 - Error#isNegative()
- [x] 숫자가 아닌 글자 포함 시 에러 -Error#isDigit()
- [x] 중복되지 않도록. -Error#isDuplication()

## 당첨번호와 구매번호를 비교한다. - Result#compareLotto()
- [x] 등수에 알맞은 해당 메시지를 출력한다. - Output#printResultMessage()
- [x] 수익률을 계산한다. - Result#printProfitRate()

## 단위테스트 코드를 작성하여 적용한다.