## 기능 요구 사항

### 로또 게임 규칙

```
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

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
    - 1000으로 나누어 떨어지지않는 수를 입력 받으면 에러를 발생시킨다.
    - 문자열을 입력 받는다면 에러를 발생시킨다.
- 당첨 번호와 보너스 번호를 입력받는다.
    - 당첨 번호
        - 숫자가 6개 미만일 떄 에러를 발생시킨다.
        - 입력값에 문자열이 포함되어 있다면 에러를 발생시킨다.
        - 1 ~ 45의 범위 외 다른 번호 입력 시 에러를 발생시킨다.
    - 보너스 번호
        - 입력값이 당첨 번호에 포함되어 있다면 에러를 발생시킨다.
        - 입력값에 문자열이 포함되어 있다면 에러를 발생시킨다.
        - 1 ~ 45의 범위 외 다른 번호 입력 시 에러를 발생시킨다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 ```IllegalArgumentException```를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 ```IllegalArgumentException```, ```IllegalStateException``` 등과 같은 명확한 유형을 처리한다.

## 기능 명세서

### View

- InputView
    - 입력을 받는 화면
- OutputView
    - 출력하는 화면

### RequestDto

- MoneyRequestDto
    - 사용자에게 요청한 금액을 저장
    - 입력한 값이 숫자인지 확인

- WinningNumbersRequestDto
    - 사용자에게 요청한 우승 복권 값을 저장
    - 입력한 값 안에 문자열 유무 확인

- BonusNumberRequestDto
    - 사용자에게 요청한 보너스 번호을 저장
    - 입력한 값이 숫자인지 확인

- 올바른 값이 아니라면 ```IllegalArgumentException``` 을 발생

### Model

- Money
    - 유효성 검사 통과 시 금액을 저장
        - 1000으로 나누어 떨어지지 않으면 ```IllegalArgumentException``` 발생
        - 금액에 따라 구매한 로또 수 리턴

- Lotto
    - 유효성 검사 통과 시 로또 번호를 저장
        - 입력 받은 값이 6자리 미만이면 ```IllegalArgumentException``` 발생
        - 중복된 숫자가 있다면 ```IllegalArgumentException``` 발생

- LottoMachine
    - Money를 받으면 티켓 개수를 받아 개수만큼 랜덤 로또 생성

- WinningLotto
    - 사용자의 winningLotto와 bonusNumber를 받아 생성
        - bonusNumber 값이 1 ~ 45 범위 밖이면 ```IllegalArgumentException``` 발생
        - bonusNumber 값이 winningLotto에 포함되어 있다면 ```IllegalArgumentException``` 발생

- Rank
    - 랭크 종류에 따라 숫자 매칭 수, 금액, 메세지 생성
    - RandomLottos와 WinningLottos를 비교해 Rank 판독

### Constants

- LottoInformation
    - 로또 세부 정보를 저장

### Repository

- Result
    - 입력받은 값들을 Rank로 계산된 결과를 저장

### Controller

- 어플리케이션 작동을 제어
- View와 domain을 연결

### Service

- LottoService
    - 핵심 기능을 담당
        - 결과를 출력
        - 결과와 사용한 입력한 돈을 통해 수익률을 계산해 반환

### Config

- ApplicationConfig
    - 결합도를 낮추기 위해 외부에서 객체를 생성해 주입 (의존성 주입)