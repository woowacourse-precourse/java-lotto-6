# 미션 - 로또

## 📄 파일 구조

```agsl
├── docs
│   └── README.md
└── src
    ├── main
    │   └── java
    │       └── lotto
    │           ├── Application.java
    │           ├── constant
    │           │   ├── ErrorConstant.java
    │           │   ├── MessageConstant.java
    │           │   ├── ModelConstant.java
    │           │   ├── UtilsConstant.java
    │           │   └── ValidatorConstant.java
    │           ├── controller
    │           │   └── LottoController.java
    │           ├── model
    │           │   ├── Bonus.java
    │           │   ├── Lotto.java
    │           │   ├── LottoMatchResult.java
    │           │   ├── Payment.java
    │           │   ├── Prize.java
    │           │   ├── PrizeResult.java
    │           │   ├── Profit.java
    │           │   ├── Result.java
    │           │   ├── Total.java
    │           │   └── User.java
    │           ├── service
    │           │   └── LottoService.java
    │           ├── utils
    │           │   ├── FormatUtils.java
    │           │   └── RandomUtils.java
    │           ├── validator
    │           │   ├── BonusValidator.java
    │           │   ├── LottoNumberValidator.java
    │           │   └── PaymentValidator.java
    │           └── view
    │               ├── InputView.java
    │               └── OutputView.java
    └── test
        └── java
            └── lotto
                ├── ApplicationTest.java
                └── model
                    ├── BonusTest.java
                    ├── LottoTest.java
                    ├── PaymentTest.java
                    ├── PrizeResultTest.java
                    ├── ResultTest.java
                    └── UserTest.java

```

<hr>

##  📒 구현 기능 목록
#### 1. 로또 구입 금액을 입력받는다.
```agsl
구입금액을 입력해 주세요.
```
- [x] 로또 구입은 1,000원 단위로 입력 받는다. ```Payment```
- [x] 예외처리
    - [x] 1000원으로 나누어 떨어지지 않는 경우 ```PaymentValidator#validatePurchaseUnit()```
    - [x] 숫자가 아닌 문자를 입력하는 경우 ```PaymentValidator#validateNumeric()```
    - [x] 예외가 발생한 시점부터 다시 입력받는다.  ```LottoController#inputBuyLottoTickets()```

#### 2. 구입한 로또 n개 만큼 로또 번호를 랜덤 생성한다.
```agsl
n 개를 구매했습니다. // (8개를 구매했다면)
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```
- [x] 구매 티겟 갯수를 산정한다. ```Payment#calculateTicketsCount()```
- [x] 티겟 갯수만큼 로또 번호를 생성한다. ```User#createLottoCounts()```
  - [x] 로또 번호는 중복되지 않는다. ```RandomUtils#makeRandomNumber()```
  - [x] 로또 번호는 6자리이다. ```RandomUtils#makeRandomNumber()```
  - [x] 로또 번호는 오름차순으로 정렬한다. ```User#sortLottoCounts()```

#### 3. 로또 당첨 번호를 입력받는다.
```agsl
당첨 번호를 입력해 주세요.
```
- [x] 쉼표(,)를 기준으로 구분한다. ```InputView#getInputLine()```
- [x] 예외처리
    - [x] 로또 번호가 1 ~ 45 범위가 아닌 경우 ```LottoNumberValidator#validateRange()```
    - [x] 로또 번호가 6개가 아닌 경우 ```LottoNumberValidator#validateNumberSize()```
    - [x] 로또 번호가 중복되는 경우 ```LottoNumberValidator#validateDuplicate()```
    - [x] 예외가 발생한 시점부터 다시 입력받는다. ```LottoController#inputWinnerLottoTicket()```
      
#### 4. 보너스 번호를 입력받는다.
```agsl
보너스 번호를 입력해 주세요.
```
- [x] 보너스 번호를 입력한다. ```InputView#getInputLine()```
- [x] 예외처리
  - [x] 보너스 번호가 1~45 범위가 아닌 경우 ```BonusValidator#validateRange()```
  - [x] 로또 번호랑 중복되는 경우 ```BonusValidator#validateDuplicate()```
  - [x] 숫자가 아닌 문자를 입력하는 경우 ```BonuseValidator#validateNumeric()```
  - [x] 예외가 발생한 시점부터 다시 입력받는다. ```LottoController#inputBonusNumber()```

#### 5. 당첨 내역을 계산한다.
- [x] 유저 번호와 당첨 번호를 비교한다. ```Result#compareLottoNumber()```
- [x] 유저 번호와 보너스 번호를 비교한다. ```Result#checkBonusNumber()```

#### 6. 당첨 결과 로또 순위를 계산한다.
```agsl
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```
- [x] 일치하는 로또 번호와 보너스 번호로 순위를 계산한다. ```PrizeResult#comparePrize()```
- [x] 순위별로 맞은 갯수를 계산한다. ```Total#calculateTotalPrize()```


#### 6. 수익률을 계산한다.
```agsl
총 수익률은 62.5%입니다.
```
- [x] 구입 금액 / 당첨 금액 으로 계산한다. ```Profit#calculateTotalProfit()```
- [x] 소수점 둘째 자리에서 반올림한다. ```FormatUtils#parseFormattedDoubleValue```

<hr>

## 📝 기능 요구사항
### 로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

#### 1. 로또 번호의 숫자 범위는 1~45까지이다.
#### 2. 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
#### 3. 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
#### 4. 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다. 
    
```
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
  ```
  
#### 5. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
#### 6. 로또 1장의 가격은 1,000원이다.
#### 7. 당첨 번호와 보너스 번호를 입력받는다.
#### 8. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
#### 9. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
#### 10. Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
<hr>



## 📌 프로그래밍 요구 사항
#### 1. JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.
#### 2. 프로그램 실행의 시작점은 Application의 main()이다.
#### 3. build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
#### 4. Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
#### 5. 프로그램 종료 시 System.exit()를 호출하지 않는다.
#### 6. 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
#### 7. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
#### 8. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
#### 9. 3항 연산자를 쓰지 않는다.
#### 10. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
#### 11. JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

<hr>

## ✏️ 추가된 요구 사항
#### 1. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
#### 2. 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
#### 3. else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
#### 4. Java Enum을 적용한다.
#### 5. 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
#### 6. 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
#### 7.단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.

<hr>

## 📝 과제 진행 요구 사항
#### 1. 미션은 java-racingcar-6 저장소를 Fork & Clone해 시작한다.
#### 2. 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.
#### 3. Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가한다.
#### 4. 커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성한다.
#### 5. 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.

<hr>

## ❗️ 2주차 공통 피드백
#### 1. README.md를 상세히 작성한다.
#### 2. 기능 목록을 재검토한다.
#### 3. 기능 목록을 업데이트한다.
#### 4. 값을 하드 코딩하지 않는다.
#### 5. 구현 순서도 코딩 컨벤션이다.
#### 6. 변수 이름에 자료형은 사용하지 않는다
#### 7. 한 함수가 한 가지 기능만 담당하게 한다
#### 8. 함수가 한 가지 기능을 하는지 확인하는 기준을 세운다
#### 9. 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다
#### 10. 처음부터 큰 단위의 테스트를 만들지 않는다
