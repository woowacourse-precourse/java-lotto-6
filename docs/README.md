# 구현 과정 정리

## 구현 시 중점을 둔 부분

이번 미션의 구현에서 중점을 둔 부분은 다음과 같다.

- 예외 처리를 어떻게 추상화 할 수 있을지 고민했다.
    - 공통된 예외 처리 전략을 통해 중복 코드를 줄이고 일관된 예외 처리 전략을 사용할 수 있게 되었다.
- 검증의 책임이 어디에 존재해야 하는지 고민했다.
    - 검증의 종류를 두가지로 분리하고 각자의 위치에 책임을 분리했다.
- 서비스 레이어를 stateless하게 구현했다.
    - 클래스가 statless하지 않다면 객체 메서드 호출 시 객체 내부 상태에 영향을 받게 된다. 클라이언트 객체는 기대한 응답을 받을 수 없을 수 있다. 따라서 객체를 stateless하게 설계했다.
    - 의존성을 드러내자.
- 패키지간의 의존성을 생각하며 패키지 구조를 짰다.
    - 도메인 레이어가 다른 레이어에 의존하지 않도록 해 도메인 레이어를 재사용할 수 있도록 했다.
    - 서비스 레이어도 도메인 레이어에만 의존하도록 해 재사용성을 높였다.
    - 패지키 구조 변경을 통해 프로젝트 전체의 의존성을 줄이는 방향으로 변경했다.

### 예외 처리

해당 프로젝트에서는 사용자가 잘못된 값을 입력할 경우 에러 메세지를 출력하고 다시 입력을 받는다. 이전 프로젝트에서는 입력으로 인한 예외가 발생했을 때 프로그램을 종료했다.

이처럼 예외가 발생했을 때 어떻게 처리할 것인지는 요구사항마다 다르다. 예외 처리 전략에 관한 인터페이스를 다음과 같이 구현했다.

```java
public interface ExceptionHandler {

    Object applyFunction(LottoGameView lottoGameView, Function<LottoGameView, Object> function);
}

```

`Function` 함수형 인터페이스를 사용해 동작을 정의하고 파라미터로 `LottoGameView`를 받고 있다. 이번 프로젝트는 예외가 발생하지 않을때까지 입력을 무한정으로 다시 받는다.

따라서 `InfiniteRetryExceptionHandler`를 다음과 같이 구현할 수 있다.

```java
public class InfiniteRetryExceptionHandler implements ExceptionHandler {

    @Override
    public Object applyFunction(LottoGameView lottoGameView, Function<LottoGameView, Object> function) {
        while (true) {
            try {
                return function.apply(lottoGameView);
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
    }
}
```

`while`문을 돌면서 `funtion.apply()`에서 예외가 발생하지 않으면 값을 반환하고 예외가 발생하면 예외 메세지를 출력하고 다시 `funtion.apply()`를 실행한다.

이번 프로젝트에서는 입력을 3번 받게된다. 3번 모두 예외가 발생할 수 있고 모두 입력이 정상일 때 까지 입력을 다시 받는 예외 처리 전략을 사용한다. 따라서 `LottoGameController`에서 다음과 같이
간단하게 공통된 예외 처리 전략을 적용할 수 있다.

```java
public class LottoGameController {

    // 생성자를 통해 ExceptionHandler 주입

    // 생략...

    private LottoBonusNumber createLottoBonusNumber(LottoWinningNumber lottoWinningNumber) {
        return (LottoBonusNumber) exceptionHandler.applyFunction(lottoGameView,
                view -> {
                    LottoBonusNumberCreateRequest lottoBonusNumberCreateRequest =
                            view.inputLottoBonusNumberCreateRequest();
                    return new LottoBonusNumber(lottoWinningNumber,
                            lottoBonusNumberCreateRequest.getBonusNumber());
                });
    }

    private LottoWinningNumber createLottoWinningNumber() {
        return (LottoWinningNumber) exceptionHandler.applyFunction(lottoGameView,
                view -> {
                    LottoWinningNumberCreateRequest lottoWinningNumberCreateRequest =
                            view.inputLottoWinningNumberCreateRequest();
                    return new LottoWinningNumber(lottoWinningNumberCreateRequest.getNumbers());
                });
    }

    private LottoPurchase purchaseLotto() {
        return (LottoPurchase) exceptionHandler.applyFunction(lottoGameView,
                view -> {
                    LottoPurchaseRequest lottoPurchaseRequest = view.inputPurchaseRequest();
                    return new LottoPurchase(lottoPurchaseRequest.getPurchaseAmount());
                });
    }

}
```

