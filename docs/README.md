
*Domain

  Lotto
    당첨 번호 6개 입력 + 보너스 번호 입력 후 저장
  User
    로또 구매 및 저장, 구매 금액과 총 상금 관리
  UserLotto
    유저가 구입한 로또 번호가 담긴 클래스

*Enum

  WinningLotto
    로또 등수

*Util

  GenerateLottoNumbers
    유저가 로또 구매시 번호 추출 및 정렬을 해준다.
  
  LottoUtil
    6개의 입력된 로또번호를 ','를 기준으로 나눠고 List로 번호 반환.
    보너스 번호를 int형으로 반환.

  InputUtil
    String 타입으로 들어온 숫자를 int 타입으로 파싱

*Exception

  UserBuyingException
    로또 구입 금액 입력 예외 처리 진행

  LottoException
    로또 번호 6개 입력을 했는지
    1~45의 숫자의 값인지 확인
    6개의 번호가 중복인지 확인
    보너스 번호 1개만 입력했는지 확인
    보너스 번호 입력시 중복이 아닌지 확인

*Service

  UserInputDataService
   View를 통해 유저가 로또를 사는 것을 진행하고, 유저의 정보를 반환한다.

  LottoInputDataService
   View를 통해 당첨 로또의 번호와 보너스 번호를 입력 받고, 로또의 정보를 반환한다.

  LottoCalculateService
   로또 당첨 확인 및 수익률을 계산한다.
   계산한 값을 출력한다. (로또 당첨 및 계산)

*Controller

  LottoController
   Service를 통해 로또의 구입 및 입력, 출력을 명령

*View

  InputView
   유저의 구입 금액을 입력 받는다.
   로또 당첨 번호를 입력 받는다. (+ 보너스 번호)

  OutputView
   로또 구매 시, 랜덤으로 생성된 번호를 출력해준다.
   당첨 통계를 출력해준다.