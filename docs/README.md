## ✅ What to do?!

***

### 1. 기능 요구 사항

+ [x] 로또 구입 금액을 입력 받는다.
    + [x] 입력 메시지를 화면에 표시한다.
    + [x] 숫자 형식이 맞는지 확인한다. 숫자 형식이 아니면 IllegalArgumentException을 발생시킨다.
    + [x] 입력한 금액이 1,000보다 작으면 IllegalArgumentException을 발생시킨다.
    + [x] 입력한 금액이 1,000으로 나누어 떨어지지 않으면 IllegalArgumentException을 발생시킨다.
    + [x] 입력한 금액을 수량으로 나눈다.
    + [x] 구매 수량을 화면에 표시한다.
+ [x] 로또 번호를 생성한다.
    + [x] camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용하여 랜덤값을 생성한다.
    + [x] 생성된 번호가 6자리가 맞는지 검증한다. 6자리가 아닐 경우 IllegalArgumentException을 발생시킨다.
    + [x] 입력 번호가 중복되지 않는지 검증한다. 중복될 경우 IllegalArgumentException을 발생시킨다.
    + [x] 생성한 랜덤값을 화면에 표시한다.
+ [x] 당첨 번호를 입력 받는다.
    + [x] 당첨 번호를 콤마(,) 기준으로 검증한다.
        + [x] 입력 번호가 중복되지 않는지 검증한다. 중복될 경우 IllegalArgumentException을 발생시킨다.
        + [x] 입력 번호가 1 ~ 45 사이의 숫자인지 검증한다. 이외의 범위에 해당할 경우 IllegalArgumentException을 발생시킨다.
        + [x] 입력 번호가 총 6자리가 맞는지 검증한다. 6자리가 아닐 경우 IllegalArgumentException을 발생시킨다.
        + [x] 각각의 번호가 숫자 형식이 맞는지 확인한다. 숫자 형식이 아닐 경우 IllegalArgumentException을 발생시킨다.
+ [ ] 보너스 번호를 입력 받는다.
    + [ ] 입력 번호가 1 ~ 45 사이의 숫자인지 검증한다. 이외의 범위에 해당할 경우 IllegalArgumentException을 발생시킨다.
    + [ ] 입력 번호의 개수가 하나인지 검증한다. 아닐 경우 IllegalArgumentException을 발생시킨다.
    + [ ] 각각의 번호가 숫자 형식이 맞는지 확인한다. 숫자 형식이 아닐 경우 IllegalArgumentException을 발생시킨다.
+ [ ] 로또 당첨 여부를 검증한다.
    + [ ] 순위 검증에 enum을 사용한다.
    + [ ] 숫자의 일치 여부 개수를 확인하는 로직을 작성한다.
    + [ ] 결과를 화면에 표시한다.
+ [ ] 수익률을 계산한다.
+ [ ] 수익률을 화면에 표시한다.

<br>

### 2. 테스트 코드
