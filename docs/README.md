
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

---
#### 메소드


## domain

--- 

### `class` Lotto

---
#### 필드

- `private List<Integer> `

---

### `enum` ErrorType

---

### `enum` Procedure

---

## view

---

### InputView

---
#### 필드

- `private final String purchaseMessage`
  - "구입금액을 입력해 주세요."
- `private final String winningNumberMessage`
  - "당첨 번호를 입력해 주세요."
- `private final String bonusNumberMessage`
  - "보너스 번호를 입력해 주세요."

---
#### 메소드
- `public String inputPurchaseAmount()`
  - purchaseMessage를 출력하고 `Console.readLine()`으로 한 줄을 읽어온다.
- `public String drawWinningString()`
  - winningNumberMessage를 출력하고 `Console.readLine()`으로 한 줄을 읽어온다.
- `public String drawBonusString()`
  - bonusNumberMessage를 출력하고 `Console.readLine()`으로 한 줄을 읽어온다.
---

### OutputView
