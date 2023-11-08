이 프로젝트는 **우아한 테크코스 3주차 - 로또 게임**을 구현하는 프로젝트입니다.

> 구현 과정
>
1. 사용자로부터 구입 금액을 입력받고 이에 대한 검증을 진행한다.
2. 입력 받은 구입 금액을 통해 전체 로또 구매 개수(티켓)을 계산하고, 해당 개수에 따라 로또 번호를 생성한다.
3. 사용자로부터 당첨 로또 번호와 보너스 번호를 입력 받는다. 이에 대한 검증을 진행한다.
4. 입력 받은 번호들을 생성된 번호들과 비교한다.
   - 일치하는 번호의 개수들을 누적한다.
   - 발행된 로또 번호들과의 비교가 모두 끝나면 누적된 상금을 계산한다.
5. 누적된 상금과 사용자의 구입 금액을 통해 수익률을 계산한다.

---

## 기능 소개

### Domain

- Lotto
  - `validate` : Lotto의 숫자 개수, 중복되는 게 있는지 Lotto 클래스 내에서 검증하는 기능
  - `getNumbers` : Lotto의 숫자를 받는 기능
  - `containsBonusNumber` : Lotto 숫자 안에 보너스 숫자가 포함되어 있는지 확인하는 boolean

- LottoResult
  - `getMatchCount` : 당첨 번호(입력한 숫자)와 일치한 숫자의 개수를 세는 기능
  - `hasBonus` : 당첨 번호가 5개 일치하고 보너스 숫자가 해당되었을 때 확인해주는 boolean
  - `updateMatchNumberCount` : 당첨 번호의 개수와 보너스 번호의 일치 여부 모두 확인하는 기능

- LottoTicket
  - `addLotto` : 하나의 Lotto를 lottoGames라는 ArrayList에 넣어주기
  - `getLottoGames` : 현재 lottoGames 리스트의 복사본을 반환하는 기능
  - `randomLottoNumbers` : 구매한 로또 장 수만큼 `generateRandomLotto`를 통해 랜덤 로또 번호를 받고 리스트로 반환하는 기능
  - `generateRandomLotto` : 하나의 랜덤 로또 번호를 오름차순으로 생성하는 기능

- Prize
  - `Prize(int matches, int prizeAmount, String description)`: Prize 안의 각 인스턴스들은 당첨 로또와 일치하는 숫자 개수(matches), 상금 액수(prizeAmount), 상금에 대한 안내(description)를 가지게 됩니다
  - `getMatches` : 당첨 로또와 일치하는 숫자 개수를 반환하는 기능
  - `getPrizeAmound` : 상금 액수를 반환하는 기능
  - `getDescription` : 상금에 대한 안내를 반환하는 기능
  - `findMatchingPrize` : 당첨 로또와 일치하는 번호의 수와 보너스 번호 일치 여부를 기반으로 이에 맞는 Prize를 결정하는 기능
    - 만약 일치하는 숫자 개수가 3보다 작으면 : 상금 없음
    - 만약 일치하는 숫자 개수가 5이면 : 보너스 숫자 일치 여부에 따라 2등과 3등 결정
  - `findPrizeForRegularMatch` : 특별한 조건 (일치하는 숫자 개수가 3보다 작거나 5인 경우)를 제외하고 일반적인 경우에 대한 상금을 찾는 기능
  - `isMatchCountEqual` : Prize안의 matches가 주어진 matches와 같은지 확인하는 boolean
  - `BonusOrNot` : 보너스 번호 일치 여부에 따라 2등, 3등을 반환하는 기능

---

### Service

- LottoTicketGenerator
  - `generateLottoTickets` : LottoTicket.`randomLottoNumbers()`메서드를 호출해서 지정된 수만큼 랜덤 로또 번호들을 리스트를 받아와 lottoRandomNumbers에 추가하는 기능
  - `printLottoTickets` : 위의 기능에서 저장된 랜덤 로또 리스트를 출력하는 기능

- PrizeStatisticService
  - `initializePrizeStatistics`: Prize에서 객체를 받아와 통계를 돕는 Map을 초기화하는 기능, NONE을 제외한 모든 Prize 항목에 대한 카운트를 0으로 설정
  - `compilePrizeStatistics` : 주어진 당첨 로또와 보너스 번호를 사용해 LottoTicket에 포함된 각 로또의 당첨 결과를 추합하는 기능
  - `processAndReportPrizeResults` : 당첨 통계를 처리하고 보고하는 기능, 아래의 두 기능을 합쳐놓은 기능
  - `calculateWinningPrize` : Prize에서 당첨 번호와 일치하는 개수(count)를 곱해서 총 상금 금액을 반환하는 기능
  - `calculateWinningPrize` : 위에서 계산한 것을 OutputView.*`printTotalStats`*를 통해 사용자에게 보여주는 기능

