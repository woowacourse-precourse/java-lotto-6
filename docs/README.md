## 🛠구현기능목록

## 로또 게임

# 사용자 입력 UI

- [x] 로또 구입 금액을 입력 받는다.
- [x] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
- [x] 보너스 번호를 입력 받는다.

# 사용자 입력에 대한 예외처리

- [x] 구입 금액이 숫자가 아니거나, 양수가 아니거나, 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

- [x] 당첨 번호 혹은 보너스 번호가 1부터 45 사이의 숫자가 아닌 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시
  받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

- [x] 당첨 번호가 6개의 숫자가 아닌 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

- [x] 당첨 번호가 중복되는 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

- [x] 보너스 번호가 1개의 숫자가 아닌 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

- [x] 보너스 번호가 당첨 번호와 중복되는 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 출력 UI

- [x] 발행한 로또 수량 및 번호를 출력한다. 이때 로또 번호는 오름차순으로 정렬한다.
- [x] 당첨 내역을 출력한다.
- [x] 수익률을 출력한다. 이때 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

# 로또 발행

- [x] 로또 발행 시 1부터 45까지의 숫자를 중복되지 않게 6개 뽑기.
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
    - 로또 1장의 가격은 1,000원이다.

# 사용자가 구매한 로또 번호와 당첨 번호 비교

- [ ] 1등: 6개 번호 일치 / 2,000,000,000원
- [ ] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- [ ] 3등: 5개 번호 일치 / 1,500,000원
- [ ] 4등: 4개 번호 일치 / 50,000원
- [ ] 5등: 3개 번호 일치 / 5,000원

# 수익률 계산

- [ ] (당첨 금액 / 구입 금액) * 100%

# 사용자 입력을 바탕으로 게임 진행시키기

- [ ] 각 domain 연결해서 하나의 게임 만들기