# 💰 구현할 기능 목록 [로또]

## 1. 구입 금액 입력 기능
- 사용자로부터 구입 금액을 입력받는다
- 로또 1장의 가격은 1,000원이다
  - 입력받은 금액은 1,000원 단위로 입력되어야 한다
    - 1,000원 단위로 입력되지 않으면 "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요."라는 에러 메시지를 출력하고 다시 입력을 받는다
  - 숫자 입력만 가능
    - 숫자로 입력되지 않으면 "[ERROR] 숫자를 입력해 주세요." 라는 에러 메시지를 출력하고 다시 입력을 받는다
## 2. 로또 발행 기능
- 구입 금액에 해당하는 만큼 로또를 발행한다
- 로또 번호는 중복되지 않는 6개의 숫자로 이루어져야 한다
  - 로또 번호의 범위는 1부터 45까지이다
- 발행된 로또 티켓은 사용자에게 출력된다
  - 번호는 오름차순으로 정렬하여 출력한다

## 3. 당첨 번호 입력 기능
- 사용자로부터 당첨 번호를 입력받는다
- 당첨 번호는 쉼표(,)로 구분하여 입력받는다
- 당첨 번호는 중복되지 않는 6개의 숫자로 이루어져야 한다
- 당첨 번호의 범위는 1부터 45까지이다

## 보너스 번호 입력 기능
- 사용자로부터 보너스 번호를 입력받는다
- 보너스 번호는 1개의 숫자로 입력받는다
- 보너스 번호의 범위는 1부터 45까지이다

## 당첨 내역 확인 및 출력 기능
- 발행한 로또와 당첨 번호를 비교하여 당첨 내역을 확인한다
- 당첨 내역은 1등부터 5등까지를 확인한다
  - 1등: 6개 번호 모두 일치
  - 2등: 5개 번호 일치 + 보너스 번호 일치
  - 3등: 5개 번호 일치
  - 4등: 4개 번호 일치
  - 5등: 3개 번호 일치
- 당첨 내역과 각 등수별 당첨 티켓 수를 사용자에게 출력한다
- 구입 금액 대비 수익률을 계산하고 출력한다

## 에러 처리 기능
- 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시킨다
- 에러 메시지는 "[ERROR]"로 시작한다

-----------------------------------------------------------------------------------------------------------

