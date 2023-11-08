# 로또 서비스

이 프로그램은 사용자로부터 로또 구매 금액을 입력받은 후, 랜덤 숫자를 이용하여 로또를 발급합니다.
사용자는 이후 당첨 번호와 보너스 번호를 입력하고, 프로그램은 사용자에게 당첨 통계를 출력합니다.

## 사용자 입력 검증 목록

1. 구매금액 검증(`validateMoney` 메소드)

- [x] 로또 가격보다 입력한 돈이 적은지 확인
- [x] 입력한 돈이 로또 가격으로 나누어 떨어지는지 확인

2. 당첨 번호 검증(`validateWinningNumbers` 메소드)

- [x] 당첨 번호의 길이가 올바른지 확인
- [x] 당첨 번호가 중복되는지 확인
- [x] 각 당첨 번호가 범위 내에 있는지 확인

3. 보너스 번호 검증(`validateBonusNumber` 메소드)

- [x] 보너스 번호가 범위 내에 있는지 확인
- [x] 보너스 번호가 당첨 번호 6자리와 중복되는지 확인

## 컨트롤러

컨트롤러는 View와 Model을 이용하여 프로그램의 실행 흐름을 제어합니다.

### LottoController

1. 사용자로부터 로또 구입 금액, 당첨 번호, 보너스 번호를 입력 받습니다.
2. `InputHandler`를 통해 검증된 사용자 입력을 전달받습니다.
3. 사용자 입력을 토대로 로또를 생성하고 결과를 출력합니다.

### InputParser

- 사용자의 입력을 파싱하는 클래스입니다.
- 숫자로 변환하는 과정에서 오류가 발생할 시 `IllegalArgumentException`이 발생합니다.
- 오류 메시지는 `ErrorMessage`에 지정된 static 문자열을 사용합니다.

### InputValidator

- 파싱된 입력을 검증하는 검증 클래스입니다.
- 검증 오류가 발생할 시 `IllegalArgumentException`이 발생합니다.
- 오류 메시지는 ErrorMessage에 지정된 static 문자열을 사용합니다.

### InputHandler

1. `InputView`로 입력을 받아 `InputParser`로 파싱한 후 `InputValidator`로 입력을 검증합니다.
2. 제네릭 함수를 통해 잘못된 입력을 받을 시 오류 메시지를 출력하고 다시 입력받습니다.

## 모델

모델은 로또의 생성 및 당첨 확인을 담당합니다. 로또의 생성은 중복되지 않는 번호를 반환하는 `Randoms.pickUniqueNumbersInRange`를 사용합니다.

### Lotto

- 로또 번호가 저장되는 클래스입니다.
- 프로그래머의 실수를 방지하기 위해 생성자 호출 시 검증을 수행합니다.
- 생성자 호출 시에 올바른 숫자 범위의 로또 번호가 6개가 존재하고 중복되지 않는지 검증합니다.
- 만약 중복될 경우 `IllegalArgumentException`을 발생시킵니다.

### PurchaseMoney

- 로또 구입 금액을 저장하는 클래스입니다.

### WinningNumber

- 로또 당첨 번호를 저장하는 클래스입니다.

### BonusNumber

- 보너스 당첨 번호를 저장하는 클래스입니다.

### LottoRank

- 로또의 당첨 조건, 당점 금액이 정의된 Enum 클래스입니다.

### LottoResult

- 이번 회차 로또의 총 결과를 저장하는 클래스입니다.

### LottoService

이 클래스는 로또 생성과 검증을 담당하는 클래스입니다.
이 클래스는 `LottoGenerator`와 `LottoChecker` 두 개의 클래스를 호출해 반환합니다.

- 로또 생성은 `LottoGenerator` 클래스를 사용하여 수행됩니다.
- 로또 검사는 `LottoChecker` 클래스를 사용하여 수행됩니다.

### LottoGenerator

이 클래스는 전달받은 돈에 따라 로또를 발급해주는 함수입니다.

### LottoChecker

이 클래스는 로또 리스트와 당첨 번호 및 보너스 번호를 전달받아 로또 당첨 결과를 `LottoResult`를 통해 반환해 줍니다.

## 뷰

### InputView

- 사용자의 입력을 받아 전달해주는 클래스입니다.

### OutputView

- 컨트롤러로부터 전달받은 로또 번호 및 로또 결과를 **sysout**으로 출력하는 클래스입니다.

## Configuration

### ErrorMessage

- 오류 메세지를 저장하는 클래스입니다.

### LottoConstants

- 로또 번호 갯수, 가격 등의 설정 정보를 저장하는 클래스입니다.