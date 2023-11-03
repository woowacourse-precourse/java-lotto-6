## 📙 미션 - 로또

### 💡 기능 구현

<br>

### 📃 Lotto

1. 로또에서 뽑은 6개의 숫자만 넣는다. 6개가 넘어가면 예외 메시지 날림.
2. 6개의 숫자는 중복될 수 없다. 중복되면 예외 메시지 날림.
3. 뽑은 숫자는 1 ~ 45까지만 넣어야 한다. 이것도 예외 메시지.

<br>

***

### 📃 LottoSetNumber

1. 랜덤으로 뽑은 숫자를 리스트에 넣는다.
   <br>

***

<br>

### 📃 PlayerPurchase

1. 사용자가 구매하는 로또 가격과 살 수 있는 로또 개수
2. 로또 개수는 사용자가 구입 금액 / 1000
3. 사용자가 구입한 금액은 0보다 커야 함. 작으면 예외 메시지
4. 사용자가 구입한 금액은 1000으로 나눴을 때 나머지가 0이도록 해야 함 (예외 메시지)

<br>

***

<br>

### 📃 Ranking (enum)

1. 1등이면 6개 일치, 2,000,000,000원 / 2등이면 5개 일치, 보너스 볼 일치, 30,000,000원 / 3등이면 5개 일치, 1,500,000원 / 4등이면 4개 일치, 50,000원 / 5등이면
   3개 일치, 5,000원
   <br>

***

<br>

### 📃 Winner

1. 구매한 로또에서 몇 개가 일치하는지 개수와 보너스 볼 일치 개수가 몇 개인지

<br>

***

<br>

### 📃 입력할 View와 출력할 View를 만들어줌.

### input

1. ㅇ
   <br>

### output

1.

<br>

### 📃 RacingCarController

1.

<br>

***

😱 생각하지 못한 것 <br>

***

<br>
<br>

### < 폴더 구조 >

```
├─main
│  └─java
│      └─baseball
│          │--Application.java (경주 시작)
│          │
│          ├─controller
│          │  -  LottoController.java (실행 동작 구조)
│          │
│          ├─model
│          │  -  Lotto.java
│          │  -  LottoSetNumber.java
│          │  -  PlayerPurchase.java
│          │  -  Ranking.java
│          │  -  Winner.java
│          │
│          ├
|          |
│          │
│          └─view
│             -  Input.java (입력)
│             -  Output.java (출력할 모든 메세지)
│
└─test
    └─java
        ├─ racingcar
        │   -   LottoTest.java
        │   -   LottoSetNumber.java
        │   -   PlayerPurchaseTest.java
        │   -   WinnerTest.java
        │   -   InputTest.java
```