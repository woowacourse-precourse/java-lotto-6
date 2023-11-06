# 우테코 프리코스 3주차 🎟️ 로또

## 프로젝트 구조 🥸📚
```text
├─ controller
│  └─ Controller
├─ model
│  ├─ Buyer
│  ├─ Lotto
│  └─ LottoGame
├─ view
│  ├─ LottoGameView
│  ├─ PurchaseView
│  └─ WinningResultView
└─ Application
```

## 기능 구현 목록 🥳🎈
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. 로또 1장의 가격은 1,000원이다.
- [x] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- [ ] 당첨 번호를 입력받는다. 번호는 쉼표(,)를 기준으로 구분한다.
- [ ] 보너스 번호를 입력받는다.
- [ ] 발행한 로또 수량을 출력한다.
- [ ] 발행한 로또 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 출력한다.
- [ ] 수익률을 출력한다. 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

## 추가 구현 목록 🧝🏻‍🍀
- [ ] 금액이 커질 경우 변수 타입의 범위를 넘어설 수 있는가 고려하여 설계한다.
- [ ] Service 단을 추가하여 Controller는 입력처리와 응답에만 집중하도록 한다.

## 집중했던 것은 🤔💭
### 1. 함수(성또는 메서드)가 한 가지 일만 하가도록 최대한 작게 만들어라.
- `2주차 공통 피드백` 내용대로, 함수가 한 가지 기능을 하는지 확인하는 기준이 필요했다. 👀
  - 한 개의 함수가 한 가지 기능만 하더라도 결국 통합하는 과정에서 여러가지 함수를 호출하는 함수가 생긴다.
  - 이러한 함수를 여러 가지 일을 한다고 구분하지 않고, '여러 작은 함수를 호출하여 큰 한 가지 기능을 담당하는 함수'라고 해석한다.
  - 🤜🏻 즉, **큰 기능을 작게 쪼개어** 함수를 작성한 후, **작은 함수 여러개를 호출해 '큰 기능을 구현하는 함수'를 생성**하는 방식으로 설계한다.
    ```java
    /* 구매자 초기화 */
    /* (1)구매 금액을 입력받아 (2)로또를 구매하고 (3)구매자에 대한 정보를 설정한다. */ 
    private void initBuyer() { 
        int purchaseAmount = getPurchaseAmount(); // (1) 구매금액 입력
        ArrayList<Lotto> lottoTickets = purchaseLottoTickets(purchaseAmount); // (2) 로또 구매
        buyer = new Buyer(purchaseAmount, lottoTickets); // (3) 구매자 객체 생성
    }
    ```

### 2. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.

### 3. else 예약어를 쓰지 않는다.

### 4. Java Enum을 적용한다.

### 5. Lotto 클래스를 활용한다.
- Lotto 클래스는 '로또 티켓' 개념으로 활용하였다.
- Buyer 모델의 클래스 변수로 사용하여, '사용자가 구매하여 소지'하는 의미로 풀어냈다.


### 6. 값을 하드 코딩하지 않는다.
- 지난 과제까지 계속해서 했던 하드코딩을 이번에는 안 했다! 🧚‍
- 로또 구매 금액 단위, 로또 숫자 범위, 당첨금과 기준 등 고정적인 값을 모두 상수로 정의했다.
- constant 패키지에 상수를 모두 정의하여 구분하였다.
```java
// constant 패키지 내용 중 일부
public static final int PURCHASE_AMOUNT_UNIT = 1000;
public static final int MIN_IN_LOTTO_NUMBER = 1;
public static final int MAX_IN_LOTTO_NUMBER = 45;
public static final int NUMBER_OF_WINNING_NUMBER = 6;
public static final int NUMBER_OF_BONUS_NUMBER = 1;
```

### 7. 변수 이름에 자료형은 사용하지 않는다.

### 8. 한 함수가 한 가지 기능만 담당하게 한다

### 9. 함수의 길이를 15라인을 넘어가지 않도록 구현한다.
