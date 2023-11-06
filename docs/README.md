## 기능 구현 목록

-[x] 사용자의 금액을 입력받는다. - InputView#inputCash
    - [x] 예외 - 1000 단위인지 판단한다. - Player#validateCash
-[x] 금액으로 발행 횟수를 책정한다. - Util#calculateAttempt
-[x] 별개의 1 ~ 45 무작위 값 6개를 생성한다. - LottoGenerator#generate
-[x] 로또 번호 6개를 입력받는다. - InputView#inputLotto
-[x] 보너스 번호를 입력받는다. - InputView#inputBonus
    - [ ] 로또 번호와는 별개이어야 한다. - Bonus#validate
-[x] 로또 번호 + 보너스 번호와 랜덤 6개 값을 비교한다. - Comparator#compare
    -[x] 로또 번호와 보너스 번호를 구분해서 비교한다. - Comparator#compareLotto, Comparator#compareBonus
    -[x] 비교한 값으로 당첨 금액을 책정한다. - Calculator#calculateReturn
-[x] 당첨 통계를 출력한다. - OutputView#printStat
-[x] 수익률을 계산한다. - Calculator#calculateRateOfReturn
-[x] 수익률을 출력한다. - OutputView#printRateOfReturn
-[ ] 로또 범위 상수 - LottoConstant

## 예외 처리

-[ ] 예외 - 로또 번호는 1 ~ 45 값이어야한다. 