# 파일 구조
```
C:.
│  .gitignore
│  build.gradle
│  gradle.properties
│  gradlew
│  gradlew.bat
│  README.md
│  settings.gradle
│
├─.gradle
│  │  file-system.probe
│  │
│  ├─8.1.1
│  │  │  gc.properties
│  │  │
│  │  ├─checksums
│  │  │      checksums.lock
│  │  │
│  │  ├─dependencies-accessors
│  │  │      dependencies-accessors.lock
│  │  │      gc.properties
│  │  │
│  │  ├─executionHistory
│  │  │      executionHistory.bin
│  │  │      executionHistory.lock
│  │  │
│  │  ├─fileChanges
│  │  │      last-build.bin
│  │  │
│  │  ├─fileHashes
│  │  │      fileHashes.bin
│  │  │      fileHashes.lock
│  │  │      resourceHashesCache.bin
│  │  │
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  │      buildOutputCleanup.lock
│  │      cache.properties
│  │      outputFiles.bin
│  │
│  └─vcs-1
│          gc.properties
│
├─.idea
│      .gitignore
│      .name
│      compiler.xml
│      gradle.xml
│      jarRepositories.xml
│      misc.xml
│      uiDesigner.xml
│      vcs.xml
│      workspace.xml
│
├─build
│  ├─classes
│  │  └─java
│  │      ├─main
│  │      │  ├─domain
│  │      │  │  │  ErrorMessage.class
│  │      │  │  │  WinningNumbers.class
│  │      │  │  │
│  │      │  │  ├─LottoGame
│  │      │  │  │      CalculateResult.class
│  │      │  │  │      CalculateTotalPrize.class
│  │      │  │  │      CountMatchingNumbers.class
│  │      │  │  │      LottoGameResult.class
│  │      │  │  │
│  │      │  │  └─LottoTicket
│  │      │  │          LottoTicket.class
│  │      │  │          PaymentCalculator.class
│  │      │  │
│  │      │  ├─lotto
│  │      │  │      Application.class
│  │      │  │      Lotto.class
│  │      │  │
│  │      │  ├─parser
│  │      │  │      IntegerParser.class
│  │      │  │
│  │      │  └─ui
│  │      │      ├─input
│  │      │      │      NumbersInput.class
│  │      │      │      PurchaseAmount.class
│  │      │      │
│  │      │      └─output
│  │      │              PrintMatchResult.class
│  │      │              PrintResult.class
│  │      │              PurchasedLottos.class
│  │      │
│  │      └─test
│  │          ├─domain
│  │          │      LottoGameResultTest.class
│  │          │      LottoTest.class
│  │          │      LottoTicketTest.class
│  │          │      PaymentCalculatorTest.class
│  │          │      WinningNumbersTest.class
│  │          │
│  │          └─lotto
│  │                  ApplicationTest.class
│  │
│  ├─generated
│  │  └─sources
│  │      ├─annotationProcessor
│  │      │  └─java
│  │      │      ├─main
│  │      │      └─test
│  │      └─headers
│  │          └─java
│  │              ├─main
│  │              └─test
│  ├─reports
│  │  └─tests
│  │      └─test
│  ├─test-results
│  │  └─test
│  │      └─binary
│  │              output.bin
│  │              output.bin.idx
│  │
│  └─tmp
│      ├─compileJava
│      │  │  previous-compilation-data.bin
│      │  │
│      │  └─compileTransaction
│      │      ├─backup-dir
│      │      └─stash-dir
│      │              Application.class.uniqueId6
│      │              CalculateResult.class.uniqueId1
│      │              CountMatchingNumbers.class.uniqueId5
│      │              Lotto.class.uniqueId4
│      │              LottoTicket.class.uniqueId3
│      │              NumbersInput.class.uniqueId2
│      │              PaymentCalculator.class.uniqueId9
│      │              PurchaseAmount.class.uniqueId0
│      │              PurchasedLottos.class.uniqueId7
│      │              WinningNumbers.class.uniqueId8
│      │
│      ├─compileTestJava
│      │      previous-compilation-data.bin
│      │
│      └─test
├─docs
│      README.md
│
├─gradle
│  └─wrapper
│          gradle-wrapper.jar
│          gradle-wrapper.properties
│
└─src
    ├─main
    │  └─java
    │      ├─domain
    │      │  │  ErrorMessage.java
    │      │  │  WinningNumbers.java
    │      │  │
    │      │  ├─LottoGame
    │      │  │      CalculateResult.java
    │      │  │      CalculateTotalPrize.java
    │      │  │      CountMatchingNumbers.java
    │      │  │      LottoGameResult.java
    │      │  │
    │      │  └─LottoTicket
    │      │          LottoTicket.java
    │      │          PaymentCalculator.java
    │      │
    │      ├─lotto
    │      │      Application.java
    │      │      Lotto.java
    │      │
    │      ├─parser
    │      │      IntegerParser.java
    │      │
    │      └─ui
    │          ├─input
    │          │      NumbersInput.java
    │          │      PurchaseAmount.java
    │          │
    │          └─output
    │                  PrintMatchResult.java
    │                  PrintResult.java
    │                  PurchasedLottos.java
    │
    └─test
        └─java
            ├─domain
            │      LottoTest.java
            │
            └─lotto
                    ApplicationTest.java


```
### 주요 소스 코드 디렉토리
* domain: 애플리케이션의 비즈니스 로직을 담고 있는 클래스들이 위치
  * ErrorMessage.java: 애플리케이션에서 발생할 수 있는 에러 메시지를 Enum으로 관리
  * WinningNumbers.java: 추첨된 당첨 번호를 관리하는 클래스
* LottoGame: 로또 게임과 관련된 핵심 로직이 있는 클래스들의 패키지
  * CalculateResult.java: 사용자의 로또와 당첨 번호를 비교하여 결과를 계산
  * CalculateTotalPrize.java: 당첨된 결과를 기반으로 총 상금을 계산
  * CountMatchingNumbers.java: 사용자의 로또 번호와 당첨 번호를 비교하여 일치하는 숫자의 개수를 세는 기능을 제공
  * LottoGameResult.java: 게임의 결과를 나타내는 데이터를 담는 클래스
* LottoTicket: 로또 티켓 관련 클래스들의 패키지
  * LottoTicket.java: 하나의 로또 티켓과 그에 포함된 번호들을 관리
  * PaymentCalculator.java: 구입 금액에 따라 로또 티켓을 발급하는 로직을 담당
  
* lotto: 애플리케이션의 진입점 및 로또 관련 기본 클래스들이 위치
  * Application.java: 애플리케이션의 메인 클래스로, 프로그램 실행의 시작점
  * Lotto.java: 로또 번호를 관리하는 기본 클래스

* parser: 입력된 문자열을 파싱하는 기능을 담당하는 클래스들이 위치
  * IntegerParser.java: 문자열로부터 정수를 파싱하는 기능을 제공
* ui: 사용자 인터페이스 관련 클래스들이 위치
  * input: 사용자로부터 입력을 받는 클래스들이 위치
    * NumbersInput.java: 사용자로부터 번호 입력
    * PurchaseAmount.java: 사용자로부터 구입 금액 입력
  * output: 결과를 사용자에게 보여주는 출력 관련 클래스들이 위치
    * PrintMatchResult.java: 일치하는 결과를 출력
    * PrintResult.java: 최종 게임 결과를 출력
    * PurchasedLottos.java: 구입한 로또 티켓을 출력
### 테스트 코드 디렉토리
* domain: domain 패키지 내의 클래스들을 테스트하는 테스트 케이스들이 위치
  * LottoTest.java: Lotto 클래스의 로직을 테스트
* lotto: lotto 패키지의 클래스들, 특히 Application 클래스를 테스트하는 테스트 케이스들이 위치
  * ApplicationTest.java: Application 클래스의 로직을 테스트