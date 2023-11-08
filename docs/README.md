## controller

---

### LottoController

---

#### 필드

- `private final InputView`
    - 입력을 받기 위한 UI
- `private final OutputView`
    - 로또 번호 출력 및 당첨 통계를 위한 UI
- `private final LottoService`
    - 로또를 구매하고, 당첨 번호를 입력 받는 등의 게임 로직을 수행

--- 

#### 메소드

-

## service

### LottoService

---

#### 메소드

-`public List<Integer> parseInputToNumberCandidates(String input) throws NumberFormatException`

- 사용자에게 입력받은 문자열을 "," 기준으로 나누고 공백을 자른다.
- 각 문자열을 `Integer.parseUnsignedInt()`로 0 이상 2,147,483,647이하의 정수로 바꾼다.
- 만약 부호 없는 정수로 바꿀 수 없다면 `NumberFormatException`을 발생시키는데 이를 메소드 호출 위치로 던진다.
- 바뀐 정수들을 리스트에 담아 반환한다.

## domain

--- 

### `enum` Prize

#### 상수

`NO_PRIZE(0, 0, null, 0)`,
`FIFTH_PRIZE(1, 3, Message.FIFTH_PRIZE, false, Condtion.FITH_PRIZE_AMOUNT)`,
`FOURTH_PRIZE(2, 4,  Messge.FOURTH_PRIZE, false, Condtion.FOURTH_PRIZE_AMOUNT)`,
`THIRD_PRIZE(3, 5, Messge.THIRD_PRIZE,false, Condtion.THIRD_PRIZE_AMOUNT)`,
`SECOND_PRIZE(4, 5, Messge.SECOND_PRIZE, true, Condtion.SECOND_PRIZE_AMOUNT)`,
`FIRST_PRIZE(5, 6, Messge.FIRST_PRIZE, false, Condtion.FIRST_PRIZE_AMOUNT)`

#### 필드

- `private final int index`
    - `LottoBuyer` 클래스의 `calculateRankEachLotto`의 리스트에서 사용할 인덱스
- `private final matchNumbers`
  - 일치하는 개수
- `private final String PRIZE_MESSAGE`
    - 몇 개를 맞춰야 해당 등수 인지 알려주는 메시지
- `private final boolean COMPARE_BONUS_NUMBER`
    - 보너스 번호랑 일치 여부
- `private final int PRIZE_AMOUNT`
    - 상금의 금액

#### 메소드

- `public int checkRank()`
    - `Rank.values()`를 순회한다.
    - 순회하면서 `matchNumbers`와 비교한다.
    - 순위에 있으면 해당 숫자의 인덱스를 반환한다.
    - 만약 matchNumbers가 5일 경우에는 보너스 볼 일치 여부도 확인한다.
    - `NO_RANK`일 경우 0을 반환한다.

- `private Rank findPrizeByIndex(int idx)`
    - 숫자를 받아서 해당 순위의 이름을 반환하는 메소드

- `public String getPrizeInfo(int idx)`
    - 순위리스트의 인덱스를 받아 순위 안내와 상금을 문자열로 합쳐 내보내는 메소드
    - `findPrizeByIndex(int idx)`를 사용해 순위의 이름을 가져온다.
    - `StringBuilder`로 순위의 안내문과 "(" + 상금 + ")"을 합쳐 반환한다.

---

### `class` Lotto

---

#### 필드

- `private List<Integer> numbers`
    - 오름차순으로 정렬된 6자리의 로또 번호

#### 메소드

- `public Lotto()`
    - 하나의 로또를 발급한다.

- `public Lotto(List<Integer> numbers)`
    - 입력받은 번호들 당첨 로또로 생성한다.
- `private void validate(List<Integer> numbers)`
    - `Procedure.DRAW_WINNING_NUMBERS.checkPossibleError()`를 활용해 발생할 수 있는 에러를 체크한다.

- `private void sortNumbersAscending()`
    - 숫자들을 정렬한다.

- `public int compareLottoWithWinningNumber(Lotto WinningNumber)`
    - 몇 개가 맞았는지 확인하는 메소드
- `public boolean compareLottoWithBonusNumber(int bonusNumber)`
    - 보너스 번호랑 일치하는게 있는지 확인하는 메소드

---

### `class` LottoBuyer

로또를 구매해 게임을 진행하는 사람

---

#### 필드

- `private List<Lotto> purchasedLottoes`
    - 구매한 로또
- `private Lotto winningNumbers`
    - 입력받은 당첨 번호
