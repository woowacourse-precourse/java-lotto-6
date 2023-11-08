# ⚙️ 기능 목록


Application

📌 로또 프로그램 시작

## controller

### lotto

LottoController

📌 로또 프로그램의 전체 흐름 관리

LottoBonusNumberComparator

📌 로또 보너스 번호 숫자 비교기

LottoBonusNumberScanController

📌 보너스 번호 입력 흐름 관리

LottoNumberScanController

📌 당첨 번호 입력 흐름 관리

LottoPurchaseMoneyPrintController

📌 로또 구입 금액 출력 흐름 관리

LottoPurchaseMoneyScanController

📌 로또 구입 금액 입력 흐름 관리

LottoSameNumberCounter

📌 당첨 번호와 로또 티켓의 숫자들 같은 숫자 개수 확인

LottoTicketGenerator

📌 로또 티켓 생성기

LottoTicketListGenerateController

📌 로또 티켓 리스트 생성 흐름 관리

LottoTicketListPrintController

📌 로또 티켓 리스트 출력 흐름 관리

LottoWinningCaseChecker

📌 당첨되었는지 확인

LottoWinningCaseCounter

📌 당첨 경우들의 개수 확인

LottoWinningProfitCalculator

📌 당첨 수익 계산

LottoWinningStatusCheckingController

📌 당첨 현황 확인 흐름 관리

LottoWinningStatusPrinterController

📌 당첨 현황 출력 흐름 관리





### validation

#### bonus

LottoBonusNumberDuplicationChecker

📌 보너스 번호 당첨 번호와 중복성 검사

LottoBonusNumberRangeChecker

📌 보너스 번호 범위 확인

LottoBonusNumberValueValidator

📌 보너스 번호 값 유효성 확인

LottoBonusNumberWithCharChecker

📌 보너스 번호 문자 있는지 체크


#### lotto

LottoNumberCountChecker

📌 당첨 번호 개수 확인

LottoNumberDuplicationChecker

📌 당첨 번호 중복 검사

LottoNumberRangeChecker

📌 당첨 번호 범위 확인

LottoNumberStringEndChecker

📌 당첨 번호로 받은 문자열 끝에 구분자 없는지 확인

LottoNumberValueValidator

📌 당첨 번호 유효성 확인

LottoNumberWithCharChecker

📌 당첨 번호에 문자 포함 여부 체크



#### money

LottoPurchaseMoneyValidator

📌 입력된 구입 금액에 대한 유효성 검사 


#### input

InputController

📌 입력 관리

---

## model

### constant

CharSymbolicConstantEnum

📌 프로그램에서 필요한 문자 관리

IntegerSymbolicConstantEum

📌 프로그램에서 필요한 정수 관리

LottoWinningCase

📌 당첨 경우의 수 상수로 관리

StringSymbolicConstantEnum

📌 프로그램에서 필요한 문자열 관리

WinningCaseCountConstantEnum

📌 당첨 경우를 세는데 필요한 상수 관리



### lotto

Lotto

📌 당첨 번호 저장, 반환

LottoBonus

📌 보너스 번호 저장, 반환

LottoPurchaseMoney

📌 구입 금액 저장, 반환

LottoTicket

📌 로또 티켓에 대한 속성 저장 반환

LottoTicketList

📌 로또 티켓 리스트 저장, 반환

LottoWinningStatus

📌 당첨 현황 저장, 반환



---

## view

ErrorOutputView

📌 에러 문구 출력 관리

MessageOutputView

📌 안내 문구 출력 관리

ProcessedValueOutputView

📌 입력된 값에 따른 출력 관리



