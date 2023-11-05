
<br>

---

## ✨&nbsp;&nbsp;구현 목록

### 1️⃣ ⃣ Functional Requirement (Controller Code Flow)


+ [X] [Controller] 사용자에게 로또 구입 금액을 입력 받는다

  * [OutputView] "구입금액을 입력해 주세요." 메시지 출력
  * [InputView] 사용자에게 문자열을 입력받는다.
  * [Money] 사용자 입력값 저장한다.
  * [OutputView] 만약 예외 처리시 예외 사항 "[ERROR] ~" 메시지 출력한다.
  * [Validator] 유효성 검사 : 숫자가 아니거나 1000원 단위로 나누어 떨어지지 않으면 예외 처리 후 다시 입력 받는다.

+ [X] [Controller] 사용자에게 발행한 로또 번호 개수와 로또 번호를 출력한다.

  * [OutputView] "%d개를 구매했습니다." 발행된 로또 번호 개수를 출력한다.
  * [RandomLottoNumbers] 로또 번호 개수 당 범위(1~45) 안에서 중복 되지 않은 6개 수 생성해 List<Lotto>로 저장 한다.
  * [OutputView] 각 번호마다 "[%d, %d, %d, %d, %d, %d]" 형태로 출력 한다.

+ [X] [Controller] 사용자에게 당첨 번호를 `,(Comma)`를 기준으로 입력 받는다.

  * [OutputView] "당첨 번호를 입력해 주세요." 메시지 출력
  * [InputView] 사용자에게 문자열을 입력받는다.
  * [Validator] 유효성 검사 : Comma로 끝나거나, whiteSpace를 포함하는 요청 예외 처리 후 다시 입력 받는다.
  * [Parser] 플레이어에게 입력받은 String을 Comma를 기준으로 파싱해 List<String> 형태로 변환 한다.
  * [Validator] 유효성 검사 : 숫자가 아닐 경우 예외 처리 후 다시 입력 받는다.
  * [Parser] 플레이어에게 입력받은 String을 Comma를 기준으로 파싱해 List<Integer> 형태로 변환 한다.
  * [Validator] 유효성 검사 : 범위(1~45)를 벗어나거나 번호 개수가 6개가 아니거나 중복 값이 포함된 경우 요청 예외 처리 후 다시 입력 받는다.
  * [OutputView] 만약 예외 처리시 예외 사항 "[ERROR] ~" 메시지 출력한다.
  * [Lotto] 컨트롤러에서 뷰를 통해 입력받은 로또 번호를 통해 로또 객체를 생성한다.

+ [X] [Controller] 사용자에게 보너스 번호를 입력 받는다

  * [OutputView] "보너스 번호를 입력해 주세요." 메시지 출력
  * [InputView] 사용자에게 문자열을 입력받는다.
  * [Validator] 유효성 검사 : 숫자가 범위(1~45)를 벗어나거나 기존 로또 번호와 중복 되면 예외 처리 후 다시 입력 받는다.
  * [OutputView] 만약 예외 처리시 예외 사항 "[ERROR] ~" 메시지 출력한다.

+ [X] [Controller] 당첨 내역을 사용자에게 출력한다.

    * [LottoResult] 컨트롤러에게 사용자 입력 번호와 로또 번호 리스트를 입력 받아 결과를 계산한다. 
    * [OutputView] 컨트롤러에게 [LottoResult]의 결과를 받아 출력한다.

+ [X] [Controller] 수익률을 출력한다.

    * [Money] 컨트롤러에게 결과를 받아 수익률 계산 후 반환한다.
    * [OutputView] 컨트롤러에게 [Money]의 결과를(LottoReturnCalculation.toString()) 받아 출력한다.

<br>