만약 다른 전략을 적용하고 싶다면 전략에 맞게 `ExceptionHandler`를 구현해서 `LottoGameContoller`의 생성자로 의존성을 주입하면 `LottoGameContoller`의 코드 변경 없이
예외 처리 전략을 변경할 수 있다.

함수형 인터페이스와 의존성 주입 활용으로 코드를 변경하지 않고 기능을 변경할 수 있는 개방 폐쇄 원칙을 지킬 수 있게 되었다.

### 검증의 책임은 어디에 존재하는가?

어떤 인스턴스가 존재한다면 우리는 그 인스턴스가 검증된 인스턴스라고 믿고 사용한다. 즉, 검증되지 않는 객체는 생성하면 안된다. 따라서 객체의 생성자에 검증의 책임을 부여하는 것이 맞다고 생각한다.

그렇다면 검증의 책임을 DTO의 생성자에 몰아 넣는것이 맞을까? 나는 여기서 검증을 2가지로 분리할 수 있다고 생각했다.

- 비즈니스 로직과 관련된 검증
- 비즈니스 로직과 관련되지 않은 검증

해당 프로젝트에서 비즈니스 로직과 관련된 검증이란 다음과 같은 것이 있을 것이다.

- 구매 금액은 1000원의 양의 배수여야 한다.
- 입력 숫자는 1 ~ 45 사이여야 한다.
- 당첨 번호의 갯수는 6개여야 한다.
- 당첨 번호와 보너스 번호는 각자 또는 서로 중복되면 안된다.

비즈니스 로직과 관련되지 않는 검증

- 입력은 숫자여야 한다.

만약 콘솔 입력이 아니라 GUI를 통해 숫자를 클릭하는 방식이 요구사항 이었다면 어떨까? 그럴 땐 입력이 당연히 숫자일 것이므로 검증이 필요하지 않을 것이다. 즉, 비즈니스 로직과 관련되지 않은 검증만 변화한다.
변화의 이유가 다르다면 분리해야한다.

```java
public class LottoPurchaseRequest {

    private final int purchaseAmount;

    public LottoPurchaseRequest(String purchaseAmount) {
        try {
            this.purchaseAmount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_FORMAT);
        }
    }

    // 생략 ...
}

public class LottoPurchase {

    private final long purchaseAmount;

    public LottoPurchase(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NON_POSITIVE_PURCHASE_AMOUNT);
        }

        if (purchaseAmount % LottoConstant.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_BY_LOTTO_TICKET_PRICE);
        }
    }

    // 생략 ...
}
```

따라서 비즈니스 로직과 관련된 검증은 입력 관련 DTO의 생성자에 위치시키고, 비즈니스 로직과 관련된 검증은 도메인 관련 클래스의 생성자에서 처리하도록 했다.

검증의 분리로 `ExceptionMessage`클래스도 둘로 분리할 수 있게 되었다. 따라서 분리된 클래스를 각각의 패키지로 분리해 전체적인 의존성을 줄일 수 있게 되었다.

비즈니스 요구사항이 변경되면 도메인 클래스만 수정하면 되고 입력 관련 요구사항이 변경되면 DTO 클래스만 수정하면 된다. 이로써 단일 책임 원칙을 지킬 수 있게 되었다.

