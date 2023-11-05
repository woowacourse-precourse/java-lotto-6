# 기능구현 🎯

## 1. 로또의 구매금액을 입력받는다. - getMoney()
- []공백 제거 -trim()
- []음수면 Error -isNegative()
- []1000단위 아니면 에러 -isRemainder()
- []숫자가 아닌 글자 포함 시 에러 -isDigit()

#### 구매금액만큼의 로또 번호를 입력받는다 -getLotto()
- []공백 제거 -trim()
- []범위는 1~45밖이면 에러 -isInRange()
- []음수 에러 -isNegative()
- []숫자가 아닌 글자 포함 시 에러 -isDigit()
- []중복되지 않도록. -isDuplication()

## 2. 당첨번호 숫자 6개와 보너스 번호 1개를 뽑고 비교한다.
- []범위 1~45의 숫자 중복되지 않게 생성. - NumberGenerator#getNumbers()
- []플레이어의 숫자와 당첨번호를 비교한다. - Judgement#compareNumbers()
- []등수에 알맞은 해당 메시지를 출력한다. -  Output#printMessage()