- `private int bonusNumber`
    - 입력받은 보너스 번호
- `private int money`
    - 구매한 금액

[//]: # (- `private int prizes`)

[//]: # (  - 당첨 금액)

#### 메소드

- `public LottoBuyer(List<Lotto> purchasedLottoes, Lotto winningNumbers, int bonusNumber, int money)`
    - 구매한 로또, 당첨번호, 보너스 번호, 구매 금액으로 로또 구매자를 생성한다.

- `private void calculateRankEachLotto(List<Integer> myRanks)`
    - 하나의 로또로 순위를 확인하는 메소드
    - 내부적으로 `Lotto`클래스의 `compareLottoWithWinngingNumber()`와 `compareLottoWithBonusNumber()`를 사용한다.
    - `enum` Rank와 비교해 `oridnal`을 반환한다.
        - 반환받은 숫자를 이용해 List의 인덱스(순위)에 로또의 결과를 넣는다.

- `public List<Integer> retrieveAllResult()`
    - 가지고 있는 모든 로또를 `calculateRankEachLotto()`로 순위를 확인한다.
    - 순위를 반환한다.

---

### `enum` ErrorType

나올 수 있는 에러 상태와 검증 로직을 가지는 상수

---

#### 상수

- `NOT_ONE_NUMBER`
    - Msg : `Message.ERROR_NOT_ONE_NUMBER`
    - test(List<Integer> numberCandidates)
        - numberCandidates에 담긴 정수의 개수를 센다.
        - 정수가 1개가 아니면 `true`를 반환하고 그렇지 않으면 `false`를 반환한다.

- `NOT_IN_THOUSANDS`
    - Msg : `Message.ERROR_NOT_IN_THOUSANDS`
    - test(List<Integer> numberCandidates)
        - numberCandidates에 담긴 정수가 1000원으로 나머지 연산을 한다.
        - 0이 아니면 `true`를 반환하고 그렇지 않으면`false`를 반환한다.

- `MONEY_CAN_NOT_BE_ZERO`
    - Msg : `Message.MONEY_CAN_NOT_BE_ZERO`
    - test(List<Integer> numberCandidates)
    - numberCandidates에 담긴 정수가 0 이상인지 확인한다.
        - 0이면 `true`를 그렇지 않으면 `false`를 반환한다.

- `NUMBER_OUT_OF_RANGE`
    - Msg : `Message.ERROR_NUMBER_OUT_OF_RANGE`
    - test(List<Integer> numberCandidates)
        - numberCandidates에 담긴 정수를 순회하며 1 ~ 45 사이의 수인지 확인한다.
        - 하나의 숫자라도 1 ~ 45의 범위에 있으면 `true`를 그렇지 않으면 `false`를 반환한다.

- `NOT_SIX_WINNING_NUMBERS`
    - Msg : `Message.ERROR_NOT_SIX_WINNING_NUMBERS`
    - test(List<Integer> numberCandidates)
        - numberCandidates에 담긴 정수의 개수를 센다.
        - 6개가 아니면 `true`를 그렇지 않으면 `false`를 반환한다.

- `DUPLICATED_NUMBER`
    - Msg : `Message.ERROR_DUPLICATED_NUMBER`
    - test(List<Integer> numberCandidates)
        - numberCandidates에 담긴 정수를 `Set`에 `add()`하면서 중복인지 체크한다.
        - 숫자가 중복되면 `true`를 하나도 중복이 없으면 `false`를 반환한다.

#### 필드

- `private String errorMsg`
    - 에러 메시지
- `private Predicate<String> errorCheck`
    - 해당 에러가 맞는지 확인하는 함수형 인터페이스

#### 메소드

- `public String getErrorMsg()`
    - 에러 메시지를 반환한다.
- `public boolean isError(String input)`
    - `Predicate<List<Integer>>`의 `test(List<Integer> numberCandidates)`를 사용해 각 상수에 저장된 람다식에 넣고 결과를 반환한다.

---

### `enum` Procedure

로또 게임의 단계와 나올 수 있는 에러들을 가지는 상수

---

#### 상수

- `PURCHASE_LOTTO`
    - domain : 구입금액
    - `List<ErrorType>`
        - `NOT_ONE_NUMBER`
        - `MONEY_CAN_NOT_BE_ZERO`
        - `NOT_IN_THOUSANDS`

- `DRAW_WINNING_NUMBERS`
    - domain : 당첨 번호
    - `List<ErrorType>`
        - `NOT_SIX_WINNING_NUMBERS`
        - `NUMBER_OUT_OF_RANGE`
        - `DUPLICATED_NUMBER`

- `DRAW_BONUS_NUMBER`
    - domain : 보너스 번호
    - `List<ErrorType>`
        - `NOT_ONE_NUMBER`
        - `NUMBER_OUT_OF_RANGE`

#### 필드

- `private String subject`
    - 에러 메시지에 출력할 단계에 사용되는 이름
- `private List<ErrorType> possibleErrors`
    - 해당 단계에서 나올 수 있는 에러들 리스트

#### 메소드

- `public void checkPossibleError(List<Integer> numberCandidates)`
    - input값을 넣었을 때 해당 단계에서 오류가 발생하는지 확인하는 메소드
    - possibleErrors에서 ErrorType 하나마다 `isError`인터페이스의 `test(List<Integer> numberCandidates)` 메소드를 실행한다.
    - 만약 하나라도 에러가 발생한다면 에러메시지와 함께 `IllegalArgumentException`을 발생시킨다.

---

## view

---

### InputView

---

#### 메소드

- `public String inputPurchaseAmount()`
    - Message.purchaseMessage를 출력하고 `Console.readLine()`으로 한 줄을 읽어온다.
- `public String drawWinningString()`
    - Message.winningNumberMessage를 출력하고 `Console.readLine()`으로 한 줄을 읽어온다.
- `public String drawBonusString()`
    - Message.bonusNumberMessage를 출력하고 `Console.readLine()`으로 한 줄을 읽어온다.

---

### OutputView

---

## constant

---

### Message

화면에 표시할 메시지들

---

#### 필드

- `COMMA`
    - ","

- `PURCHASE_MONEY`
    - "구입금액";
- `WINNING_NUMBERS`
    - "당첨 번호"
- `BONUS_NUMBERS`
    - "보너스 번호"
- `PURCHASE_MESSAGE`
    - "구입금액을 입력해 주세요.";
- `WINNING_NUMBERS_MESSAGE`
    - "당첨 번호를 입력해 주세요.";
- `BONUS_NUMBER_MESSAGE`
    - "보너스 번호를 입력해 주세요.";

- `ERROR_TEMPLATE`
    - "[ERROR] %s%s\n"
        - [ERROR]와 함께 어떤 단계에서 어떤 에러가 발생했는지 알려주는 메시지
- `ERROR_NOT_A_NUMBER`
    - "(은)는 0이상 2147483647이하의 숫자여야 합니다.";
- `ERROR_NOT_IN_THOUSANDS`
    - "(은)는 1000원 단위여야 합니다.";
- `ERROR_MONEY_CAN_NOT_BE_ZERO`
    - "(은)는 0이상의 숫자여야 합니다.";
- `ERROR_NUMBER_OUT_OF_RANGE`
    - "(은)는 1부터 45 사이의 숫자여야 합니다.";
- `ERROR_NOT_SIX_WINNING_NUMBERS`
    - "(은)는 6자리 숫자여야 합니다.";
- `ERROR_NOT_ONE_NUMBER`
    - "(은)는 1자리 숫자여야 합니다.";
- `ERROR_MSG_DUPLICATED_NUMBER`
    - "(은)는 중복될 수 없습니다.";

- `PURCHASED_LOTTO`
    - "%d개를 구매했습니다. \n"

- `RESULT_MESSAGE`
    - 당첨 통계를 알려주는 메시지

- `INTEREST_RATE_MESSAGE`
    - 가공된 총 수익률을 받아서 알려주는 메시지
- `FITH_PRIZE`
  - "3개 일치 "
- `FOURTH_PRIZE`
  - "4개 일치 "
- `THIRD_PRIZE`
  - "5개 일치 "
- `SECOND_PRIZE`
  - "5개 일치, 보너스 볼 일치"
- `FIRST_PRIZE`
    - "6개 일치 "

#### Condition

검증에 사용되는 조건들

---

#### 필드

- `MIN_LOTTO_MONEY` : 0
- `THOUSAND` : 1000
- `SIX_WINNING_NUMBERS` : 6
- `ONE_NUMBER` : 1
- `ZERO` : 0

- `MIN_DRAW_NUMBER` : 1
- `MAX_DRAW_NUMBER` : 45
- `FITH_PRIZE_AMOUNT` : 5_000
- `FOURTH_PRIZE_AMOUNT` : 50_000
- `THIRD_PRIZE_AMOUNT` : 1_500_000
- `SECOND_PRIZE_AMOUNT` : 30_000_000
- `FIRST_PRIZE_AMOUNT` : 2_000_000_000