- UserRequestService
  - `requestLottoCost` : 사용자에게 구매 금액 입력을 요청하고 입력값에 대한 예외처리를 진행하는 기능
  - `requestWinningLotto` : 사용자에게 당첨 로또 번호 입력을 요청하고 입력값에 대한 예외처리를 진행하는 기능
  - `requestBonusNumber` : 사용자에게 보너스 번호 입력을 요청하고 입력값에 대한 예외처리를 진행하는 기능

---

### Util

- Converter
  - `convertToNumberList` : String으로 받은 입력을 List<Integer> 로 변환하는 기능

- Exception
  - `lottoCostException` : 입력된 로또 구매 비용을 검증하고, 유효하지 않다면 예외 메세지를 출력하고 다시 입력을 요청하는 기능
  - `winningLottoException` : 입력된 당첨 로또 입력을 검증하고, 유효하지 않다면 예외 메세지를 출력하고 다시 입력을 요청하는 기능
  - `bonusNumberException` : 입력된 보너스 번호를 검증하고, 유효하지 않다면 예외 메세지를 출력하고 다시 입력을 요청하는 기능

- ProfitRate
  - `calculateProfit` : 수익률을 반환하는 기능
    - 수익률은 (전체 상금 / 구매 비용) * 100 으로 계산합니다
    - String.format을 사용해 소수 둘째자리의 값을 반올림합니다

- Validation
  - `validatePrice` : 구매 비용(int)과 관련한 모든 검증을 추합해놓은 기능
  - `validateNumberFormat` : 입력이 숫자 형식이 맞는지 검증하는 기능
  - `validateEmptySpace` : 입력에 빈칸이 있는지 검증하는 기능
  - `validateDivisiblePrice` : 입력이 1000으로 나누어 떨어지는지를 검증하는 기능

  - `validateLottoNumbers` : 당첨 로또 입력(ArrayList)과 관련한 모든 검증을 추합해놓은 기능
  - `validateNumberLength` : 로또 숫자의 길이가 6인지를 검증하는 기능
  - `validateNumberDuplicated` : 로또 숫자간의 중복이 있는지 확인하는 기능
  - `validateNumberRange` : isInvalid를 통해 로또 번호가 1~45 사이의 숫자가 맞는지 검증하는 기능
  - `isInvalid` : 로또 번호가 1~45 사이의 번호인지를 나타내는 boolean

  - `validateBonusNumber` : 보너스 번호(int)와 관련한 모든 검증을 추합해놓은 기능
  - `validateBonusNumberRange` : 입력이 1~45 사이인지 검증하는 기능
  - `validateNumberNotDuplicated` : 위의 로또 번호와 보너스 번호가 중복하는지 검증하는 기능
  - `validateBonusNumberFormat` : 보너스 번호 입력이 숫자 형식이 맞는지 검증하는 기능

---

### View

- InputView
  - `requestPrice` : 사용자에게 로또 구매 비용을 입력받는 기능
  - `requestWinningNumber` : 사용자에게 당첨 로또 번호를 입력받는 기능
  - `requestWinningBonusNumber` : 사용자에게 보너스 번호를 입력받는 기능

- OutputView (사용자에게 보여줄 안내를 모아둔 클래스)
  - `printRequestLottoPrice` : 사용자에게 로또 구입 금액 입력 요청을 출력하는 기능
  - `printLottoTicketCount` : 사용자가 몇 개의 로또를 구입했는지 안내하는 기능
  - `printRequestWinningNumbers` : 사용자에게 당첨 로또 번호 입력 요청을 출력하는 기능
  - `printRequestBonusNumber` : 사용자에게 보너스 번호 입력 요청을 출력하는 기능
  - `printPrizeStaticIntro` : 상금 통계 안내 전, 고정 메세지 출력하는 기능
  - `printTotalStats` : 사용자에게 상금 통계를 안내하는 기능
  - `printProfitRate` : 사용자에게 수익률을 출력하는 기능

---

### Control

- Control (다른 클래스들의 메서드를 호출해 진행)
  - `playLotto` : LottoGame의 전체적인 흐름을 담당하는 기능
  - `startLotto` : 사용자로부터 구입금액을 받고 예외 처리를 진행, 구입금액을 통해 로또 티켓 개수를 출력하는 흐름
  - `generateLotto` : 주어진 티켓 수에 따라 로또 티켓을 생성하고, 이를 출력하는 흐름
  - `resultLotto` : 당첨 로또 번호와 보너스 번호를 사용자에게 요청하고, 로또 게임의 결과를 집계해 총 상금을 계산하고 출력하는 흐름
  - `calculateTicketCount` : 입력받은 로또 구매 비용을 기반으로 구매할 수 있는 로또 티켓 수를 계산하는 기능

---

### Test

ApplicationTest (기존)

- `기능_테스트`
- `예외_테스트`

LottoTest (기존)

- `createLottoByOverSize`
- `createLottoByDuplicatedNumber`

DomainLogicTest

