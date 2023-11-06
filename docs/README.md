로또
====

### 기능 목록
- [x] 게임을 시작한다. - LottoGame.LottoGame()
- [x] 로또 구입 금액을 입력한다. - UI.getMoney()
  - [x] "구입금액을 입력해 주세요."를 출력한다. - UI.getMoney()
  - [x] 숫자가 아닌 경우 예외 처리한다. - validation.validateInteger()
    - [x] "[ERROR] 숫자를 입력해야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - validation.validateMoney()
  - [x] 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. - validation.validateDivideBy1000()
    - [x] "[ERROR] 1000원으로 나누어 떨어지는 값을 입력해야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - validation.validateMoney()
- [x] 구입 금액 만큼 로또를 발행한다. - LottoGame.publishLottos()
  - [x] 구입 금액으로 통해 발행해야하는 로또 개수를 확인한다. - LottoGame.publishLottos()
  - [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. - LottoGame.pickUniqueNumbers()
  - [x] 로또 번호는 오름차순으로 정렬하여 로또 객체에 저장한다. - LottoGame.pickUniqueNumbers()
  - [x] 발행한 로또 수량 및 번호를 출력한다. - UI.printLottos()
- [x] 당첨 번호와 보너스 번호를 입력받는다.
  - [x] 당첨 번호를 입력받는다. - UI.getWinningNumber()
    - [x] "당첨 번호를 입력해 주세요."를 출력한다. - UI.getWinningNumber()
    - [x] 숫자가 아닌 경우 예외 처리한다. - validation.validateIntegers()
        - [x] "[ERROR] 숫자를 입력해야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - UI.getWinningNumber()
    - [x] 쉼표를 기준으로 구분되지 않은 경우 예외 처리한다. - validation.validateDivision()
      - [x] "[ERROR] 쉼표를 기준으로 구분해야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - UI.getWinningNumber()
    - [x] 6개의 숫자가 아닐 때 예외처리한다. - validation.validateNumberCount()
      - [x] "[ERROR] 6개의 숫자를 입력해야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - UI.getWinningNumber()
    - [x] 각 숫자가 1과 45 사이의 숫자가 아닌 경우 예외 처리한다. - validation.validateNumbersRange()
      - [x] "[ERROR] 숫자의 범위는 1~45 사이어야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - UI.getWinningNumber()
  - [x] 보너스 번호를 입력받는다. - UI.getBonusNumber()
    - [x] "보너스 번호를 입력해 주세요."를 출력한다. - UI.getBonusNumber()
    - [x] 숫자가 아닌 경우 예외 처리한다. - validation.validateInteger()
      - [x] "[ERROR] 숫자를 입력해야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - UI.getBonusNumber()
    - [x] 숫자가 1과 45 사이의 숫자가 아닌 경우 예외 처리한다. - validation.validateNumberRange()
      - [x] "[ERROR] 숫자의 범위는 1~45 사이어야 합니다. " 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - UI.getBonusNumber()
    - [x] 보너스 번호가 당첨 번호와 겹치는 경우 예외 처리한다. - validation.validateUnique()
      - [x] "[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다." 메세지를 출력하고, 그 부분부터 입력을 다시 받는다. - UI.getBonusNumber()
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
  - [ ] 6개가 일치하는 경우를 확인한다. (1등)
  - [ ] 5개가 일치하는 경우를 확인한다. (2, 3등)
    - [ ] 보너스 볼이 일치한지 확인한다. (2등)
  - [ ] 4개가 일치하는 경우를 확인한다. (4등)
  - [ ] 3개가 일치하는 경우를 확인한다. (5등)
- [ ] 총 수익률을 계산한다.
  - [ ] 총 수익을 계산한다.
  - [ ] 총 수익을 구입금액으로 나누어 총 수익률을 계산한다. 
- [ ] 당첨 내역 및 수익률을 출력한다.
  - [ ] 발행한 로또 수량 및 번호를 출력한다.
  - [ ] 당첨 내역을 출력한다.

  