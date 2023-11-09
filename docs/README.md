# 로또 게임

## 기능 목록
- [ ] 로또 구입 금액을 입력받는다. - `InputView.requestPurchasePrice()`
  - 입력값이 숫자가 아니면 예외 발생 - `InputView.validateNumeric()`
  - 금액이 1,000원으로 나누어 떨어지지 않으면 예외 발생 - `Purchase.validatePrice()`
  - 구매 금액이 1,000원 미만인 경우 예외 발생 - `Purchase.validatePrice()`
- [ ] (구입 금액 / 1000)개 만큼의 로또 숫자를 생성후 출력한다. - `OutputView.printPurchaseLottos()`
  - 로또 번호는 중복되지 않는 1 ~ 45 사이의 자연수 - `LottoService.createLottos()`
  - 오름차순으로 정렬 - `Lotto.getSortedNumbers()`
- [ ] 당첨 번호를 입력받는다. - `InputView.requestWinningNumber()`
  - 분할된 값이 숫자가 아닌 경우 예외 발생 - `InputView.validateSplitEachNumeric()`
  - 쉼표(`,`)로 분할 시 6개가 아닌 경우 예외 발생 - `Lotto.validateSize()`
  - 보너스 번호가 당첨 번호에 포함되는 경우 예외 발생 - `Winning.validateLottoNumberContainBonusNumber()` 
- [ ] 보너스 번호를 입력받는다. - `InputView.requestBonusNumber()`
  - 숫자가 아닌 경우 예외 발생 - `InputView.validateNumeric()`
- [ ] 당첨 번호 + 보너스 번호와 생성한 로또 번호를 비교하여 통계를 출력한다. - `GameManagerService.settleWinningResult()`, `OutputView.printResult()`
  - 수익률은 소수점 둘째 자리에서 반올림하며 정수 부분 3자리 마다 쉼표(`,`)를 추가 - `OutputView.getDecimalAmount()`

## 기능 요구 사항
구입한 금액 만큼 생성되는 로또 번호를 당첨 + 보너스 번호와 비교하여 통계를 확인하는 게임이다.

6개의 랜덤 숫자를 포함하는 로또가 (구입 금액 / 1000)개 만큼 생성되며 일치 개수에 따라 등수 및 당첨 금액이 정해진다.
당첨 통계를 통해 당첨 된 로또 개수, 수익률을 확인할 수 있다.

_참고) 보너스 볼은 2, 3등 구분 시 사용된다._
- 2등 : 5개 번호 일치 + 보너스 번호 일치
- 3등 : 5개 번호 일치

## 패키지 구조
```
├── configuration
│   └── GameConfiguration.java
├── controller
│   └── GameManagerController.java
├── domain
│   ├── Bonus.java
│   ├── GameManager.java
│   ├── Lotto.java
│   ├── Purchase.java
│   ├── Reward.java
│   ├── Rewards.java
│   ├── User.java
│   └── Winning.java
├── dto
│   ├── request
│   │   ├── BonusNumberRequest.java
│   │   ├── PurchasePriceRequest.java
│   │   └── WinningNumberRequest.java
│   └── response
│       ├── PurchasePriceResponse.java
│       ├── WinningResponse.java
│       └── WinningStatistic.java
├── exception
│   ├── InputException.java
│   └── errorcode
│       ├── ErrorCodeConstant.java
│       └── InputErrorCode.java
├── service
│   ├── GameManagerService.java
│   └── LottoService.java
└── view
    ├── GameMessage.java
    ├── InputView.java
    └── OutputView.java
```
__configuration__
  - `GameConfiguration.java` : 게임 진행 관련 설정값들을 상수로 정의되어 있는 클래스

__controller__
  - `GameManagerController.java` : 흐름에 따라 필요한 객체를 호출하여 게임을 진행하는 클래스

__domain__
- `Bonus.java` : 보너스 번호 검증 및 포함 여부 판단
- `GameManager.java` : 당첨 통계 계산
- `Lotto.java` : 로또 번호 관련 검증, 일치 개수 계산
- `Purchase.java` : 구매 금액 관련 검증 및 수익률 계산
- `Reward.java` : 당첨 보상 정보를 정의한 열거체
- `Rewards.java` : 당첨 보상을 저장하는 일급 컬렉션. 총 당첨 금액, 당첨 로또 개수 계산
- `User.java` : 사용자의 구매금액, 로또 번호를 저장. 로또 개수와 금액 검증 및 필드를 통한 수익률 및 로또 개수 제공
- `Winning.java` : 당첨/보너스 번호를 저장. 필드를 통한 당첨 여부 관련 정보 제공

__dto/request__
- `BonusNumberRequest.java` : 보너스 번호 입력을 View에서 도메인으로 전달 시 사용되는 클래스
- `PurchasePriceRequest.java` : 구매 금액 입력을 View에서 도메인으로 전달 시 사용되는 클래스
- `WinningNumberRequest.java` : 당첨 번호 입력을 View에서 도메인으로 전달 시 사용되는 클래스

__dto/response__
- `PurchasePriceResponse.java` : 구매한 금액만큼 발행된 로또 번호 도메인에서 View로 전달 시 사용되는 클래스
- `WinningResponse.java` : 당첨 통계 및 수익률을 도메인에서 View로 전달 시 사용되는 클래스
- `WinningStatistic.java` : 당첨 통계를 도메인에서 View로 전달 시 사용되는 클래스

__exception__
- `InputException.java` : 입력값 오류 시 발생시킬 예외 클래스 (`IllegalArgumentException` 상속 및 `ErrorCode` 필드 포함)

__errorcode__
- `ErrorCodeConstant.java` : 예외 메시지에 접두사 등 공통적으로 사용되는 문구가 상수로 정의되어 있는 클래스
- `InputErrorCode.java` : 예외 메시지를 저장하는 열거체

__service__
- `GameManagerService.java` : 요청에 따라 적절한 도메인을 생성 및 호출하여 당첨 통계를 계산하는 클래스
- `LottoService.java` : 로또 번호 관련 도메인을 생성하는 클래스

__view__
- `ConsoleInputView.java` : 콘솔을 활용하여 입력 시 사용되는 구현 클래스
- `ConsoleOutputView.java` : 콘솔을 활용하여 출력 시 사용되는 구현 클래스 
- `InputView.java` : 입력 시 사용되는 인터페이스
- `OutputView.java` : 출력 시 사용되는 인터페이스