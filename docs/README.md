# 🚀 기능 요구 사항 - 로또 게임

## Model
### Lotto
- [x] 로또 번호의 전체 상태를 관리한다.
- [x] 유효한 로또 번호 리스트인지 확인한다.
    - [x] 로또 번호는 6개여야 한다.
    - [x] 로또 번호는 중복되면 안된다.
    - [x] 로또 번호는 1부터 45까지 숫자여야 한다.

### WinningNumber
- [x] 당첨 번호와 보너스 번호의 전체 상태를 관리한다.

### Rank
- [x] 로또 순위를 정의하고, 해당 순위의 상세 내용과 상금을 관리한다.

### CalculatorMatching
- [ ] 로또 번호 일치 여부를 계산하고, 해당 순위를 반환한다.
    - [ ] 6개 숫자 일치: 1등
    - [ ] 5개 숫자 + 보너스 번호 일치: 2등
    - [ ] 5개 숫자 일치: 3등
    - [ ] 4개 숫자 일치: 4등
    - [ ] 3개 숫자 일치: 5등
    - [ ] 일치하지 않는 경우: 당첨 없음

### CalculatorProfit
- [ ] 당첨 번호에 따른 총 상금을 계산한다.
- [ ] 당첨 번호가 일치하는 티켓 수를 카운트한다.
- [ ] 총 수익률을 계산한다.

### LottoGenerator
- [ ] 로또 구매 금액에 맞는 Lotto를 생성한다.

### RandomListGenerator
- [ ] 무작위 로또 번호 리스트를 생성한다.
- [ ] 생성된 번호 리스트는 1부터 45까지의 중복되지 않는 6개의 숫자로 구성된다.

## View
### InputView
- [x] 사용자로부터 로또 구입 금액을 입력받는다.
- [x] 사용자로부터 당첨 번호를 입력받는다.
- [x] 사용자로부터 보너스 번호를 입력받는다.

### OutputView
- [x] 게임 시작 메시지를 출력한다.
- [x] 구매한 로또 티켓 수와 번호를 출력한다.
- [x] 당첨 결과를 출력한다.
- [x] 총 수익률을 출력한다.
- [x] 에러 메세지를 출력한다.

## Controller
- [ ] 게임을 시작하고 종료한다.
- [ ] 로또 티켓을 초기화하고 발행한다.
- [ ] 당첨 번호와 보너스 번호를 입력받아 게임을 진행한다.
- [ ] 당첨 결과와 수익률을 계산하여 출력한다.
- [ ] 잘못된 입력값에 대한 예외 처리를 수행한다.
- [ ] 부적절한 메서드가 불리는 것에 대한 예외 처리를 수행한다.

## Validator
### BonusNumberValidator
- [x] 보너스 번호의 유효성을 검증한다.
    - [x] 번호가 공백이 아닌지 검증한다.
    - [x] 번호가 정수인지 검증한다.
    - [x] 번호가 1부터 45 사이의 숫자인지 검증한다.
    - [x] 번호가 당첨 번호와 중복되지 않는지 검증한다.

### PurchaseValidator
- [x] 로또 구입 금액의 유효성을 검증한다.
    - [x] 금액이 공백이 아닌지 검증한다.
    - [x] 금액이 long 값인지 검증한다.
    - [x] 금액이 양수인지 검증한다.
    - [x] 금액이 1,000원 단위로 입력되었는지 검증한다.

### WinningNumberValidator
- [x] 당첨 번호의 유효성을 검증한다.
    - [x] 숫자가 공백이 아닌지 검증한다.
    - [x] 6개의 숫자로 구성되었는지 검증한다.
    - [x] 숫자가 정수인지 검증한다.
    - [x] 숫자가 1부터 45 사이의 숫자인지 검증한다.
    - [x] 숫자가 중복되지 않는지 검증한다.

## Exception
- [x] INVALID_BONUS_NUMBER_TYPE: 보너스 번호는 정수값
- [x] INVALID_BONUS_NUMBER_RANGE: 보너스 번호는 1부터 45 사이의 숫자
- [x] NULL_OR_EMPTY_BONUS_NUMBER: 보너스 번호는 null이나 공백일 수 없음
- [x] DUPLICATE_BONUS_NUMBER: 보너스 번호는 당첨 번호와 중복될 수 없음

- [x] INVALID_PURCHASE_AMOUNT: 구매 금액은 자연수 값
- [x] NULL_OR_EMPTY_PURCHASE_AMOUNT: 구매 금액은 null이나 공백일 수 없음
- [x] INVALID_PURCHASE_AMOUNT_FORMAT: 구입 금액은 1,000원 단위

- [x] INVALID_WINNING_NUMBER_RANGE: 당첨 번호는 1부터 45 사이의 숫자
- [x] DUPLICATE_WINNING_NUMBERS: 당첨 번호는 중복될 수 없음
- [x] INVALID_WINNING_NUMBER_FORMAT: 당첨 번호는 정수값
- [x] INVALID_WINNING_NUMBER_COUNT: 당첨 번호의 개수는 6개
- [x] NULL_OR_EMPTY_WINNING_NUMBERS: 당첨 번호는 null이나 공백이 들어갈 수 없음

- [x] INVALID_LOTTO_NUMBER_RANGE: 로또 번호는 1부터 45 사이의 숫자
- [x] DUPLICATE_LOTTO_NUMBERS: 로또 번호는 중복될 수 없음
- [x] INVALID_LOTTO_NUMBER_COUNT: 로또 번호의 개수는 6개

- [ ] ILLEGAL_STATE_ERROR: ILLEGAL_STATE_ERROR 발생

## 프로그래밍 요구 사항
- [ ] JDK 17 버전에서 실행 가능한지 확인
- [ ] 프로그램 시작점은 Application의 main() 메서드인지 확인
- [ ] build.gradle 파일을 변경하지 않았는지 확인
- [ ] 외부 라이브러리를 사용하지 않았는지 확인
- [ ] Java 코드 컨벤션 가이드를 준수했는지 확인
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않았는지 확인
- [ ] 모든 함수(또는 메서드)가 한 가지 일만 하도록 작게 만들었는지 확인
- [ ] 함수 내의 indent(들여쓰기) depth가 3을 넘지 않았는지 확인
- [ ] 3항 연산자를 사용하지 않았는지 확인
- [ ] 기능 목록이 정상 동작하는 테스트 코드를 작성했는지 확인