### stateless하게 서비스 레이어 구현

초기에는 서비스 클래스가 내부에 멤버 변수로 객체를 가지고 있도록 설계했다. 이렇게 설계하면 외부에서 전달할 파라미터가 줄어들기 때문에 효과적일 것이라고 생각했다. 메시지 호출은 간편해졌지만 객체 내부적으로 메서드의
호출 순서가 지켜지지 않으면 예외가 발생했다.

즉, 어떤 메서드가 실행되기 전에 특정 메서드의 실행이 보장되야 하는 것이다.

```java

public class Service {
    private A a;
    private B b;

    public createA(int info) {
        a = new A(info);
    }

    public createB(int info) {
        b = new B(info);
    }

    public doSomething() {
        a.foo();
        b.boo();
    }
}
```

만약 위와 같은 클래스가 존재한다고 생각해보자. 클라이언트 객체는 `doSomething()`를 호출하기 전에 `createA()`와 `createB()`를 호출해야 한다. 만약 그냥 `doSomething()`을
호출한다면 `NullPointException`이 발생할 것이다.

나는 이 프로젝트를 구현한지 얼마 되지 않았기 때문에 해당 사실을 알수 있지만 시간이 지나면 금방 까먹을 것이고, 협업 프로젝트라면 해당 사실을 팀원들에게 모두 알려야한다. 코드를 통해 메서드 실행이 보장시킬 수
없기 때문에 휴먼 에러가 생길 것이고 문제가 발생하면 골치거리일 것이다.

모두 숨겨진 의존성 때문이다. 해당 `Service` 클래스가 `A`와 `B`에 의존하는 것을 숨기고 있기 때문에 부작용이 생긴 것이다. 메서드 파라미터나 생성자를 통해 해당 의존성을 드러내자.

```java

public class Service {

    public doSomething(A a, B b) {
        a.foo();
        b.boo();
    }
}
```

위처럼 수정해 숨겨진 의존성을 외부로 들어내자. 객체 내부에서 계속 사용되는 객체라면 멤버 변수로 지정하고 생성자를 통해 주입받는 것을 고려해볼 수 있다.

이 프로젝트에서 개선 전의 `LottoGameService` 클래스이다. 숨겨진 의존성으로 메서드 실행 순서가 생겼다.

```java
public class LottoGameService {

    private final LottoGenerator lottoGenerator;

    private LottoPurchase lottoPurchase;
    private List<Lotto> lottoTickets;
    private LottoWinningNumber lottoWinningNumber;
    private LottoBonusNumber lottoBonusNumber;

    public LottoGameService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    /**
     * 메서드 호출 전 createLottoWinningNumber 메서드와 createLottoBonusNumber 메서드가 호출되어야 합니다.
     */
    public LottoWinningResult calculateLottoWinningResult() {
        Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();
        for (Lotto lottoTicket : lottoTickets) {
            LottoPrize lottoPrize = lottoTicket.prize(lottoWinningNumber, lottoBonusNumber);
            prizeCountMap.put(lottoPrize, prizeCountMap.getOrDefault(lottoPrize, 0) + 1);
        }
        return new LottoWinningResult(lottoPurchase, prizeCountMap);
    }

    public List<Lotto> createLottoPurchase(LottoPurchaseRequest lottoPurchaseRequest) {
        lottoPurchase = new LottoPurchase(lottoPurchaseRequest.getPurchaseAmount());
        return lottoTickets = lottoPurchase.purchase(lottoGenerator);
    }

    public void createLottoWinningNumber(LottoWinningNumberCreateRequest lottoWinningNumberCreateRequest) {
        lottoWinningNumber = new LottoWinningNumber(lottoWinningNumberCreateRequest.getNumbers());
    }

    /**
     * 메서드 호출 전 createLottoWinningNumber 메서드가 호출되어야 합니다.
     */
    public void createLottoBonusNumber(LottoBonusNumberCreateRequest lottoBonusNumberCreateRequest) {
        lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber, lottoBonusNumberCreateRequest.getBonusNumber());
    }

}
```

