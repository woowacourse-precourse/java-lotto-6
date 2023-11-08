

## Lotto

- [ ]  로또 번호의 숫자 범위는 1~45이다.
    - camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다
    - 해당 범위의 숫자가 아닐 경우 IllegalArgumentException 발생
    - 오름차순으로 정렬한다.
- [ ] 로또 번호는 중복되지 않는 6개의 숫자이다.
    - 중복될 경우 IllegalArgumentException 발생

## Buyer

- [ ] 구입 금액은 1,000원 단위로 입력받으며, 나누어 떨어지지 않을 경우 IllegalArgumentException 발생
  - camp.nextstep.edu.missionutils.Console의 readLine()를 활용한다
- [ ] 8000원을 지불하면 8장의 발행된 티켓이 생긴다

## Winning
- [ ] 당첨 번호를 입력해야 한다.
  - camp.nextstep.edu.missionutils.Console의 readLine()를 활용한다

## Bonus

- [ ] 보너스 번호를 입력해야 한다.
    - camp.nextstep.edu.missionutils.Console의 readLine()를 활용한다
- [ ] 로또 번호와 중복되지 않는 1개의 보너스 번호이다.
