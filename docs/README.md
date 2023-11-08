단계 1: Model 클래스 생성

Lotto 클래스 작성

Lotto 클래스를 작성하여 로또 번호의 전체 상태를 관리합니다.
로또 번호 유효성을 검증합니다.
로또 번호는 1부터 45까지의 숫자여야 하고, 중복되지 않아야 합니다.
WinningNumber 클래스 작성

WinningNumber 클래스를 작성하여 당첨 번호와 보너스 번호의 전체 상태를 관리합니다.
당첨 번호 및 보너스 번호 유효성을 검증합니다.
당첨 번호는 1부터 45까지의 숫자여야 하고, 중복되지 않아야 합니다.
Rank 클래스 작성

Rank 클래스를 작성하여 로또 순위를 정의하고, 상세 내용과 상금을 관리합니다.
MatchingCalculator 클래스 작성

MatchingCalculator 클래스를 작성하여 로또 번호 일치 여부를 계산하고 해당 순위를 반환합니다.
ProfitCalculator 클래스 작성

ProfitCalculator 클래스를 작성하여 당첨 번호에 따른 총 상금을 계산합니다.
LottoGenerator 클래스 작성

LottoGenerator 클래스를 작성하여 로또 구매 금액에 맞는 Lotto를 생성합니다.
RandomListGenerator 클래스 작성

RandomListGenerator 클래스를 작성하여 무작위 로또 번호 리스트를 생성합니다.
생성된 번호 리스트는 1부터 45까지 중복되지 않는 6개의 숫자로 구성됩니다.
단계 2: View 클래스 생성

InputView 클래스 작성

InputView 클래스를 작성하여 사용자로부터 로또 구입 금액을 입력받습니다.
사용자로부터 당첨 번호와 보너스 번호를 입력받습니다.
OutputView 클래스 작성

OutputView 클래스를 작성하여 게임 시작 메시지를 출력합니다.
구매한 로또 티켓 수와 번호를 출력합니다.
당첨 결과와 총 수익률을 출력합니다.
에러 메시지를 출력합니다.
단계 3: Controller 클래스 생성

Controller 클래스 작성
Controller 클래스를 작성하여 게임을 시작하고 종료합니다.
로또를 초기화하고 발행합니다.
당첨 번호와 보너스 번호를 입력받아 게임을 진행합니다.
당첨 결과와 수익률을 계산하여 출력합니다.
잘못된 입력값에 대한 예외 처리를 수행합니다.
부적절한 메서드 호출에 대한 예외 처리를 수행합니다.
단계 4: Validator 클래스 생성

BonusNumberValidator 클래스 작성

BonusNumberValidator 클래스를 작성하여 보너스 번호의 유효성을 검증합니다.
PurchaseValidator 클래스 작성

PurchaseValidator 클래스를 작성하여 로또 구입 금액의 유효성을 검증합니다.
WinningNumberValidator 클래스 작성

WinningNumberValidator 클래스를 작성하여 당첨 번호의 유효성을 검증합니다.
단계 5: Exception 클래스 생성

Exception 클래스 작성
프로젝트에서 발생하는 예외를 처리하기 위한 Exception 클래스를 작성합니다.
각 유효성 검사에 대한 예외 상황을 정의합니다.
단계 6: 단위 테스트 작성

각 클래스 및 기능에 대한 단위 테스트 코드를 작성합니다. JUnit 5 및 AssertJ를 사용하여 테스트합니다.
각 클래스의 메서드 및 기능이 예상대로 작동하는지 확인합니다.