# 로또

## 기능 목록
- [x] 로또 구입 금액을 입력 받는 기능 - InputView#inputPurchaseAmount()
  - [x] 1,000원으로 나누어 떨어지지 않는 경우 예외 처리 - LottoGameService#validatePurchaseAmount()
- [x] 당첨 번호를 입력 받는 기능 - InputView#inputWinningNumbers()
  - [x] 쉼표를 기준을 구분 - LottoGameService#convertWinningNumbersToCollection()
- [x] 보너스 번호를 입력 받는 기능 - InputView#inputBonusNumber()
- [x] 발행한 로또 수량 및 번호를 출력하는 기능 - OutputView#printPurchasedLottoNumbers()
  - [x] 로또 번호 생성 - LottoGameService#generateLottoNumbers()
  - [x] 1~45의 중복되지 않는 수 6개를 사용 - LottoNumbersGenerator#generateLottoNumbers() 
  - [x] 로또 번호는 오름차순으로 정렬 - Lotto#sortAscending()
- [x] 당첨 내역을 출력하는 기능 - OutputView#printWinningStatistics()
  - [x] 생성한 로또 번호와 당첨 번호를 비교 - LottoGameService#determineWinningRank()
  - [x] 당첨 횟수를 누적하여 갱신 - LottoGameService#updateWinningCount()
- [x] 수익률을 소수점 둘째 자리에서 반올림하여 출력 - OutputView#printProfitRatio()
  - [x] 수익률을 계산 - LottoGameService#calculateProfitRate()
- [x] 예외 상황시 에러 문구 출력 - LottoGameController#playGame()

## 기능 요구 사항
로또 게임 기능을 구현한다.  
로또 1장의 가격은 1,000원이며 구입 금액만큼 자동으로 로또를 발행한다.  
로또 번호의 숫자 범위는 1~45이며 중복되지 않는다.  
당청 번호와 보너스 번호를 입력받아  
사용자가 구매한 로또 번호와 비교하여  
당첨 내역과 수익률을 출력하고 로또 게임을 종료한다.

당첨은 1등부터 5등까지 있으며, 기준은 아래와 같다.
- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원

그리고 수익률은 소수점 둘째 자리에서 반올림한다.