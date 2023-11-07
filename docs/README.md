
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

### `class` Lotto

---
#### 필드

- `private List<Integer> `

#### 메소드

---

### `enum` ErrorType

나올 수 있는 에러 상태와 검증 로직을 가지는 상수 

---
#### 상수

- `NOT_A_NUMBER`
  - Msg : `Message.ERROR_NOT_A_NUMBER`
  - test(String input)
    - input을 받아 `String.trim()`으로 공백을 지운 후 숫자로 변환한다.
    - 변환할 수 없으면 `NumberFormatException`이 발생하면 `true`를 반환한다.
    - 모두 바꿀 수 있으면 error가 아니므로 `false`를 반환한다.
    
- `NOT_IN_THOUSANDS`
  - Msg : `Message.ERROR_NOT_IN_THOUSANDS`
  - test(String input)
    - input을 받아 `String.trim()`으로 공백을 지운다.
    - 숫자로 변환하고 1000원 단위인지 확인한다.
    - 1000원 단위가 아니면 `true`를 반환한다.
    - 1000원 단위면 `false`를 반환한다.
    
- `MONEY_OUT_OF_RANGE`
  - Msg : `Message.ERROR_MONEY_OUT_OF_RANGE`
  - test(String input)
    - input을 받아 `String.trim()`으로 공백을 지운다.
    - 숫자로 변환한 뒤 각 수가 0 ~ `Long.MAX_VALUE` 사이의 수인지 확인한다.
    - 하나의 숫자라도 0 ~`Long.MAX_VALUE`의 범위에 있으면 `true`를 그렇지 않으면 `false`를 반환한다.
  
- `NUMBER_OUT_OF_RANGE`
  - Msg : `Message.ERROR_NUMBER_OUT_OF_RANGE`
  - test(String input)
    - input을 받아 `String.trim()`으로 공백을 지운다.
    - 숫자로 변환한 뒤 각 수가 1 ~ 45 사이의 수인지 확인한다.
    - 하나의 숫자라도 1 ~ 45의 범위에 있으면 `true`를 그렇지 않으면 `false`를 반환한다.
    
- `NOT_SIX_WINNING_NUMBERS`
  - Msg : `Message.ERROR_NOT_SIX_WINNING_NUMBERS`
  - test(String input) : 당첨 번호를 받을 때 사용한다.
    - input을 ',' 기준으로 나누고 `String.trim()`으로 공백을 지운다.
    - 길이가 6자리인지 확인한다.
    - 6자리가 아니면 `true`를 그렇지 않으면 `false`를 반환한다.
    
- `NOT_ONE_NUMBER`
  - Msg : `Message.ERROR_NOT_ONE_NUMBER`
  - test(String input) : 금액과 보너스 번호를 입력받을 때 사용한다.
    - input을 ',' 기준으로 나누고 `String.trim()`으로 공백을 지운다.
    - 길이가 1자리인지 확인한다.
    - 1자리가 아니면 `true`를 반환한다.
    - 1자리면 `false`를 반환한다.
    
- `DUPLICATED_NUMBER`
  - Msg : `Message.ERROR_DUPLICATED_NUMBER`
  - test(String input)
    - input을 `,`로 나누고 `String.trim()`으로 공백을 지운다.
    - 각 문자열을 숫자로 변환한다.
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
  - `Predicate<String>`의 `test(String s)`를 사용해 각 상수에 저장된 람다식에 넣고 결과를 반환한다.

---

### `enum` Procedure

로또 게임의 단계와 나올 수 있는 에러들을 가지는 상수

---

#### 상수

- `PURCHASE_LOTTO`
  - domain : 구입금액
  - `List<ErrorType>`
    - `NOT_A_NUMBER`
    - `NOT_ONE_NUMBER`
    - `MONEY_OUT_OF_RANGE`
    - `NOT_IN_THOUSANDS`

- `DRAW_WINNING_NUMBERS`
  - domain : 당첨 번호
  - `List<ErrorType>`
    - `NOT_A_NUMBER`
    - `NOT_SIX_WINNING_NUMBERS`
    - `NUMBER_OUT_OF_RANGE`
    - `DUPLICATED_NUMBER`
    
- `DRAW_BONUS_NUMBER`
  - domain : 보너스 번호
  - `List<ErrorType>`
    - `NOT_A_NUMBER`
    - `NOT_ONE_NUMBER`
    - `NUMBER_OUT_OF_RANGE`


#### 필드

- `private String domain`
  - 에러 메시지에 출력할 단계에 사용되는 이름
- `private List<ErrorType> possibleErrors`
  - 해당 단계에서 나올 수 있는 에러들 리스트


#### 메소드
- `public void checkPossibleError(String input)`
  - input값을 넣었을 때 해당 단계에서 오류가 발생하는지 확인하는 메소드
  - possibleErrors에서 ErrorType 하나마다 `isError`인터페이스의 `test(String s)` 메소드를 실행한다.
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
  - "(은)는 숫자여야 합니다.";
- `ERROR_NOT_IN_THOUSANDS`
  - "(은)는 1000원 단위여야 합니다.";
- `ERROR_MONEY_OUT_OF_RANGE`
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

#### Condition

검증에 사용되는 조건들

---

#### 필드

- `MIN_LOTTO_MONEY` : 0
- `THOUSAND` : 1000
- `SIX_WINNING_NUMBERS` : 6
- `ONE_NUMBER` : 1

- `MIN_DRAW_NUMBER` : 1
- `MAX_DRAW_NUMBER` : 45