## Controller
- LottoGame : 로또 게임 Controller

## Model
- Lotto : 6자리 수를 담는 로또 1장의 model
- WinningDetails :
  - 당첨내역 List 변수
  - 수익률 계산하는 함수
- Prize : 당첨금액 enum list

## View
- InputView :
  - getHowMuchLottoWillYouBuy: 로또 구입 금액
  - getWinningLottoNumbers : 당첨번호 입력받기
  - getBonusNumber: 보너스 번호 입력 받기
- OutputView 
  - printLottoList: 발행 로또 및 번호 출력
  - 당첨 내역 출력


## util
- Verify
  - verifyWinningNumbersStringToList : 입력받은 당첨번호 공백처리, Integer인지 판별을 확인하는 함수.
  - verifyBonusNumber : 입력받은 보너스 숫자가 Integer인지 확인하는 함수.
  - verifyAmount : 입력받은 로또 구입 금액이 1000원 이상인지 확인하는 함수.
- Generator : 
  - GenerateNumbers : 랜덤으로 로또 발행하는 함수
- StringTo:
  - StringToLottoNumber : 쉼표로 입력받은 당첨번호 list<Integer>로 변환하기
