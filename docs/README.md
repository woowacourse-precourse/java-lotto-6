# 🎰 로또

## 🛠️ 기능 목록
### LottoIssuer
- [x] 구입 금액만큼 로또를 발행한다. `List<Lotto> issue(PurchaseAmount purchaseAmount)`

### WinningLotto
- [x] 로또 번호와 당첨 번호를 비교해서 나온 당첨 등수를 반환한다. `Rank determineRank(Lotto)`

### WinningDetails
- [x] 당첨 내역에 당첨 등수를 저장한다. `void addRank(Rank rank)`
- [x] 수령 가능한 총 상금을 계산한다. `long getTotalReward()`

### ProfitRateCalculator
- [x] 구입 금액과 당첨 금액에 따른 수익률을 계산한다. `double calculate(int purchaseAmount, long reward)`

### InputView
- [x] 구입 금액을 입력 받는다. `String readPurchaseAmount()`
  - 공백이 포함되서는 안 된다. 
  - 정수만 입력 가능하다.
- [x] 당첨 번호를 입력 받는다. `String[] readWinningNumbers()`
  - 공백이 포함되서는 안 된다.
  - 쉼표(,)를 기준으로 구분한다.
- [x] 보너스 번호를 입력 받는다. `String readBonusNumber()`
  - 공백이 포함되서는 안 된다.
  - 정수만 입력 가능하다.

### OutputView
- [x] 발행한 로또 수량 및 번호를 출력한다. `void printIssuedLottoDetails(IssuedLottoDetails issuedLottoDetails)`
- [x] 당첨 내역을 출력한다. `void printWinningDetails(String WinningDetails)`
- [x] 수익률을 출력한다. `void printProfitRate(double profitRate)`
    - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%)

### 검증 내용
- [x] 구입 금액은 1,000원 단위여야 한다.
- [x] 구입 금액은 1,000원 이상 100,000원 이하여야 한다.
- [x] 로또 번호는 6개여야 한다.
- [x] 로또 번호는 1 이상 45 이하여야 한다.
- [x] 로또 번호는 중복 없이 서로 달라야 한다.
- [x] 당첨 번호는 6개여야 한다.
- [x] 당첨 번호는 1 이상 45 이하여야 한다.
- [x] 당첨 번호는 중복 없이 서로 달라야 한다.
- [x] 보너스 번호는 1 이상 45 이하여야 한다.

## 🚀 실행 과정
<img src="lotto flow.png">

## 👥 협력 관계
<img src="lotto message graph.png">

- 로또 매니저는 로또 발행기에게 구입 금액만큼 로또를 발행할 것을 요청한다.
  - 로또 발행기는 구입 금액에게 값을 반환할 것을 요청한다.
    - 구입 금액은 값을 반환함으로써 로또 발행기의 요청에 응답한다.
  - 로또 발행기는 구입 금액만큼 로또를 발행함으로써 로또 매니저의 요청에 응답한다.
- 로또 매니저는 당첨 번호에게 발행한 로또를 넘겨주며 당첨 등수를 반환할 것을 요청한다.
  - 당첨 번호는 발행한 로또 번호에 대한 당첨 등수를 반환함으로써 로또 매니저의 요청에 응답한다.
- 로또 매니저는 당첨 내역에게 각각의 로또 번호에 대한 당첨 등수를 넘겨주며 저장할 것을 요청한다.
  - 당첨 내역은 당첨 등수를 저장함으로써 로또 매니저의 요청에 응답한다.
- 로또 매니저는 당첨 내역에게 수령 가능한 총 상금을 계산할 것을 요청한다.
  - 당첨 내역은 총 상금을 계산함으로써 로또 매니저의 요청에 응답한다.
- 로또 매니저는 수익률 계산기에게 구입 금액과 총 상금을 넘겨주며 수익률을 계산할 것을 요청한다.
  - 수익률 계산기는 구입 금액과 총 상금을 가지고 수익률을 계산함으로써 로또 매니저의 요청에 응답한다.

## 🔎 요구 사항
- [x] JDK 17 버전에서 실행 가능해야 한다.
- [x] Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [x] indent depth는 2까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- [x] 구현한 기능이 정상 동작함을 테스트 코드로 확인한다.
- [x] 함수(또는 메서드)의 길이가 **15라인**을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [x] else 예약어를 쓰지 않는다.
- [x] Java Enum을 적용한다.
- [x] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [x] 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
    - numbers의 접근 제어자인 private을 변경할 수 없다.
    - `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
    - `Lotto`의 패키지 변경은 가능하다.
- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
