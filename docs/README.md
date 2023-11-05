# 💰 구현할 기능 목록 [로또]

## 1. 구입 금액 입력 기능
- 사용자로부터 구입 금액을 입력받는다
  - 입력받은 금액은 1,000원 단위로 입력되어야 한다
    - 1,000원 단위로 입력되지 않으면 "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요."라는 에러 메시지를 출력하고 다시 입력을 받는다

## 2. 로또 발행 기능
- 구입 금액에 해당하는 만큼 로또를 발행한다
- 로또 1장의 가격은 1,000원이다
- 로또 번호는 중복되지 않는 6개의 숫자로 이루어져야 한다
- 로또 번호의 범위는 1부터 45까지이다

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
- 당첨 번호와 보너스 번호를 이용하여 2등을 확인한다
- 당첨 내역과 수익률을 출력한다

## 에러 처리 기능
- 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시킨다
- 에러 메시지는 "[ERROR]"로 시작한다

-----------------------------------------------------------------------------------------------------------

# Class 별 기능
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
│  │      │  │      Lotto.class
│  │      │  │      LottoGameResult.class
│  │      │  │      LottoTicket.class
│  │      │  │      PaymentCalculator.class
│  │      │  │      WinningNumbers.class
│  │      │  │
│  │      │  └─lotto
│  │      │          Application.class
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
│      │              Application.class.uniqueId0
│      │
│      ├─compileTestJava
│      │      previous-compilation-data.bin
│      │
│      └─test
├─docs
│      README.md
│
├─gradle
    └─test
        └─java
            ├─domain
            │      LottoGameResultTest.java
            │      LottoTest.java
            │      LottoTicketTest.java
            │      PaymentCalculatorTest.java
            │      WinningNumbersTest.java
            │
            └─lotto
                    ApplicationTest.java


```
* Lotto.java : 로또 번호와 관련된 기능을 처리합니다.
* Application.java : 프로그램의 진입점입니다.
* WinningNumbers.java : 당첨 번호와 보너스 번호를 관리합니다. 당첨 번호와 보너스 번호를 입력하고, 로또 티켓과 비교하여 당첨 결과를 확인합니다.
* LottoTicket.java : 하나의 로또 티켓을 나타냅니다. 로또 번호 배열을 포함하고, 당첨 번호와 비교하여 당첨 결과를 계산합니다.
* PaymentCalculator.java : 로또 티켓을 얼마나 많이 구매할 지 결정합니다. 사용자로부터 입력받은 금액을 기반으로 로또 티켓을 발행합니다.
* LottoGameResult.java : 로또 게임의 결과를 나타냅니다. 당첨 번호와 비교하여 당첨 내역 및 수익률을 계산합니다.