- `purchaseLottoInCostInput` : 입력된 금액에 맞춰 로또가 구매되었는가?
- `isSixMatchesAwardFirstPrize` : 6개 번호가 일치하면 1등 상금을 받는다.
- `isFiveBonusMatchesAwardSecondPrize` : 5개 번호와 보너스 번호가 일치하면 2등 상금을 받는다.
- `isFiveMatchesAwardThirdPrize` : 5개 번호가 일치하면 3등 상금을 받는다.
- `isFourMatchesAwardFourthPrize` : 4개 번호가 일치하면 4등 상금을 받는다.
- `isThreeMatchesAwardFifthPrize` : 3개 번호가 일치하면 5등 상금을 받는다.
- `isTwoMatchesAwardNoPrize` : 2개 번호가 일치하면 상금이 없다.
- `isOneMatchAwardNoPrize` : 1개 번호만 일치하면 상금이 없다.
- `isReturnRateValueRightBasedOnPrize` : 당첨 내역에 따른 수익률이 옳게 계산되었는가?

ValidationTest

- `createLottoByOutOfRangeNumber` : 로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.
- `createLottoCostByNotIntegerFormat` : 로또 구입 가격이 숫자가 아니면 예외가 발생한다.
- `createLottoCostByContainsSpace` : 입력값에 공백이 포함되어 있을 경우 예외가 발생한다.
- `createLottoCostByNotDivisibleThousand` : 로또 구입 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다.
- `createBonusNumberByNotIntegerFormat` : 보너스 번호가 숫자가 아닌 경우 예외가 발생한다.
- `createBonusNumberByOutOfRangeNumber` : 보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.
- `createBonusNumberByDuplicatedLottoNumber` : 보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.

---

## 이번 주차 미션 소감

> 테스트를 작성하는 이유
>

지난 주 피드백을 보고, 단위 테스트에 대해 공부하면서 지난 주에 제가 작성했던 테스트 코드는 단위테스트가 아니라 전체적인 과정을 테스트한 것이였음을 알게 되었습니다. 이번 주차에는 TDD를 무작정 시작해보았습니다.

테스트 코드를 먼저 생각하면서 구현을 시작하니 훨씬 작은 단위의 메서드부터 구상을 시작할 수 있었고, 예외를 떠올리기에도 편했습니다. 저는 미션이 시작하고 2~3일이 지나 코드 구현과 리팩터링에 집중하다보면 필수 조건이나 작은 예외들에 대해 혼란이 오는 경우가 있었고, 리팩터링만 진행하는 5~6일 째에는 본래 목적을 잊어버리는 경우도 있었습니다. 이번 미션에서도 같은 일이 일어났으나 처음에 작성했던 테스트 단위들을 보면서 하나씩 체크해나가니 혼란이 줄어들었습니다.

무작정 문제에 접근하면 큰 부분부터 생각하게 되는 것 같습니다. 이는 추상적이고, 구현에 방해가 되는 계획이 될 때가 많은데 테스트를 기반으로 생각하고 계획을 짜니 길잡이처럼 실질적으로 구현에 많은 도움이 되었습니다. 이후 과제에서도 테스트를 기반으로 구현을 진행할 예정입니다.

> 도메인 로직이란?
>

이번주 ‘추가된 요구 사항’에 ‘도메인 로직에 단위 테스트를 구현해야 한다’는 것을 확인했습니다. 도메인 로직이라는 용어를 처음 들어봐 찾아봤습니다. 이는 ‘현실문제에 대한 의사결정을 하는 코드’임을 확인했습니다. 이후 몇 개의 예시를 찾아보고 domain과 관련된 테스트 항목을 작성했습니다.

1. 입력된 금액에 맞춰 로또가 구매되었는가? (입력 금액에 맞춰 로또 구매 개수 결정)
2. 당첨 내역이 올바르게 집계되었는가? (당첨 매뉴얼에 따라 결정)
   - 6개의 번호 일치 → 1등
   - 5개 번호 + 보너스 번호 일치 -> 2등
   - 5개 번호 일치 -> 3등
   - 4개 번호 일치 -> 4등
   - 3개 번호 일치 -> 5등
3. 당첨 내역에 따른 수익률이 올바르게 계산되었는가? (당첨 내역과 입력 금액에 대한 수익률 계산 방법에 따라 결정)

그리고 이를 기반으로 다른 테스트 코드들을 작성했고 이는 이번 주차 과제 중 저에게 길잡이처럼 작용했습니다. 이에 따라 domain 패키지도 만들어 코드를 구현했습니다.

> Enum이란?
>

이번 주차 미션을 통해서 Enum을 처음 사용해보았습니다. final로 고정된 상수의 집합이 Enum임을 공부했습니다. 이번 주 미션에서 Prize라는 이름으로 총 3개의 상수를 넣어보았습니다.

1. 일치하는 숫자의 개수 (랜덤값과 당첨값간의 일치하는 숫자)
2. 일치하는 숫자의 개수에 따른 상금
3. 상금 통계를 작성할 때 필요한 설명

이를 통해 코드를 작성하니 훨씬 쉽고 간편하게 호출할 수 있었습니다. 그리고 이 Enum의 값을 Key와 Value로 불러올 수 있는 Map의 형태를 가진 EnumMap에 대해 공부하고 사용해보았습니다.