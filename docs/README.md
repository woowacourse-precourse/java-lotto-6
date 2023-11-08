## Controller
### LottoGame : 로또 게임 Controller
  - run : 로또 게임 실행
  - makeLottoResult : 로또 결과를 계산하는 함수
  - notify- : 공통 출력문

## Model
### Lotto : 6자리 수를 담는 로또 하나의 model
  - printLotto : List 형태의 String을 출력하는 함수
  - getNumbers : List return 하는 함수
  - getMatchLottoNumbers : 당첨로또번호와 일치하는 수를 계산하는 함수
  - getMatchNumber : 특정 번호가 해당 로또번호들 중 속해있는지 확인하는 함수 (true/false)
  - private/validate : 6자릿수가 맞는지 확인하는 함수. 6자리가 아니면 IllegalArgumentException를 반환한다.  
### WinningDetails :
  - calculatePrize : 전체금액을 계산하는 함수
  - getResult : 당첨내역 String 으로 전체 작성해주는 함수
### Prize : 당첨금액 enum list
  - getPrize : 해당 enum에 맞는 값을 return 해주는 함수

## View
### InputView :
  - getHowMuchLottoWillYouBuy: 로또 구입 금액
  - getWinningLottoNumbers : 당첨번호 입력받기
  - getBonusNumber: 보너스 번호 입력 받기
### OutputView 
  - printLottoList: 발행 로또 및 번호 출력
  - printLottoResult: 당첨 내역 출력


## util
### Verify
  - verifyWinningNumbersStringToList : 입력받은 당첨번호 공백처리, Integer인지 판별을 확인하는 함수.
  - verifyBonusNumber : 입력받은 보너스 숫자가 Integer인지 확인하는 함수.
  - verifyAmount : 입력받은 로또 구입 금액이 1000원 이상인지 확인하는 함수.
  - private/verifyInteger : String에서 Integer로 변환 시 발생하는 예외를 따로 처리해주는 함수.
  - private/verifyNumberRange : 1부터 45 사이의 숫자가 아닐 경우에 따로 처리해주는 함수.
### Generator :
  - generateLotto : 희망 횟수에 따른 랜덤 로또 발행하는 함수
  - generateNumbers : 랜덤으로 로또 발행하는 함수
### StringTo:
  - StringToLottoNumber : 쉼표로 입력받은 당첨번호 list<Integer>로 변환하기
