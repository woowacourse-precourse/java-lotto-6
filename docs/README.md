constants
* ConstantValues
  - START_LOTTO_NUMBER = 1
  - END_LOTTO_NUMBER = 45
  - LOTTO_LENGTH = 6
  - LOTTO_COST = 1000
  - FIVE_PRIZE = 5000
  - FOUR_PRIZE = 50000
  - THREE_PRIZE = 1500000
  - TWO_PRIZE = 30000000
  - ONE_PRIZE = 2000000000
* InputMessages
  - START_BUY_MESSAGE = "구입금액을 입력해 주세요."
  - GET_WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
  - GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
* ResponseMessages
  - END_BUY_MESSAGE = "개를 구매했습니다."
  - WIN_STATS_MESSAGE = "당첨 통계"
  - LINE_MESSAGE = "---"
  - WIN_MESSAGE_5 = "3개 일치 (5,000원) - "
  - WIN_MESSAGE_4 = "4개 일치 (50,000원) - "
  - WIN_MESSAGE_3 = "5개 일치 (1,500,000원) - "
  - WIN_MESSAGE_2 = "5개 일치, 보너스 볼 일치" (30,000,000원) - "
  - WIN_MESSAGE_1 = "6개 일치 (2,000,000,000원) - "
  - PROFIT_MESSAGE = "총 수익률은 "
* ErrorMessages
  - ERROR_HEADER = "[ERROR] "
  - BUY_EMPTY_ERROR = "구입 금액을 입력해야 합니다.
  - BUY_CHAR_ERROR = "구입 금액은 쉼표(,) 없이 숫자로 입력해야 합니다."
  - BUY_MINUS_ERROR = "구입 금액은 음수가 될 수 없습니다."
  - BUY_CONDITION_ERROR = "구입 금액은 1,000원 단위로 입력해야 합니다."
  - LOTTO_EMPTY_ERROR = "당첨 번호를 입력해야 합니다."
  - LOTTO_CHAR_ERROR = "당첨 번호는 쉼표(,)를 기준으로 숫자로 입력해야 합니다."
  - LOTTO_RANGE_ERROR = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
  - LOTTO_LENGTH_ERROR = "당첨 번호는 6개를 입력해야 합니다."
  - BONUS_EMPTY_ERROR = "보너스 번호를 입력해야 합니다."


UIView
* InputView - 유저로부터 데이터를 입력받는다.
  - 구입금액 입력받기
  - 당첨 번호 입력받기
  - 보너스 번호 입력 받기

* OutputView - 데이터를 출력한다.
  - 구매한 로또 번호 출력하기
  - 당첨 통계 출력하기
  - 총 수익률 출력하기

Lotto
* Lotto
  - 로또 객체 생성
  - 로또의 길이가 6인지 유효성 검사를 진행한다.
* CreateLottoList
  - 입력 받은 구입금액을 1000으로 나누어 구매할 로또 갯수를 구한다.
  - 구매할 로또 갯수에 맞게 로또를 생성한다.
* CreateLotto
  - random값을 가져와서 한 줄의 로또 번호를 생성한다.
* CheckLotto
  - 입력받은 당첨 번호와 보너스 번호를 받아온다.
  - 각 로또마다 몇 개 일치하는지 체크한 뒤, 그 데이터를 반환한다.
* CalculatePrize
  - 일치한 숫자의 갯수를 확인하고, 일치 정보를 반환한다.
  - 일치 정보를 확인하고, 상금을 계산한다.
  - 총 상금을 합산하고 구입금액과 비교하여 총 수익률을 계산한다.

Validate
* InputValidate
  - 입력받은 구입 금액의 유효성 검사를 진행한다.
* LottoValidate
  - 입력받은 당첨 번호의 유효성 검사를 진행한다.
* BonusValidate
  - 입력받은 보너스 번호의 유효성 검사를 진행한다.
