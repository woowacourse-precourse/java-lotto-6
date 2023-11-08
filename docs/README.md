### ✔️ 구현할 기능 목록

- [x] 사용자로부터 구입 금액을 입력 받는다.
  - [x] 숫자가 아닌 경우:  `IllegalArgumentException([ERROR] 숫자를 입력해주세요.)`
  - [x] 1,000원으로 나누어 떨어지지 않는 경우:  `IllegalArgumentException([ERROR] 1,000원 단위로 입력해주세요.)`
  - [x] 0원인 경우:  `IllegalArgumentException([ERROR] 1,000원 이상을 입력해주세요.)`
  - [x] 예외가 발생한 경우 예외를 발생하고, 구입 금액을 다시 입력 받는다.
- [x] n개의 로또를 발행한다.
- [ ] 사용자로부터 당첨 번호를 입력 받는다. 당첨 번호는 쉼표(,)로 구분한다.
  - [ ] 6개로 나누어지지 않는 경우:  `IllegalArgumentException([ERROR] 6개의 숫자를 입력해주세요.)`
  - [ ] 숫자가 아닌 값이 포함되는 경우:  `IllegalArgumentException([ERROR] 숫자를 입력해주세요.)`
  - [ ] 모든 숫자의 범위가 1~45이 아닌 경우:  `IllegalArgumentException([ERROR] 1~45 범위의 숫자만 입력해주세요.)`
  - [ ] 중복되는 숫자가 존재하는 경우:  `IllegalArgumentException([ERROR] 중복되지 않는 6개의 숫자를 입력해주세요.)`
  - [ ] 예외가 발생한 경우 예외를 발생하고, 당첨 번호를 다시 입력 받는다.
- [ ] 사용자로부터 보너스 번호를 입력 받는다.
  - [ ] 숫자가 아닌 경우:  `IllegalArgumentException([ERROR] 숫자를 입력해주세요.)`
  - [ ] 당첨 번호에 이미 존재하는 번호인 경우:  `IllegalArgumentException([ERROR] 당첨 번호에 포함되지 않는 번호를 입력해주세요.)`
  - [ ] 숫자의 범위가 1~45이 아닌 경우:  `IllegalArgumentException([ERROR] 1~45 범위의 숫자만 입력해주세요.)`
  - [ ] 예외가 발생한 경우 예외를 발생하고, 보너스 번호를 다시 입력 받는다. 
- [ ] 당첨 통계를 출력한다.
  - [ ] 발행한 로또 중 3개~6개 일치한 로또들을 계산해 출력한다.
  - [ ] 수익률을 출력한다.

