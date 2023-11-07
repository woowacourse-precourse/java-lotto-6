## 로또 게임

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

## 기능 목록

- [X] 로또 구입 금액 입력: InputView.*getPurchaseAmount*
- [X] 구입 금액이 1000으로 나누어 떨어지는지 확인: PurchaseAmount.*validate*
- [X] 로또 번호 발행: LottoController.*publishMyLotto*
- [X] 발행한 로또 수량 및 번호 출력: OutputView.*printMyLotto*
- [X] 당첨 번호 입력: InputView.*getLotto*
- [X] 당첨 번호 문자열 콤마를 기준으로 분리: InputView.*changeStringToLotto*
- [X] 당첨 번호가 6개인지 확인: Lotto.*validate6numbers*
- [X] 당첨 번호가 1~45 사이의 숫자인지 확인: Lotto.*validate1to45*
- [X] 당첨 번호에 중복 숫자가 있는지 확인: Lotto.*validateNotEqual*
- [X] 보너스 번호 입력: InputView.*getBonusNumber*
- [X] 보너스 번호가 1~45 사이의 숫자인지 확인: BonusNumber.*validate1to45*
- [X] 보너스 번호가 당첨 번호에 이미 있는지 확인: Bonus.*validateAlreadyExist*
- [X] 발행 로또 번호와 당첨 번호 사이에 일치하는 번호 개수 계산: LottoController.*calculateMatchingNumbers*
- [X] 상금 계산: LottoController.*calculatePrize*
- [X] 수익률 계산: LottoController.*calculateRateOfReturn*
- [X] 당첨 내역 출력: OutputView.*printWinningDetails*
- [X] 수익률 출력: OutputView.*printRateOfReturn*

## LottoController

내 로또 구매: buyMyLotto
* assignPurchaseAmount
* publishMyLotto
* printMyLotto

당첨 번호 설정: assignLotto
* assignLottoNumbers
* assignBonusNumber

게임 결과 출력: showGameResult
* calculateMatchingNumbers
* calculateRateOfReturn
* printWinningDetails
* printRateOfReturn