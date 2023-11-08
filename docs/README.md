# 🔢 우아한테크코스 프리코스 3주차 : 로또

https://user-images.githubusercontent.com/122594223/280687804-57158e77-0dfb-41ed-893c-476b57a0cc15.mp4

## 목차

- [1. 구현 기능 목록](#ballotboxwithcheck-구현-기능-목록)
- [2. 문제 해결 과정](#bookmark_tabs-문제-해결-과정)
    - [2.1 🧪 2주 차 미션 피드백과 적용 사항](#-2주-차-미션-피드백과-적용-사항)
    - [2.2 ✨ ConsoleInput의 책임과 유효성 검사의 위치](#-consoleinput의-책임과-유효성-검사의-위치)
    - [2.3 🧐 Service package 사용의 변화](#-service-package-사용의-변화)
    - [2.4 👻 테스트의 중요성](#-테스트의-중요성)
- [3. 다음 미션에 적용할 학습 내용](#ledger-다음-미션에-적용할-학습-내용)
    - [3.1 🧐 지금까지의 피드백과 학습 내용 적용하기](#-지금까지의-피드백과-학습-내용-적용하기)
  
# :ballot_box_with_check: 구현 기능 목록
- [x] controller Package
    - [x] LottoController
        - view Package와 domain Package의 데이터를 전달하며 값을 출력하는 클래스
        - 프로그램을 실행하는 `run` 메서드
        - 티켓 개수를 불러오는 `loadTicket` 메서드
        - 티켓 개수를 활용하여 구매한 로또 리스트를 불러오고 출력하도록 하는 `buyLotto` 메서드
        - 당첨 번호를 불러오는 `loadWinningLotto` 메서드
        - 보너스 번호를 불러와 당첨번호와 비교하는 `loadBonusNumber` 메서드
        - 당첨 통계를 계산하고 출력하는 `lottoStatistics` 메서드
        - 수익률을 출력하는 `lottoProfit` 메서드


- [x] domain Package
    - [x] LottoJudge
        - 당첨 번호와 구매 번호의 매칭을 판단하는 클래스
        - 새로운 인스턴스를 생성하고 반환하는 create 메서드
        - 일치하는 개수에 따른 결과를 저장하는 `matchLottoHandler` 메서드
        - 구매한 로또와 당첨 번호가 몇개나 일치하는지 비교하는 `compareLotto` 메서드
        - 번호 5개가 일치하는 경우 보너스 번호가 일치하는지 확인하는 `checkBonus` 메서드
    - [x] GenerateLotto
        - 구매 번호를 랜덤한 값으로 구해주는 클래스
        - 새로운 인스턴스를 생성하고 반환하는 create 메서드
        - 구매 번호를 랜덤한 값으로 생성하는 `generateBuyLottos` 메서드
        - 구매한 로또 리스트를 반환하는 `getBuyLottos` 메서드
    - [x] LottoHandler
        - 로또 당첨 상태를 Enum으로 관리하는 클래스
        - 일치하는 개수와 enum 상수의 개수가 일치하는 lottoHandler 타입의 enum 상수를 반환하는 `getLottoHandler` 메서드 구현
        - 일치하는 개수를 반환하는 `getCount` 메서드 구현
        - 추가적인 문장을 반환하는 `getMessage` 메서드 구현
        - 당첨 금액을 반환하는 `getPrize` 메서드 구현
    - wrapper Package 
        - [x] Money
            - 구입 금액에 대한 유효성 검사와 구입 금액에 따른 티켓 수 반환을 진행하는 클래스
            - 새로운 인스턴스를 생성하고 반환하는 create 메서드
            - 구입 금액이 숫자로 반환이 가능한지 확인하는 `validateType` 메서드
            - 구입 금액이 0원 이하인지 확인하는 `validateMoney` 메서드
            - 구입 금액이 1000원으로 나눠 떨어지는지 확인하는 `validateDivision` 메서드
            - 구매 금액에 따른 티켓 수를 반환하는 `getTicket` 메서드
        - [x] Lotto
            - 모든 로또 번호 리스트들에 대한 유효성 검사와 로또 번호의 오름차순 값을 반환하는 일급 컬렉션
            - 새로운 인스턴스를 생성하고 반환하는 create 메서드
            - 매개 변수를 하나 받아서 인스턴스를 생성하고 반환하는 from 메서드
            - 로또 번호가 ,를 기준으로 나눠지고 숫자로 변환이 가능한지 확인하는 `validateType` 메서드
            - 로또 번호가 6개 맞는지 확인하는 `validateSize` 메서드
            - 중복되는 로또 번호가 있는지 확인하는 `validateDuplicate` 메서드
            - 로또 번호가 1 ~ 45 사이의 숫자가 맞는지 확인하는 `validateRange` 메서드
            - 로또 번호의 오름차순 값을 반환하는 `sortLottoNumbers` 메서드
        - [x] BuyLottos
            - 구입한 로또에 대한 정보를 갖고있는 클래스
            - 새로운 인스턴스를 생성하고 반환하는 create 메서드
            - 구매한 로또를 반환하는 `getBuyLottos` 메서드
        - [x] WinLottoWithBonus
            - 당첨 로또와 보너스 번호에 대한 유효성 검사와 반환을 진행하는 클래스 
            - 새로운 인스턴스를 생성하고 반환하는 create 메서드
            - 보너스 번호가 숫자로 반환이 가능한지 확인하는 `validateType` 메서드
            - 로또 번호와 보너스 번호가 중복되는지 확인하는 `validateDuplicate` 메서드
            - 보너스 번호가 1 ~ 45 사이인지 확인하는 `validateRange` 메서드
            - 로또 객체를 반환하는 `getLotto` 메서드
            - 보너스 번호를 반환하는 `getBonusNumber` 메서드
        - [x] LottoResult
            - 당첨 통계 데이터를 저장하고 수익률을 계산하는 클래스
            - 새로운 인스턴스를 생성하고 반환하는 create 메서드
            - 당첨 통계를 반환하는 `getLottoResult` 메서드
            - 수익률을 반환하는 `getProfit` 메서드
            - 전체 구매 금액을 반환하는 `totalPurchaseAmount` 메서드
            - 전체 당첨 금액을 반환하는 `totalPrize` 메서드


- [x] handler Package
    - [x] InputHandler
        - view Package의 ConsoleInput의 확장성과 변경 용이성을 위한 인터페이스
        - `inputValue` 메서드의 추상화
    - [x] OutputHandler
        - view Package의 ConsoleOutput의 확장성과 변경 용이성을 위한 인터페이스
        - `printInputMoneyMessage` 메서드의 추상화
        - `printBuyLottoList` 메서드의 추상화
        - `printInputWinningLottoMessage` 메서드의 추상화
        - `printInputBonusLottoMessage` 메서드의 추상화
        - `printLottoResult` 메서드의 추상화
        - `printProfit` 메서드의 추상화
    - [x] ErrorHandler
        - Enum 클래스를 활용하여 프로그램에서 발생하는 에러 코드들을 관리하는 클래스
        - ErrorMessage와 함께 `IllegalArgumentException` 예외를 발생시키는 `getException` 메서드
    - [x] ConstantsHandler
        - 프로그램내의 상수들을 관리하는 클래스
      

- [x] view Package
    - [x] ConsoleInput
        - 입력을 담당하는 클래스
        - 모든 입력값을 받아오는 `inputValue` 메서드 구현
    - [x] ConsoleOutput
        - 출력을 담당하는 클래스
        - 로또 구입 금액 입력을 요청하는 `printInputMoneyMessage` 메서드 구현
        - 구입한 로또 리스트를 보여주는 `printBuyLottoList` 메서드 구현
        - 당첨 번호 입력을 요청하는 `printInputWinningLottoMessage` 메서드 구현
        - 보너스 번호 입력을 요청하는 `printInputBonusLottoMessage` 메서드 구현
        - 당첨 통계를 보여주는 `printLottoResult` 메서드 구현
        - 수익률을 보여주는 `printProfit` 메서드 구현
  
```mermaid
classDiagram
    class Application {
        - inputHandler: InputHandler
        - outputHandler: OutputHandler
        +main(args: String[]): void
    }

    class LottoController {
        -inputHandler: InputHandler
        -outputHandler: OutputHandler
        +LottoController(inputHandler: InputHandler, outputHandler: OutputHandler)
        +run(): void
        -loadTicket(): Money
        -buyLotto(money: Money): BuyLottos
        -loadWinningLotto(): Lotto
        -loadBonusNumber(winningLotto: Lotto): WinLottoWithBonus
        -lottoStatistics(buyLottos: BuyLottos, winLottoWithBonus: WinLottoWithBonus): LottoResult
        -lottoProfit(lottoResults: LottoResult): void
    }

    class InputHandler {
        <<interface>>
        +inputValue(): String
    }

    class OutputHandler {
        <<interface>>
        +printInputMoneyMessage(): void
        +printBuyLottoList(buyLottos: List<Lotto>): void
        +printInputWinningLottoMessage(): void
        +printInputBonusLottoMessage(): void
        +printLottoResult(lottoResults: LottoResult): void
        +printProfit(lottoResults: LottoResult): void
    }

    class ConsoleInput {
        +inputValue(): String
    }

    class ConsoleOutput {
        +printInputMoneyMessage(): void
        +printBuyLottoList(buyLottos: List<Lotto>): void
        +printInputWinningLottoMessage(): void
        +printInputBonusLottoMessage(): void
        +printLottoResult(lottoResults: LottoResult): void
        +printProfit(lottoResults: LottoResult): void
    }

    class Money {
        +create(money: String): Money
        -validateType(money: String): int
        -validateMoney(purchaseAmount: int): void
        -validateDivision(purchaseAmount: int): void
        +getTicket(): int
    }

    class GenerateLotto {
        +create(money: Money): GenerateLotto
        -generateBuyLottos(money: Money): List<Lotto>
        +getBuyLottos(): List<Lotto>
    }

    class BuyLottos {
        +create(buyLottos: List<Lotto>): BuyLottos
        +getBuyLottos(): List<Lotto>
    }

    class Lotto {
        +create(numbers: List<Integer>): Lotto
        +from(inputValues: String): Lotto
        -validateType(inputValues: String): List<Integer>
        -validateSize(numbers: List<Integer>): void
        -validateDuplicate(numbers: List<Integer>): void
        -validateRange(numbers: List<Integer>): void
        +sortLottoNumbers(): List<Integer>
    }

    class WinLottoWithBonus {
        +create(winningLotto: List<Integer>, bonusNumber: String): WinLottoWithBonus
        -validateType(bonusNumber: String): int
        -validateDuplicate(bonusNumber: int): void
        -validateRange(bonusNumber: int): void
        +getBonusNumber(): int
        +getWinningLotto(): List<Integer>
    }

    class LottoJudge {
        +create(buyLottos: BuyLottos, winLottoWithBonus: WinLottoWithBonus): LottoJudge
        +matchLottoHandler(): Map<LottoHandler, Integer>
        -compareLotto(sortBuyLotto: List<Integer>, winningLotto: List<Integer>): int
        -checkBonus(sortBuyLotto: List<Integer>, bonusNumber: int): LottoHandler
    }

    class LottoResult {
        +create(lottoResult: Map<LottoHandler, Integer>): LottoResult
        +getProfit(): double
        +getLottoResult(): Map<LottoHandler, Integer>
        -totalPurchaseAmount(): int
        -totalPrize(): long
    }

    class LottoHandler {
        <<enumeration>>
        +getCount(): int
        +getMessage(): String
        +getPrize(): int
        +getLottoHandler(matchingCount: int): LottoHandler
    }

    class ConstantsHandler {
        <<enumeration>>
        +MIN_PURCHASE_AMOUNT: int
        +REMAINDER: int
        +UNIT_OF_AMOUNT: int
        +LOTTO_SIZE: int
        +COMMA_DELIMITER: String
        +MIN_LOTTO_NUMBER: int
        +MAX_LOTTO_NUMBER: int
        +TOTAL_PERCENTAGE: int
        +DEFAULT_VALUE: int
        +INIT_LONG_VALUE: long
        +INIT_INT_VALUE: int
        +PLUS_NUMBER: int
    }

    class ErrorHandler {
        <<enumeration>>
        -errorMessage: String
        +getException(): RuntimeException
    }

    InputHandler <|-- ConsoleInput
    OutputHandler <|-- ConsoleOutput

    Application --> LottoController : Creates
    Application --> InputHandler
    Application --> OutputHandler
    LottoController --> InputHandler 
    LottoController --> OutputHandler
    LottoController --> Money 
    LottoController --> GenerateLotto 
    LottoController --> BuyLottos 
    LottoController --> Lotto 
    LottoController --> WinLottoWithBonus 
    LottoController --> LottoJudge 
    LottoController --> LottoResult
    BuyLottos --> Lotto
    LottoResult --> LottoHandler
    GenerateLotto --> Money 
    GenerateLotto --> Lotto 
    LottoJudge --> Lotto
    LottoJudge --> BuyLottos
    LottoJudge --> WinLottoWithBonus 
    ConsoleOutput --> Lotto
    ConsoleOutput --> LottoResult
    ConsoleOutput --> LottoHandler
```

---

# :bookmark_tabs: 문제 해결 과정

## 🧪 2주 차 미션 피드백과 적용 사항

➡️ 3주 차 미션에서는 2주 차 미션에서 적어뒀던 다음 미션에 적용하고 싶었던 내용들을 적용해 보고, 2주 차 미션 후 진행한 코드 리뷰를 통해서 받았던 피드백을 적용해 보는 시간을 가졌다. 가장 먼저 내가 적용해야겠다고 생각한 학습 내용이다.

1. 코드 리뷰를 통해 받는 피드백을 적용했다. 두 가지의 피드백을 적용해 보고 싶었지만, 적용하고자 했던 피드백의 상황이 나오지 않아 적용 못 해본 부분이 아쉬웠다.

2. 이번 미션에서는 중간에 README와 테스트를 진행하지 않고 구현 시간을 알아보고 줄이기 위해 노력했다. 시간을 재고 구현을 해본 결과 10시간 동안 코드를 구현하는데 성공했고, 저번 미션보다 줄어든 구현 시간에 올바르게 학습하고 있다는 생각을 했다. 하지만 구현 중 테스트 코드를 구현하지 않았기 때문에 이 부분에 아쉬움을 느껴 다음 미션은 테스트 코드를 기능 이후 작성하는 습관을 들여야겠다고 다짐했다.

➡️ 다음은 첫번째 피드백 내용이다. 이러한 피드백 내용에 따라 이번 미션은 응집도를 높이는 부분에 집중했고 객체간 응집도를 높이는 코도를 작성했다고 생각한다.

🔸 (@oxdjww) : 개인적으로 forward는 carStatus보다는 Car에 적합한 메서드가 아니였나 싶네요..!

Car과 관련된 속성들을 클래스화 해주신 것 같은데, 이 클래스들을 모아서 관리하는 Car 클래스로 응집성을 높였으면 어땠을까 하는 생각입니다!

🔹 (본인) : 저도 고민했던 부분입니다! Car 객체에서 응집도를 높여서 해결할 수 있으면 좋을 것 같은데 아무래도 유효성 검증과 로직이 같이 들어가게 되니 클래스에서 하는 일들이 너무 많아지더라고여😅 그래서 저는 Car과 Position에 대해서 따로 클래스를 만들어 유효성 검증을 하고, CarStatus를 통해서 둘을 받아와서 다른 로직들을 수행하도록 작성했습니다!😊

좋은 의견 감사합니다..! 👍

➡️ 두 번째 피드백 내용은 for문과 관련된 내용이었다. 하지만 이번 미션은 for-Each 문으로 코드를 해결했기 때문에 이 피드백 내용은 적용하지 못했다.

🔸 (@jinchiim) : 이부분은 그냥 개인 의견입니다!
i라는 의미도 좋긴 하지만 네이밍을 같이 해주셔도 좋을 것 같아요! 🥰

🔹 (본인) : 코드를 작성하면서 i를 count와 같은 네이밍으로 변경하는 것이 좋을까 고민했었는데 유진님 말씀 듣고 보니 for문 자체가 어떤 일을 하는지 확실하게 알 수 있도록 네이밍 하는 방법도 좋았을 것 같습니다❗

## ✨ ConsoleInput의 책임과 유효성 검사의 위치

🔹 이번 미션에서는 `ConsoleInput` 클래스가 하는 일이 극단적으로 줄어들었다. 이전 미션까지는 `ConsoleInput` 내에서도 간단한 유효성 검사와 타입 변환을 통해 입력값마다 메서드를 두고 값을 받아왔지만 이번에는 모든 입력을 `inputValue` 메서드 하나에 의지하고 유효성 검사와 타입 변환의 책임을 domain package로 넘기도록 했다. 처음에는 `InputValidator`를 사용해서 view package에서 유효성 검사를 하더라도 테스트 시 불편함이 없도록 하는 것이 목표였지만, 이런 식으로 바뀌게 된 계기는 아래와 같다.

먼저, 입력에 대한 예외를 어떻게 처리할지 고민했다.

1. 입력 예외를 `ConsoleInput` 클래스에서 `InputValidator`없이 처리한다.

➡️ 위와 같은 경우 `ConsoleInput` 클래스에 try - catch 문을 활용해서 예외를 처리하게 될 것이다. 하지만, 이렇게 된다면 다른 클래스에서 사용하지 않을 stringToInt와 stringToList 메서드를 public으로 선언해야 하며, 테스트를 진행할 시 view에 대한 테스트를 따로 진행해야 한다는 불편함이 있다고 생각했다.

2. 입력 예외를 `ConsoleInput` 클래스에서 `InputValidator`를 활용해서 처리한다.

➡️ 다른 경우와 비교했을 때 `stringToInt`와 `stringToList` 메서드를 private으로 지정이 가능하고, 테스트 시에도 유효성 검사를 하기 편하다는 장점이 있지만, 여전히 view package에 유효성 검사와 타입의 변환 책임이 있는 것 같아 다른 방식을 생각하게 되었다.

3. 입력 예외를 domain에서 처리한다.

➡️ domain에서 입력에 대한 예외를 처리하기 위해서는 `ConsoleInput` 클래스에서 List 혹은 Int 등의 타입으로 변환하지 않고 String 상태 그대로 Controller에 전달을 하게 되고, 이렇게 된다면 Controller에서 필요한 타입으로 변환해서 domain 객체로 전달을 해야 한다. 이때, 필연적으로 Controller 클래스에서 변환 과정에 대한 예외 처리가 필요하고 이는 Controller package의 목적과 맞지 않다라고 생각했었다. 하지만, Controller에서 변환을 하지 않고 string 값 그대로 domain 객체로 들어가 그 안에서 예외 처리와 타입 변환을 한다면 테스트, SRP, 접근 제어자 등의 모든 부분을 해결할 수 있다고 생각했다.

## 🧐 Service package 사용의 변화

🔹 3주 차 미션에서는 저번 주차 미션과는 다르게 service package를 사용하지 않게 되었다. 처음 구현 기능 목록을 작성하면서는 service를 사용할 생각이었지만, 코드를 작성하면서 wrapper 클래스가 유효성 검사 부분을 담당한다면 service에 비즈니스 로직을 둘 필요 없이 domain 객체에 로직을 작성하면 된다고 생각했다. 

## 👻 테스트의 중요성

🔹 미션 중 생겼던 실수를 테스트를 실행해 보면서 알게 되었다. `ApplicationTest`의 예외_테스트 메서드를 진행하면서 테스트 실패가 발생했고, 원인을 찾아본 결과 요구사항을 제대로 읽지 못했던 것이 문제가 되었다. `사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.` 요구 사항의 가장 마지막 부분을 보면 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다 라는 부분이 있는데 이 요구사항을 평소와 같은 예외 처리 방식으로 처리하다 문제가 발생했다. 테스트 덕분에 이러한 사실을 알 수 있었고, 이번 주차에 지키지 못했던 기능 이후 바로 테스트 작성하기를 다음 미션에서 꼭 지켜야 하는 부분이라고 생각했다.

---

# :ledger: 다음 미션에 적용할 학습 내용

## 🧐 지금까지의 피드백과 학습 내용 적용하기

🔹 3주 차 까지 미션을 해오면서 학습한 내용과 받았던 피드백을 마지막 4주 차 과제에 전부 적용해 봐야 겠다고 생각했다. 피드백 받은 내용과 학습 내용을 최대한 적용해 보고자 했지만 빠진 부분도 있었고, 다른 부분을 신경 쓰다 놓치던 때도 있었다. 이러한 문제는 습관이 들어있지 않기 때문이라고 생각한다. 습관이 될 수 있도록 지속적으로 사용하는 것이 다음 미션 목표이다.