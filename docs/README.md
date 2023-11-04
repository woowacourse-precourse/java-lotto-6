## 기능 요구 사항

**로또 게임**

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

**게임 흐름**

1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
2. 로또 1장의 가격은 1,000원이다.
3. 당첨 번호와 보너스 번호를 입력받는다. 
4. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

## 기능 목록

### InputView
- [x] 로또 구입 금액을 입력한다.
  - [x] 구입 금액은 1,000원 단위다.
- [x] 당첨 번호를 입력한다.
  - [x] 번호는 쉼표(,)를 기준으로 구분한다.
- [ ] 보너스 번호를 입력한다.
  - [ ] 당첨 번호에 포함되지 않고 1 ~ 45 사이의 숫자이다.

### InputValidator
- [x] 숫자를 입력했는지 검증한다.
- [x] 쉼표를 기준으로 입력하였는지 검증한다.

### InputMapper 
- [x] 로또 구입 금액을 입력 받으면 LottoPurchasePrice 객체를 반환한다.
- [x] 당첨 번호를 입력 받으면 Lotto 객체를 반환한다.
- [ ] 보너스 번호를 입력 받으면 BonusNumber 객체를 반환한다.

### InputManager
- [x] Controller 로부터 로또 구입 금액 입력 요청을 관리한다.
- [x] 사용자가 잘못된 값을 입력할 경우 그 부분부터 다시 입력한다.

### OutputView
- [x] 구입한 로또들을 형식에 맞게 출력한다.

### LottoPurchasePrice
- [x] 로또 구입 금액을 저장한다.
  - [x] 로또 구입 금액은 1000원 단위어야 한다.

### BonusNumber
- [ ] 보너스 번호를 저장한다.

### Lotto 
- [x] 당첨 로또 번호를 저장한다.

### Lottos
- [x] 로또 구입 금액 만큼 생성된 로또들을 저장한다.

### Numbers
- [x] 생성된 각 로또를 저장한다.
  - [x] 각 로또들은 오름차순으로 정렬한다.

### Number
- [x] 로또의 번호를 저장한다.

### LottosResultFormatter
- [x] 생성된 로또들을 출력 형태에 맞게 전달해준다.

### LottoStatistics
- [ ] 로또의 통계 내역을 저장한다.
- [ ] 수익률을 계산한다.

### LottoStatisticsResultDto
- [ ] 로또 통계 내역을 출력 형태에 맞게 전달해준다.

### LottoController
- [ ] 로또 게임을 시작한다.

### LottoFactory
- [x] 로또 게임 객체들의 의존성을 주입시켜준다.

## 유틸 목록

### LottoRandomNumber
- [x] 1 ~ 45 사이의 랜덤된 숫자 6개를 생성한다.

## 상수 목록

### ErrorMessage
- [x] 에러 메시지 상수

### ProgressMessage
- [x] 게임 진행 메시지 상수

### InputPattern
- [x] 정규식 패턴 상수

### LottoRule
- [x] 로또 게임 규칙 값 상수

### WinningFactor
- [ ] 당첨 기준에 따른 금액 상수

## 예외 목록

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


- NotNumericException
  - [x] 숫자를 입력하지 않을 경우 예외가 발생한다.
- NotThousandUnitException
  - [x] 로또 구입 금액을 1000단위로 입력하지 않을 경우 예외가 발생한다.
- NotDivisionCommaException
  - [x] 당첨 번호를 쉼표로 구분하지 않을 경우 예외가 발생한다.
- LottoNumberDuplicateException
  - [x] 당첨 로또가 중복되어 입력될 경우 예외가 발생한다.
- LottoNumberRangeException
  - [x] 당첨 로또의 범위가 1~45 가 아닐 경우 예외가 발생한다.
- LottoNumberSizeException
  - [x] 당첨 로또의 크기가 6이 아닐 경우 예외가 발생한다.


  - [ ] 보너스 번호를 숫자가 아닌 다른 문자로 입력하면 예외
