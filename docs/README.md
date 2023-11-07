# Lotto Application

## 소개
Lotto Application은 사용자가 로또 번호를 생성하고, 당첨 번호를 입력하여 로또 당첨 여부를 확인할 수 있는 Java 기반의 콘솔 응용 프로그램입니다.

## 기능
1. **로또 번호 생성**: 사용자가 지정한 금액에 따라 로또 번호들을 자동으로 생성합니다.
2. **당첨 번호 입력**: 사용자로부터 당첨 번호를 입력받습니다.
3. **보너스 번호 입력**: 당첨 번호와 함께 보너스 번호를 입력받습니다.
4. **결과 출력**: 생성된 로또 번호와 당첨 번호를 비교하여 결과를 출력합니다.

## 예외 처리
- 입력한 금액이 1000원 단위가 아닐 경우 오류 메시지가 출력됩니다.
- 당첨 번호가 6개가 아니거나 1~45 범위를 벗어날 경우 오류 메시지가 출력됩니다.
- 보너스 번호가 당첨 번호와 중복되거나 1~45 범위를 벗어날 경우 오류 메시지가 출력됩니다.

## 메서드 설명

### `setAmountOfLotto(int amountOfLotto)`
-  사용자로부터 로또 구매 금액을 입력받아, 구매할 로또의 수량을 계산합니다.
- **입력**: `amountOfLotto` - 로또 구매 금액.
- **반환값**: 구매할 로또의 수량.

### `parseAmount(String input)`
-  문자열 형태의 입력을 정수형으로 파싱합니다.
- **입력**: `input` - 사용자로부터 입력받은 문자열.
- **반환값**: 파싱된 정수형 금액.

### `validateInput(int amountOfLotto)`
-  입력된 금액이 유효한지 확인합니다 (1000원 단위 및 양수).
- **입력**: `amountOfLotto` - 로또 구매 금액.
- **반환값**: 유효성 검사 후의 로또 구매 수량.

### `generateLottoNumbers(int amount)`
-  지정된 수량만큼 무작위 로또 번호를 생성합니다.
- **입력**: `amount` - 생성할 로또 번호의 수량.
- **반환값**: 생성된 로또 번호 리스트.

### `setWinningLotto()`
-  사용자로부터 당첨 번호를 입력받아 `Lotto` 객체를 생성합니다.
- **반환값**: 당첨 번호가 포함된 `Lotto` 객체.

### `getWinningNumbers()`
-  사용자로부터 당첨 번호를 입력받아 유효성 검사를 수행합니다.
- **반환값**: 유효한 당첨 번호 리스트.

### `getBonusNumber(Lotto winningNumbers)`
-  사용자로부터 보너스 번호를 입력받습니다.
- **입력**: `winningNumbers` - 당첨 번호가 포함된 `Lotto` 객체.
- **반환값**: 유효한 보너스 번호.

### `parseNumbers(String input)`
-  쉼표로 구분된 숫자 문자열을 파싱하여 리스트로 변환합니다.
- **입력**: `input` - 사용자로부터 입력받은 쉼표로 구분된 숫자 문자열.
- **반환값**: 파싱된 숫자 리스트.

### `setBonusNumber(Lotto winningNumbers)`
-  사용자로부터 보너스 번호를 입력받고, 유효성 검사를 수행합니다.
- **입력**: `winningNumbers` - 당첨 번호가 포함된 `Lotto` 객체.
- **반환값**: 유효한 보너스 번호.

### `isValidBonusNumber(int bonusNumber)`
-  보너스 번호가 유효한 범위 내에 있는지 확인합니다.
- **입력**: `bonusNumber` - 입력된 보너스 번호.
- **예외**: 유효하지 않은 범위의 숫자일 경우 `IllegalArgumentException` 발생.

### `compareLottoNumbers(List<List<Integer>> lottoNumbers, Lotto winningNumbers, int bonusNumber)`
- 생성된 모든 로또 번호와 당첨 번호, 보너스 번호를 비교하여 매칭 결과를 계산합니다.
- **입력**:
  - `lottoNumbers`: 사용자가 구매한 로또 번호들의 리스트.
  - `winningNumbers`: 당첨 번호가 포함된 `Lotto` 객체.
  - `bonusNumber`: 보너스 번호.
- **기능**: 각 로또 번호의 당첨 여부를 계산하고, 매칭 결과에 따라 `MatchResult`를 업데이트합니다.

### `compareLottoNumbersList(List<Integer> oneLotto, Lotto winningNumbers, int bonusNumber)`
- 단일 로또 번호와 당첨 번호, 보너스 번호를 비교하여 매칭된 숫자의 수를 반환합니다.
- **입력**:
  - `oneLotto`: 한 개의 로또 번호.
  - `winningNumbers`: 당첨 번호가 포함된 `Lotto` 객체.
  - `bonusNumber`: 보너스 번호.
- **반환값**: 매칭된 숫자의 수.

### `Rounds(double sum, int amountOfLotto)`
- 로또의 총 수익률을 계산하고 출력합니다.
- **입력**:
  - `sum`: 당첨된 로또의 총 상금.
  - `amountOfLotto`: 구매한 로또의 수량.
- **기능**: 총 상금을 로또 구매 비용으로 나누어 수익률을 계산하고, 반올림하여 출력합니다.

### `isWinningAndPlusMoney(double sum, MatchResult matchResult)`
- 당첨된 로또의 상금을 총합에 더합니다.
- **입력**:
  - `sum`: 현재까지의 상금 총합.
  - `matchResult`: 매칭 결과.
- **반환값**: 업데이트된 상금 총합.

### `MatchResult` 열거형 (Enum)
- 로또 매칭 결과와 해당 결과에 따른 상금을 정의하는 열거형입니다.
- **값**: `ZERO`, `ONE`, `TWO`, `THREE`, `FOUR`, `FIVE`, `SIX`, `FIVEandBONUS` 각각이 로또 매칭의 개수와 상금을 나타냅니다.

### `MatchResult.printMatchResult(int amountOfLotto)`
- 각 매칭 결과에 대한 통계를 출력합니다.
- **입력**: `amountOfLotto` - 구매한 로또의 수량.
- **기능**: 각 매칭 결과의 횟수와 상금을 출력하고, 총 수익률을 계산하여 출력합니다.


