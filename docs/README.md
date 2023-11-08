# 로또

## 구현 기능 목록

### `Lotto` 
- [x] 로또 번호의 개수가 6개인지 검사한다. - validate()
- [x] 로또 번호에 중복된 값이 있는지 검사한다. - validateDuplication()
- [x] 로또 번호가 1 ~ 45사이의 값인지 검사한다. - validateNumberRange()

### `LottoFactory`
- [x] 로또를 생성한다. - createLotto()

### `Lottos`
- [x] 원하는 만큼 로또를 생성한다. - createLottos()
- [x] 발행한 로또들의 번호를 toString 해준다. - getIssuedLottoNumbers()

### `WinningLotto`
- [x] 보너스 번호와 로또 번호가 중복하는지 검사한다. - validateDuplication()
- [x] 구매한 로또가 몇 개의 당첨 번호를 맞췄는지 알려준다. - countMatchingNumbers()
- [x] 보너스 번호를 맞췄는지 알려준다. - isMatchBonusNumber()

### `BonusNumber`
- [x] 보너스 번호가 1 ~ 45사이의 숫자인지 검사한다. - validateNumberRange()
- [x] 로또 번호에 보너스 번호가 포함되어있는지 알려준다. - isContains()

### `Prize`
- [x] 당첨된 번호 개수와 보너스 번호 당첨여부를 통해 당첨 순위(상금)을 알 수 있다. - determineRank()

### `WinningDetails`
- [x] 당첨 순위에 맞게 상금을 수여한다. - increasePrizeAmount()
- [x] 등수별 당첨된 상금액의 합을 계산한다. - calculateTotalPrizeForRank()
- [x] 모든 등수의 당첨된 상금액의 합을 계산한다. - calculateTotalPrize()

### `LottoManager`
- [x] 당첨 로또(`WinningLotto`)를 생성한다. - createWinningLotto()
- [x] 로또의 등수를 책정햐여 상금을 수여한다. - awardPrize()
- [x] 이번 로또 추첨의 상금내역을 통계한다. - statisticsPrize()
- [x] 이번 로또 추첨의 수익률을 계산한다. - calculateProfitRate()

### `LottoSeller`
- [x] 받은 금액으로 몇장의 로또를 살 수 있는지 계산한다. - calculateNumberOfLottos()
- [x] 받은 금액에 맞게 로또들을 생성해준다. - getLottos()

### `PurchaseAmount`
- [x] 1,000원 단위의 금액인지 검사한다. - validatePurchaseAmount()

### `NumberGenerator`
- [x] 로또 번호에 사용될 1 ~ 45사이의 난수를 생성해준다. - generateRandomNumbers()

### 입력 예외처리
- [x] 입력값이 양수의 숫자인지 검사한다. - validatePositiveNumber()
- [x] 입력값이 비어있는지 검사한다. - validateEmptyInput()
- [x] 당첨 번호입력 시 양쪽끝에 구분점(,)이 사용되었는지 검사한다. - validateNotSurroundedByDelimiters()

### 입력
- [x] 로또 구입 금액을 입력 받을 수 있다. - InputView#askPurchaseAmount()
- [x] 당첨 번호를 입력 받을 수 있다. - InputView#askWinnigNumbers()
- [x] 보너스 번호를 입력 받을 수 있다. - InputView#askBonusNumber()
      
### 출력
- [x] 발행한 로또 수량을 출력한다. - OutputView#showLottoAmount()
- [x] 발행한 로또 번호를 출력한다. - OutputView#showLottoNumbers()
- [x] 당첨 내역을 출력한다. - OutputView#showLottoResult()
- [x] 수익률을 출력한다. - OutputView#showProfitRate()
- [x] 에러 메시지를 출력한다. - OutputView#showErrorMessage()