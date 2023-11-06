# 로또 서비스

이 프로그램은 사용자로부터 로또 구매 금액을 입력받은 뒤 랜덤 숫자로 된 로또를 발급해줍니다.
이후 사용자로부터 당첨 번호와 보너스 번호를 입력받아 사용자에게 당첨 통계를 출력해줍니다.

## 컨트롤러

- View와 Model을 이용해 프로그램의 실행 흐름을 제어합니다.

### LottoController

1. 사용자로부터 로또 구입 금액, 당첨 번호, 보너스 번호를 입력 받습니다.
2. InputView로 입력을 받아 InputParser로 파싱한 뒤 InputValidator로 입력을 검증합니다.
3. 잘못된 입력을 받을 시 오류 메시지를 출력하고 다시 입력을 받습니다.
4. 사용자 입력을 토대로 로또를 생성하고 결과를 출력합니다.

### InputParser

- 사용자의 입력을 파싱하는 클래스입니다.
- 숫자로 변환하는 과정에서 오류가 발생할 시 **IllegalArgumentException**이 발생합니다.
    - 오류 메시지는 **ErrorMessage**에 지정된 static 문자열 사용합니다.

### InputValidator

- 파싱된 입력을 검증하는 검증 클래스입니다.
- 검증 오류가 발생할 시 **IllegalArgumentException**이 발생합니다.
    - 오류 메시지는 ErrorMessage에 지정된 static 문자열 사용

#### 검증 목록

오류 메시지는 **ErrorMessage**에 지정된 static 문자열 사용합니다.

1. 구매금액 검증(`validateMoney` 메소드)

- 로또 가격보다 입력한 돈이 적은지 확인합니다. 만약 그렇다면 `IllegalArgumentException`을 발생시킵니다.
- 입력한 돈이 로또 가격으로 나누어 떨어지는지 확인합니다. 만약 나누어 떨어지지 않는다면 `IllegalArgumentException`을 발생시킵니다.

2. 당첨 번호 검증(`validateWinningNumbers` 메소드)

- 당첨 번호의 길이가 올바른지 확인합니다. 만약 길이가 올바르지 않다면 `IllegalArgumentException`을 발생시킵니다.
- 당첨 번호가 중복되는지 확인합니다. 만약 중복된다면 `IllegalArgumentException`을 발생시킵니다.
- 각 당첨 번호가 범위 내에 있는지 확인합니다. 만약 범위를 벗어난다면 `IllegalArgumentException`을 발생시킵니다.

3. 보너스 번호 검증(`validateBonusNumber` 메소드)

- 보너스 번호가 범위 내에 있는지 확인합니다. 만약 범위를 벗어난다면 `IllegalArgumentException`을 발생시킵니다.

## 모델

- 로또의 생성 및 당첨 확인을 담당합니다.
- 로또의 생성은 중복되지 않는 번호를 반환하는 **Randoms.pickUniqueNumbersInRange**를 사용합니다.

### Lotto

- 로또 번호가 저장되는 클래스
- 생성자 호출 시에 로또 번호가 6개 존재하고 중복되지 않는지 검증합니다.

### WinningNumber

- 로또 당첨 번호와 보너스 번호가 저장된 클래스입니다.

### LottoRank

- 로또의 당첨 조건, 당점 금액이 정의된 Enum 클래스입니다.

### LottoResult

- 이번 회차 로또의 총 결과를 저장하는 클래스입니다.

## 뷰

### InputView

- 사용자의 입력을 받아 전달해주는 클래스입니다.

### OutputView

- 컨트롤러로부터 전달받은 로또 번호 및 로또 결과를 **sysout**으로 출력하는 클래스입니다.
