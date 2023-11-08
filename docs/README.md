# [ 기능 목록 ]

## Input

- [x]  로또 구입 금액을 입력받는다.
    - [x]  `[예외]` 숫자가 아닌 경우 IllegalArgumentException
    - [x]  `[예외]` 1000원 단위가 아닌 경우 IllegalArgumentException
    - [x]  `[예외]` 1000보다 작은 경우 IllegalArgumentException
- [x]  당첨 번호를 입력받는다.
    - [x]  `[예외]`  숫자가 아닌 경우 IllegalArgumentException
    - [x]  `[예외]`  숫자 범위(1~45)를 벗어난 경우 IllegalArgumentException
    - [x]  `[예외]`  중복된 숫자가 존재하는 경우 IllegalArgumentException (NUMBERS)
    - [x]  `[예외]`  6개의 숫자가 아닌 경우 IllegalArgumentException (NUMBERS)
- [x]  보너스 번호를 입력받는다.
    - [x]  `[예외]`  숫자가 아닌 경우 IllegalArgumentException
    - [x]  `[예외]`  숫자 범위(1~45)를 벗어난 경우 IllegalArgumentException
    - [x]  `[예외]`  1개의 숫자가 아닌 경우 IllegalArgumentException
    - [x]  `[예외]`  당첨 번호로 뽑은 숫자를 선택한 경우 IllegalArgumentException
- [x]  사용자에게 잘못된 입력값을 받은 경우 재입력 받는다.

## Lotto

- [x]  구입 금액에 따른 로또 발행 개수를 계산한다.
- [x]  로또를 발행한다.
    - [x]  발행 전략 (수동/자동) 에 따라 로또를 발행한다.
    - [x]  1 ~ 45 사이의 랜덤한 숫자를 선택한다.
    - [x]  숫자 6개를 선택한다.
    - [x]  각 숫자는 중복되지 않아야 한다.
- [x]  로또 번호를 비교한다.
    - [x]  당첨 번호와 로또 번호를 비교한다.
    - [x]  보너스 번호와 로또 번호를 비교한다.
- [x]  로또 결과를 계산한다.
    - [x]  각 로또의 당첨 개수 및 보너스 당첨 여부에 따라 로또 등수를 계산한다.
    - [x]  각 로또 등수의 당첨 개수를 계산한다.
- [x]  수익률을 계산한다.
    - [x]  당첨 금액의 총 합을 구한다.
    - [x]  구매 금액에 대한 당첨 금액 수익률을 계산한다.

## Output

- [x]  로또 구입 개수를 출력한다.
- [x]  로또 발행 내역을 출력한다.
    - [x]  발행한 각 로또 번호를 배열 형식으로 출력한다.
- [x]  당첨 내역을 출력한다.
    - [x]  각 금액마다 당첨된 개수를 출력한다.
    - [x]  금액 단위에 따라 , 를 붙여 출력한다. (3자리마다)
- [x]  수익률을 출력한다.
    - [x]  수익률을 소수점 둘째 자리에서 반올림한다.
    - [x]  수익률 단위에 따라 , 를 붙여 출력한다. (3자리마다)
- [x]  에러 메시지를 출력한다.