`calculateLottoWinningResult()`메서드를 보자. 위와 같이 `javadoc`을 통해 메서드 호출 순서를 알렸지만 누가 `javadoc`을 유심히 보겠는가. 구조적으로 제한할 수 있도록
변경했다.

```java
public class LottoGameService {

    private final NumbersGenerator numbersGenerator;

    public LottoGameService(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public LottoWinningResult calculateLottoWinningResult(
            List<Lotto> lottoTickets,
            LottoPurchase lottoPurchase, LottoWinningNumber lottoWinningNumber,
            LottoBonusNumber lottoBonusNumber) {
        Map<LottoPrize, Integer> prizeCounts = new HashMap<>();
        for (Lotto lottoTicket : lottoTickets) {
            LottoPrize lottoPrize = lottoTicket.prize(lottoWinningNumber, lottoBonusNumber);
            prizeCounts.put(lottoPrize, prizeCounts.getOrDefault(lottoPrize, 0) + 1);
        }
        return new LottoWinningResult(lottoPurchase, prizeCounts);
    }

    public List<Lotto> purchaseLotto(LottoPurchase lottoPurchase) {
        long numTickets = lottoPurchase.countTickets();
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numTickets; ++i) {
            lottoTickets.add(new Lotto(numbersGenerator.generate(
                    LottoConstant.LOTTO_START_NUMBER,
                    LottoConstant.LOTTO_END_NUMBER,
                    LottoConstant.LOTTO_NUMBER_COUNT
            )));
        }
        return lottoTickets;
    }

}
```

`calculateLottoWinningResult()`메서드를 보자. 파라미터로 의존성을 드러냈다. `LottoWinningResult` 생성을 위해 필요한 객체를을 메서드 파라미터를 통해서 받았다. 이제 메서드의
호출 순서를 고민할 필요가 없다. 메서드 파라미터를 넣지 않으면 동작하지 않을 것이 자명하고 메서드 파라미터를 지정하면 메서드를 예상대로 동작하게 된다.

### 도메인 격리 & 패키지 의존성 관리

도메인에서 나가는 의존성의 없도록 설계했다. 또한 서비스는 도메인 클래스에만 의존하도록 했다. 서비스는 파라미터로 도메인 객체만을 받고 도메인 객체만을 리턴하도록 했다. 도메인 객체와 DTO의 변환은 컨트롤러에서
처리하도록 했다.

또한 주입받을 인터페이스를 같은 패키지에 둬서 의존성이 역전할 수 있도록 했다.

