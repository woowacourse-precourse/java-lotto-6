## 구현할 기능

### Controller

#### LottoConfig
- `getValue()`: 이 메서드는 `LottoConfig` 각 상수에 할당된 값을 반환합니다.

#### LottoGameController
- `playLottoGame()`: 로또 게임의 작동을 제어합니다. 사용자로부터 구매 금액을 받아 티켓을 생성하고, 당첨 번호를 생성한 다음, 당첨 통계를 계산하고 수익률을 계산하여 결과를 표시합니다. 입력이 유효하지 않은 경우 사용자에게 오류 메시지를 표시하고 다시 입력을 요청합니다.

#### UserInput
- `getPurchaseAmountFromInput(LottoView view)`: 사용자에게 구매 금액을 입력받고 유효성을 검사합니다. 금액이 유효하지 않은 경우 사용자에게 오류 메시지를 표시하고 재입력을 요청합니다.
- `getWinningNumbersFromInput(LottoView view)`: 사용자에게 당첨 번호와 보너스 번호를 입력받고 유효성을 검사합니다. 번호가 유효하지 않은 경우 오류 메시지를 표시하고 재입력을 요청합니다.

#### UserInputValidator
- `validatePurchaseAmount(int purchaseAmount)`: 구매 금액이 1000원 단위인지 확인합니다. 그렇지 않은 경우 예외를 발생시킵니다.
- `validateBonusNumber(List<Integer> winningNumbers, int bonusNumber)`: 보너스 번호가 당첨 번호와 다른지 확인합니다. 그렇지 않은 경우 예외를 발생시킵니다.
- `validateLottoNumber(int number)`: 번호가 지정된 범위 내에 있는지 확인합니다. 그렇지 않은 경우 예외를 발생시킵니다.
- `validateLottoNumbers(List<Integer> numbers)`: 로또 번호가 올바른 개수이며 중복되지 않는지 확인합니다. 그렇지 않은 경우 예외를 발생시킵니다.

### Model

#### Lotto
- `Lotto(List<Integer> numbers)`: 지정된 번호로 새로운 로또 객체를 생성합니다. 번호가 유효하지 않은 경우 예외를 발생시킵니다.
- `getNumbers()`: 로또 번호 목록을 반환합니다. 반환된 목록은 수정할 수 없습니다.

#### LottoGameCalculator
- `calculateWinningStatistics(LottoTicket ticket, WinningNumbers winningNumbers)`: 주어진 로또 티켓과 당첨 번호를 기반으로 당첨 수익을 계산합니다.
- `calculateProfitRate(int purchaseAmount, Map<Integer, Integer> statistics)`: 구매 금액과 당첨 수익으로 수익률을 계산합니다.

#### LottoTicket
- `LottoTicket(int numberOfLottos)`: 지정된 수의 로또 티켓을 생성합니다.
- `getLottos()`: 생성된 로또 티켓 목록을 반환합니다.

#### Prize
- `valueOf(int matchCount, boolean bonusMatch)`: 일치하는 개수와 보너스 번호 일치 여부를 기반으로 상응하는 Prize를 반환합니다.
- 각 상수 (`MATCH_3`, `MATCH_4` 등)는 일치해야 하는 번호의 개수, 상금, 보너스 번호 일치 여부를 나타냅니다.

#### WinningNumbers
- `WinningNumbers(Lotto winningLotto, int bonusNumber)`: 당첨 로또와 보너스 번호를 이용하여 새로운 `WinningNumbers` 객체를 생성합니다.
- `getWinningLotto()`: 당첨 로또를 반환합니다.
- `getBonusNumber()`: 보너스 번호를 반환

합니다.

### View

#### LottoView
- `displayLottoNumbers(List<Lotto> lottos)`: 구매한 로또 번호 목록을 표시합니다.
- `displayWinningStatistics(Map<Integer, Integer> statistics, double profitRate)`: 당첨 통계와 수익률을 표시합니다.
- `displayError(String errorMessage)`: 오류 메시지를 표시합니다.

### Application
- `main(String[] args)`:  LottoView와 LottoGameController를 생성하고 로또 게임을 시작합니다.