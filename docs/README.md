# 구현 기능 목록
## Controller
### LottoController#run
- 사용자로부터 로또 구입 금액을 입력받는다.
- 입력받은 금액을 토대로 로또를 발급하고 출력한다.
- 사용자로부터 당첨 번호, 보너스 번호를 입력받는다.
- 입력받은 당첨 번호, 보너스 번호를 토대로 당첨 통계를 출력한다.
- 당첨 통계를 토대로 수익률을 출력한다.
- 위의 과정을 model과 service를 통해 수행하고, view를 통해 입출력한다.

## Model
### AmountMoney#AmountMoney
- 사용자가 입력한 금액에 대한 객체를 생성한다.
- 금액의 유효성을 평가한다.
- 금액이 1000원 단위인지, 1000원보다 큰지를 평가한다. 

### Lotto#Lotto
- 로또 번호들을 담은 객체를 생성한다.
- 로또 번호의 유효성을 평가한다.
- 로또 번호가 1~45 사이의 숫자인지, 중복되지 않는지를 평가한다.
- 로또 번호가 6개인지를 평가한다.

### BonusNumber#BonusNumber
- 보너스 번호 객체를 생성하고, 유효성을 평가한다.
- 보너스 번호가 1~45 사이의 숫자인지 평가한다.

### WinningLotto#WinningLotto
- Lotto 클래스를 상속하고, BonusNumber 객체를 포함한다.
- 전달받은 보너스 번호에 대한 유효성을 평가한다.
- 보너스 번호가 Lotto 객체에 포함되어 있는지 평가한다.

### ResultTable#ResultTable
- 보너스 번호와 맞춘 개수를 토대로 당첨 통계를 생성한다.
- 생성 시에 전달받은 StatisticsEnum을 이용하여, 맞춘 개수와 보너스 번호에 따른 당첨 금액을 정의한다.
- 당첨 통계를 업데이트한다.

## Service
### LottoService#makeLottoList
- 로또 개수만큼 로또를 생성한다.

### LottoService#updateWinningStatistics
- 당첨 번호, 보너스 번호를 토대로 당첨 통계를 업데이트한다.

### LottoService#makeProfitRate
- 당첨 통계를 토대로 수익률을 계산한다.

## utils
### Calculator#getLottoCount
- 금액을 토대로 로또 개수를 계산한다.

### Calculator#getProfitRate
- 당첨 통계를 토대로 수익률을 계산한다.

### Calculator#evaluateTotalPrice
- 당첨 통계를 토대로 총 수익금을 계산한다.

### Validator#validateInputValue
- 입력받은 값의 유효성을 평가한다.
- 입력받은 값이 숫자인지, 0보다 큰지, 1000보다 작은지를 평가한다.

## View
### InputView#promptPurchaseAmount
- 구입 금액을 입력받는다.
- 입력받은 구입 금액을 반환한다.
- 입력받은 구입 금액이 유효하지 않을 경우, 예외를 발생시킨다.

### InputView#promptMakeLotto
- 당첨 번호를 입력받는다.
- 입력받은 당첨 번호를 바탕으로 로또 객체를 생성한다.
- 객체를 생성하면서 정렬을 진행한다.
- 입력받은 당첨 번호가 유효하지 않을 경우, 예외를 발생시킨다.

### InputView#promptBonusNumber
- 보너스 번호를 입력받는다.
- 입력받은 보너스 번호를 반환한다.
- 입력받은 보너스 번호가 유효하지 않을 경우, 예외를 발생시킨다.

### OutputView#displayLottoPurchase
- 로또 리스트를 전달받는다.
- 로또를 구매한 개수를 출력한다.
- 로또를 구매한 개수만큼 로또를 출력한다.

### OutputView#displayFinalResult
- 최종 결과를 전달받는다.
- 당첨 통계를 출력한다.

### OutputView#displayTotalProfitRate
- 수익률을 전달받는다.
- 수익률을 출력한다.

## Enum 목록
### LottoEnum
- 로또 번호의 범위를 정의한다.
- 로또 번호의 개수를 정의한다.
- 로또 한 장의 가격을 정의한다.

### StatisticsEnum
- 맞춘 숫자의 개수와 당첨 금액을 정의한다.

### DefaultErrorMessage
- 기본 에러 메시지를 정의한다.
- InputMismatchException을 발생시키며, 자세한 에러 메세지를 출력한다.

### AmonuntErrorMessage
- 금액 에러 메시지를 정의한다.
- IllegalArgumentException을 발생시키며, 자세한 에러 메세지를 출력한다.

### NumbersErrorMessage
- 숫자 입력과 관련된 에러 메시지를 정의한다.
- IllegalArgumentException을 발생시키며, 자세한 에러 메세지를 출력한다.