![](https://i.imgur.com/awjWLvO.png)

`LottoGameController`는 `ExceptionHandler` 인터페이스와 `LottoGameView`인터페이스에 의존하므로 같은 클래스에 둔다. 실제 구현체들은 패키지 외부에 둔다. 의존하는
인터페이스를 같은 패키지에 둠으로써 컴파일 타임 의존성을 해결했다. 위의 방법으로 `SEPERATED INTERFACE` 패턴을
지켯다. [작성한 블로그 글](https://dukcode.github.io/object/object-chap09/#의존성-역전-원칙과-패키지)을 참조하면 추가적인 내용을 확인할 수 있다.

```
 lotto
├──  Application.java
├──  controller
│  ├──  dto
│  │  ├──  LottoBonusNumberCreateRequest.java
│  │  ├──  LottoPurchaseRequest.java
│  │  ├──  LottoResponse.java
│  │  ├──  LottoWinningNumberCreateRequest.java
│  │  └──  LottoWinningStatistics.java
│  ├──  ExceptionHandler.java
│  ├──  LottoGameController.java
│  └──  LottoGameView.java
├──  domain
│  ├──  constant
│  │  └──  LottoConstant.java
│  ├──  exception
│  │  └──  ExceptionMessage.java
│  ├──  Lotto.java
│  ├──  LottoBonusNumber.java
│  ├──  LottoPrize.java
│  ├──  LottoPurchase.java
│  ├──  LottoWinningNumber.java
│  └──  LottoWinningResult.java
├──  generator
│  └──  RandomNumbersGenerator.java
├──  handler
│  └──  InfiniteRetryExceptionHandler.java
├──  service
│  ├──  LottoGameService.java
│  └──  NumbersGenerator.java
└──  view
   ├──  exception
   │  └──  ExceptionMessage.java
   └──  LottoGameConsoleView.java
```

위의 두가지 방법을 적용한 결과 다음과 같은 패키지 의존성을 만들 수 있었다.

![](https://i.imgur.com/ysYKwWe.png)

중요한 것은 서비스와 도메인 레이어에서 나가는 의존성이 없다는 것이다. 따라서 해당 패키지를 분리하거나 재사용할 수 있다.

## 구현 기능 목록 정리

### 공통 요구사항

- [x] JDK17 버전으로 구현한다.
- [x] `Application`의 `main`메서드가 프로그램의 시작점이다.
- [x] `build.gradle` 파일을 변경하기 않는다.
- [x] [Java 코드 컨벤션 가이드](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍한다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 메서드가 한가지 일만 하도록하고 길이가 15라인을 넘어가지 않도록 구현한다..
- [x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [x] else 예약어를 쓰지 않는다. switch/case도 금지한다. early return을 이용해 구현한다.
- [x] Java Enum을 적용한다.

### 라이브러리 관련 요구사항

- [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console`
  API를 사용하여 구현해야 한다.
    - [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

[사용 예시]

```java
List<Integer> numbers=Randoms.pickUniqueNumbersInRange(1,45,6);
```

### `Lotto` 클래스

- [x] 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- [x] `numbers`의 접근 제어자인 private을 변경할 수 없다.
- [x] `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- [x] `Lotto`의 패키지 변경은 가능하다.

### 프로젝트 관련 요구사항

- [x] 로또 구입 금액 입력 요청 메시지를 출력한다.

[예시]

```
구입금액을 입력해 주세요.
```

- [x] 로또 구입 금액 입력을 받는다.
    - [x] 구입 금액은 1000원 단위로 입력 받으며 1000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    - [x] 구입 금액은 0 초과의 숫자여야 한다.

[예시]

```
8000
```

- [x] 로또 구입 갯수를 출력한다.

[예시]

```
8개를 구매했습니다.
```

- [x] 구매한 로또 내역을 출력한다.
    - [x] 로또 번호는 오름차순으로 정렬하여 보여준다.
    - [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
    - [x] 로또 번호의 숫자 범위는 1~45까지이다.

[예시]

```
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- [x] 당첨 번호 입력 요청 메세지를 출력한다.

[예시]

```
당첨 번호를 입력해 주세요.
```

- [x] 당첨 번호 입력을 받는다.
    - [x] 번호는 쉼표(,)를 기준으로 구분한다.
    - [x] 당첨 번호는 1~45 사이의 숫자여야 한다.
    - [x] 당첨 번호는 서로 중복되면 안된다.

[예시]

```
1,2,3,4,5,6
```

- [x] 보너스 번호 입력 요청 메세지를 출력한다.

[예시]

```
보너스 번호를 입력해 주세요.
```

- [x] 보너스 번호 입력을 받는다.
    - [x] 보너스 번호는 1~45 사이의 숫자여야 한다.
    - [x] 보너스 번호는 당첨 번호와 중복되면 안된다.

[예시]

```
7
```

- [x] 당첨 통계를 출력한다.
- [x] 수익률은 소수점 둘째 자리에서 반올림한다.
- [x] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

[예시]

```
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

- [x] 예외 상황 시 에러 문구를 출력해야한다.
    - [x] 에러 문구는 "[ERROR]"로 시작해야 한다.
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

[예시]

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

[전체 실행 결과 예시]

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,46

[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```