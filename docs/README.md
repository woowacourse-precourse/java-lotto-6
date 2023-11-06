## 기능 목록

- [x] 구입 금액으로 로또 몇장을 구입할 수 있는지 계산한다.(로또 1장당 1,000원) - LottoManager#calculateNumberOfLottos()
  - [x] 구입 금액이 1,000원단위로 나누어 떨어지는지 검사한다. - LottoManager#validatePurchaseAmount()
- [x] 로또를 생성한다. - LottoFactory#createLotto()
  - [x] 로또 번호에 중복된 값이 있는지 검사한다. - Lotto#validateDuplication()
- [x] 매개변수로 들어온 장수만큼 로또를 생성한다. - Lottos#createLottos()
- [x] 1 ~ 45까지의 중복하지 않는 난수 6개를 `List<Integer>`로 생성한다. - NumberGenerator#generateRandomNumbers()

- [x] 몇개의 번호가 담청되었는지 알 수 있다. - WinnigLotto#countMatchingNumbers()
- [x] 보너스 번호와 일치하는 번호가 있는지 검사한다. - BonusNumber#isContains()
- [x] 당첨 번호를 맞춘 개수에 맞게 등수를 정한다. - Prize#determineRank()
- [x] 당첨 기준에 맞게 해당 등수의 받을 상금 수량을 증가시킨다. Prizes#increasePrizeAmount()
- [x] 각 등수별 상금 합계를 계산한다. Prizes#calculateTotalPrizeForRank()
- [x] 총 상금을 계산한다. Prizes#calculateTotalPrize()
- [x] 수익률을 계산한다. (수익률은 소수점 둘째 자리에서 반올림) - LottoManager#calculateProfitRate()

### 입력
- [x] 로또 구입 금액을 입력 받을 수 있다. - InputView#askPurchaseAmount()
- [x] 당첨 번호를 입력 받을 수 있다. - InputView#askWinnigNumbers()
- [x] 보너스 번호를 입력 받을 수 있다. - InputView#askBonusNumber()
    - [x] 입력 값이 양수인 숫자인지 검사한다. - InputValidator#validatePositiveNumber()
    - [x] 입력 값이 비어있는지 검사한다. - InputValidator#validateEmptyInput()
      
### 출력
- [x] 발행한 로또 수량을 출력한다. - OutputView#showLottoAmount()
- [x] 발행한 로또 번호를 출력한다. - OutputView#showLottoNumbers()
- [x] 당첨 내역을 출력한다. - OutputView#showLottoResult()
- [x] 수익률을 출력한다. - OutputView#showProfitRate()
- [x] 에러 메시지를 출력한다. - OutputView#showErrorMessage()