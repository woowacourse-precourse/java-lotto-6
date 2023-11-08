## Controller
- LottoGame : 로또 게임 Controller

## Model
- Lotto : 6자리 수를 담는 로또 1장의 model
- WinningDetails :
  - 당첨내역 List 변수
  - 수익률 계산하는 함수

## View
- InputView :
  - 로또 구입 금액
  - 당첨번호 입력받기
  - 보너스 번호 입력 받기
- OutputView 
  - 발행 로또 및 번호 출력
  - 당첨 내역 출력


## util
- Verify
  - verifyDuplicate : 입력받은 당첨번호 중복 확인하는 함수
  - verifyNumber : 입력받은 당첨번호 숫자인지 확인하는 함수
- Generator : 
  - GenerateNumbers : 랜덤으로 로또 발행하는 함수

