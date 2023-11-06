# 구현 기능 목록
## LottoController#run
- 사용자로부터 로또 구입 금액을 입력받는다.
- 입력받은 금액을 토대로 로또를 발급하고 출력한다.
- 사용자로부터 당첨 번호, 보너스 번호를 입력받는다.
- 입력받은 당첨 번호, 보너스 번호를 토대로 당첨 통계를 출력한다.
- 당첨 통계를 토대로 수익률을 출력한다.

## AmountMoney#AmountMoney
- 금액의 유효성을 평가한다.

## Lotto#Lotto
- 로또 번호를 생성한다.
- 로또 번호를 오름차순으로 정렬한다.
- 로또 번호의 유효성을 평가한다.

## WinningLotto#WinningLotto
- 당첨 번호, 보너스 번호 객체를 생성하고, 유효성을 평가한다.

## BonusNumber#BonusNumber
- 보너스 번호 객체를 생성하고, 유효성을 평가한다.

## LottoService#makeLottoList
- 로또 개수만큼 로또를 생성한다.

## LottoService#updateWinningStatistics
- 당첨 번호, 보너스 번호를 토대로 당첨 통계를 업데이트한다.

## LottoService#makeProfitRate
- 당첨 통계를 토대로 수익률을 계산한다.

## Calculator#getLottoCount
- 금액을 토대로 로또 개수를 계산한다.

## Calculator#getProfitRate
- 당첨 통계를 토대로 수익률을 계산한다.

## Calculator#evaluateTotalPrice
- 당첨 통계를 토대로 총 수익금을 계산한다.

## Validator#validateInputValue
- 입력받은 값의 유효성을 평가한다.
- 입력받은 값이 숫자인지, 0보다 큰지, 1000보다 작은지를 평가한다.
