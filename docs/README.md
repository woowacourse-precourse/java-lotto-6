### 목차
[1. 프로젝트 설명](#-로또-프로그램)</br>
[2. 구현할 기능 목록](#-구현할-기능-목록)</br>
[3. 추가된 요구 사항](#-추가된-요구-사항)</br>
[4. 클래스별 기능](#클래스별-기능)</br>
- - -
## 💰 로또 프로그램
로또 게임을 체험 할 수 있는 프로그램이다.
1. 구입금액을 입력하여 로또를 구매한다.
2. 로또의 번호는 자동으로 생성된다.
3. 당첨 번호를 입력한다.
4. 보너스 번호를 입력한다.
5. 구매한 로또와 당첨 번호, 보너스 번호를 비교하여 통계를 낸다.
6. 총 수익률을 나타낸다.

### 요구사항
```
- 로또 1장의 가격은 1,000원이다.
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```
### 실행 결과 예시
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## 📝 구현할 기능 목록
👊입력
- [x] 로또 구입 금액을 입력 받는다.
  - [x] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
  - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생
  - [x] [ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다
- [x] 당첨 번호를 입력 받는다. 
  - [x] 번호는 쉼표(,)를 기준으로 구분한다.
  - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생
  - [x] [ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다
- [x] 보너스 번호를 입력 받는다.
  - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생
  - [x] [ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다

✋출력
- [x] 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- [x] 당첨 내역을 출력한다.
- [x] 수익률은 소수점 둘째 자리에서 반올림한다.
- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다

🚗기능
- [x] 구입금액에 따라서 로또 구매
- [x] 로또의 번호를 중복되지 않게 뽑기
- [x] 당첨번호와 구매한 로또번호를 비교
- [x] 맞춘 갯수에 따라서 등수 설정
- [x] 수익률 구하기
- [x] 로또 클래스 validate 구현
  - [x] 로또 번호 갯수 검증
  - [x] 로또 번호 범위 검증
  - [x] 로또 번호 중복 검증
  
🎸신경쓸 것
- 기능 목록을 재검토한다
- 기능 목록을 업데이트한다
- 값을 하드 코딩하지 않는다
  - 상수(static final)를 만들고 이름을 부여해 이 변수의 역할이 무엇인지 의도를 드러내라.
- 구현 순서도 코딩 컨벤션이다
  - 클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성한다.
- 변수 이름에 자료형은 사용하지 않는다
- 한 함수가 한 가지 기능만 담당하게 한다
- 함수가 한 가지 기능을 하는지 확인하는 기준을 세운다
    - 만약 여러 함수에서 중복되어 사용되는 코드가 있다면 함수 분리를 고민해 본다. 
      또한, 함수의 길이를 15라인을 넘어가지 않도록 구현
- 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다
- 처음부터 큰 단위의 테스트를 만들지 않는다
- 배열 대신 Java Collection을 사용한다
- Java에서 제공하는 API를 적극 활용한다
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- - -
## 💯 추가된 요구 사항
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
- [x] 3항 연산자를 쓰지 않는다.
- [x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [x] else 예약어를 쓰지 않는다
- [x] Java Enum을 적용한다.
- [x] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [x] 제공된 Lotto 클래스를 활용해 구현해야 한다.
- - -
## 🎰클래스별 기능
Application: LottoController를 생성하고 실행
### constant
1. ErrorMessages: 예외발생시 출력할 에러메시지 static final 정의  클래스
2. PrintMessages: 프롬프트와 결과 출력을 위한 메시지 static final 정의 클래스
3. LottoRank: 로또 등수 관련 상수(맞춰야 하는 번호 갯수, 상금)들의 enum 클래스
4. LottoConfig: 로또 관련 상수들(가격, 번호 갯수, 유효 번호)의 enum 클래스

### controller
1. LottoController: 로또 로직을 담당하는 클래스
- run: 로또 프로그램 실행 메서드
- purchaseLotto: InputHandler를 이용하여 구매할 로또 금액을 입력하고 로또를 구매하는 메서드
- inputWinningNumber: InputHandler를 이용하여 당첨 번호를 입력하는 메서드
- inputBonusNumber: InputHandler를 이용하여 보너스 번호를 입력하는 메서드
- checkLottoRank: Lottos를 이용하여 당첨 번호, 보너스 번호와 구매한 로또의 당첨 순위를 매기는 메서드
- calcRateOfReturn: LottoRank를 이용하여 수익률을 구하는 메서드
- toIntegers: List<String>을 List<Integer>로 변경해주는 메서드

### model
1. Lotto: 로또 번호를 가지는 클래스
- validate: LottoValidator를 이용하여 Lotto 생성자를 검증하는 메서드
- getRank: 당첨 번호를 인자로 받아 로또 등수를 반환하는 메서드
- countCommonBonusNumber: 보너스 번호를 맞췄다면 count를 1 더하고 반환하는 메서드
- countCommonNumbers: 로또 번호와 당첨 번호를 비교하여 맞는 갯수를 반환하는 메서드
- findLottoRank: 맞춘 번호의 갯수와 맞춘 보너스 번호여부로 로또 등수를 반환하는 메서드

2. Lottos: List<Lotto>를 가지는 클래스 
- checkRanks: List<Lotto>의 Rank를 구하고 반환하는 메서드

3. LottoStroe: 로또 발행 클래스
- publishLotto: 받은 돈을 기준으로 로또를 생성하여 반환하는 메서드
- pickLottosNumbers: 발행해야하는 로또의 개수를 인자로 받고 로또에 Random 번호를 부여하는 메서드

4. WinningNumber: 당첨 번호 클래스
- getNumbers: 당첨 번호 반환 하는 메서드
- getBonusNum: 보너스 번호 반환 하는 메서드

### validators
1. InputValidator
- validatePriceInput: 입력한 구입 금액을 검증하고 예외를 발생시키는 메서드
- validateWinnigNumberInput: 입력한 당첨 번호를 검증하고 예외를 발생시키는 메서드
- validateBonusNumberInput: 입력한 보너스 번호를 검증하고 예외를 발생시키는 메서드
- isNumericString: 입력한 String이 숫자로만 이루어졌는지 확인하는 메서드
- isValidPurchaseUnit: 입력한 구입 금액이 로또 가격에 나누어 떨어지는지 확인하는 메서드
- isValidWinningNumberLength: 입력한 당첨 번호의 길이를 확인하는 메서드
- isValidLottoNumbersRange: 번호들의 범위가 적절한지 확인하는 메서드
- hasDuplicatesWinningNumber: 입력한 당첨 번호가 중복이 있는지 확인하는 메서드
- isValidLottoNumberRange: 번호의 범위가 절절한지 확인하는 메서드
- hasDuplicatesBonusNumber: 보너스 번호가 당첨 번호와 중복이 있는지 확인하는 메서드

2. LottoValidator
- validateLottoConstructor: 로또 생성자가 적절한지 검증하는 메서드
- validateNumbersLength: 번호의 길이가 적절하지 않다면 예외를 발생시키는 메서드
- validateNumbersRange: 번호의 범위가 적절하지 않다면 예외를 발생시키는 메서드
- validateDuplicatedNumbers: 번호에 중복이있다면 예외를 발생시키는 메서드
- isValidateNumbersLength: 번호의 길이가 적절한지 확인하는 메서드
- isValidateNumbersRange: 번호의 범위가 적절한지 확인하는 메서드
- isDuplicatedNumbers: 번호의 중복을 확인하는 메서드

### view
1. InputHandler
- purchasePrice: 구입 금액 입력을 처리하는 메서드
- winningNumber: 당첨 번호 입력을 처리하는 메서드
- bonusNumber: 보너스 번호 입력을 처리하는 메서드

2. OutputHandler
- printPurchaseHistory: 구매한 로또들을 출력하는 메서드
- printWinningStats: 당첨 결과를 출력하는 메서드
- printLottoNumbers: 로또의 번호를 출력하는 메서드

### test
1. assertThat을 이용한 Enum 클래스 검증
2. 모든 public 메서드 테스트
3. assertThatThrownBy, assertDoesNotThrow를 이용한 validator 테스트