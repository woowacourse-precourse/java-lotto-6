# Money

로또를 구매하기 위한 금액을 `Money`로 추상화

`LottoSeller.buyUntilOutOfMoney`로 로또를 구매할 때,

Wrapper class인 `Money` 내의 잔액이 감소하게 됨

'변경'이 일어남

```java
private List<Lotto> buyUntilOutOfMoney(
        final List<Lotto> lottos,
        final Money money
) {
    // 잔액이 부족한 경우, 지금까지 구매한 로또를 모은 List 반환
    if (money.isLessThan(Lotto.PRICE)) {
        return lottos;
    }
    // 로또 생성
    final Lotto lotto = lottoGenerator.generate();
    // 잔액 차감
    money.decrease(Lotto.PRICE);
    // List 추가
    lottos.add(lotto);
    // 재귀 호출로 추가 구매 시도
    return buyUntilOutOfMoney(lottos, money);
}
```

위와 같은 상황이기 때문에 `Money`의 잔액을 변경할 수 있어야 함.

만약 `Money`가 불변이라면, 위와 같이 재귀 호출하는 구조를 사용할 수 없게 됨.

코드를 깔끔하게 작성하기 위해 위 재귀 구조를 변경하지 않으면서 해결법을 고민해봤음.

---

`LottoPrize`에서도 당첨금을 표현하기 위해 `Money`로 래핑하고 있는데,

`Money`의 속성이 불변이 아닌 가변이기 때문에 실수로 변경될 여지가 있음

---

## 해결 방안 및 이점

`Money`를 상속하는 `Price` 클래스 생성

`Money`를 상속하여 `Money.spend` 등의 메소드에서 호환 가능

그러나 `Price` 자체에서는 `spend`를 오버라이드하여 호출하지 못하도록 막아서 불변을 유지할 수 있음

'가격'은 소비될 수 없으며, 단위로서만 존재해야 하기 때문에 이렇게 만드는 것이 실수할 가능성을 없애주고 좀 더 명시적

## 실점

`spend`를 오버라이드 했다고 해도 접근 제어자를 `protected`로 변경하는 것은 불가능.

```java
public class Price extends Money {

    @Override
    public void add(int amount) {
        throw new IllegalArgumentException("여기서는 호출할 수 없음");
    }

    // 아래와 같이 접근 제어자를 변경한 오버라이딩을 사용할 수는 없음
    // 'add(int)' in 'Price' clashes with 'add(int)' in 'Money'; attempting to assign weaker access privileges ('protected'); was 'public' 
    @Override
    protected void add(int amount) {
        throw new IllegalArgumentException("여기서는 호출할 수 없음");
    }
}
```

**`UnmodifiableList`처럼 호출 시, 런타임에 예외를 발생시켜 막는다고 해도, IDE에서 사용할 수 없는 메소드임에도 불구하고 노출되어 혼란을 야기할 수 있음**

## 대안1

위 문제를 해결하기 위해서 차라리 `Money`를 `Price`의 컴포지션으로 두기로 함

```java
public class Price {

    private Money money;

    // 항상 `amount`가 동일한 새로운 `Money`를 생성하여 반환
    public Money getMoney() {
        // Money.copy 정적 팩토리 메소드는 같은 `amount`를 가진 새로운 `Money` 생성
        return Money.copy(money);
    }
}
```

`Price`에서 `getMoney`를 호출하면, `Money.copy`를 호출하여 원본과 완전히 격리된,

새로운 `Money`를 생성해서 반환하기 때문에 내부 `Money`는 불변성을 유지할 수 있음.

```java

class Main {
    public static void main(String[] args) {
        Price price = new Price(1_000);
        Money money = new Money(5_000);

        // 1_000원 짜리 물건을 구매하여,
        // 잔액이 5_000원인 Money에서 1_000 차감
        money.decrease(price.getMoney());
    }
}
```

단점은 위와 같은 로직을 표현할 때,

한 번 getter를 호출해야 한다는 것이다.

```java
public class Money {

    private int amount;

    public void increase(Price price) {
        increase(price.getMoney());
    }

    public void increase(Money money) {
        int nextAmount = this.amount + money.amount;
        // 검증 후 재할당
        vaidateAmount(nextAmount);
        this.amount = nextAmount;
    }
}
```

위와 같이 `Price`를 인자로 받도록 오버라이딩 하는 방법으로 해결할 수는 있을 것이다.

그러나 이렇게 되면 `Money`에서 `Price`를 인자로 받고,

또 그 안에서 `Price.getMoney()`를 호출하여 다시 `Money`를 꺼내서 쓰는,

두 클래스가 서로를 쌍방으로 참조하는 관계가 되어 구조적으로 나쁘다고 생각되었다.

```java
class Main {
    public static void main(String[] args) {
        Price price = new Price(1_000);
        Price price2 = new Price(1_000);

        // price의 내부 money가 바뀌지는 않음
        // '복사'해서 새로운 `Money` 객체를 반환하기 때문
        // 그러나 그 사실을 알기 위해서는 내부를 까봐야 하며,
        // 캡슐화가 훼손된다고 생각했음
        price.getMoney()
                .increase(price2.getMoney());
    }
}
```

위와 같이 이상한 코드도 가능해졌다.

`Price`가 내부의 `Money`를 복사하여 원본이 바뀌지는 않으므로,

원본을 건드릴 수는 없겠지만 그 사실을 알려면 내부를 봐야 한다.

즉, `Price` 안의 `Money`가 불변이라는 사실을 애초에 파악하기 어렵겠다는 생각이 들었다.

`Money` 자체를 애초에 불변성을 유지하는 클래스로 만드는 것이

일관적이고 모호성을 줄일 수 있겠다고 생각하여 여기서 구조를 조금 바꿔보기로 했다.

## 대안2

```java
public class Money {
    // 불변
    private final int amount;

    public Money(final int amount) {
        // 생략
    }

    // 이제 모든 Money는 필드를 변경하는 것이 아니라,
    // 항상 새로운 Money 객체 생성 및 반환
    public Money increased(final int money) {
        return new Money(amount + money.amount);
    }
}
```

우선 `Money`를 불변 객체로 변경했다.

이제 `increase`로 원본 객체의 `amount`를 증가시키는 것이 아니라,

항상 값이 증가된 새로운 `Money`를 생성하여 반환한다.

한 번 생성된 `Money`는 메모리 상에서 해제될 때까지 래핑된 값이 변할 일이 없다.

즉, 모든 `Money`의 불변이 보장되며

메소드 명을 `increased`로 변경해서 이를 명시해준다.

대부분의 불변 메소드에 `-ed`를 붙여서 원본을 변경하는 것이 아닌,

새로운 객체를 반환함을 명시해주는 암묵적인 규칙이 있다는 것을 알게 되어서,

이를 반영했다.

그러나 이 상태에서는 앞서 사용했던 `Price`를 상속하거나 컴포지션으로 등록하는 방식을

모두 사용할 수 없다.

```java
public class Wallet {
    // 불변
    private Money money;

    public Wallet(final Money money) {
        // 생략
    }

    public void increase(final Money other) {
        this.money = money.increased(other);
    }
}
```

그리고 `Money` 불변 객체를 들고 있는 `Wallet` 클래스를 만들었다.

```java
 private List<Lotto> buyUntilOutOfMoney(
        final List<Lotto> lottos,
        final Wallet wallet
) {
    // 잔액이 부족한 경우, 지금까지 구매한 로또를 모은 List 반환
    if (wallet.hasEnoughToBuy(Lotto.PRICE)) {
        return lottos;
    }
    // 로또 생성
    final Lotto lotto = lottoGenerator.generate();
    // 잔액 차감
    wallet.spend(Lotto.PRICE);
    // List 추가
    lottos.add(lotto);
    // 재귀 호출로 추가 구매 시도
    return buyUntilOutOfMoney(lottos, money);
}
```

그리고 처음 작성한 재귀 구조의 로또 구매 코드에

`Money`만 `Wallet`으로 변경했으며,

좀 더 메소드명을 `Wallet`에 맞게 `spend`, `hasEnoughToBuy`로 변경했다.

이제 `Money`는 어디서 사용하더라도 일관적으로 불변 객체다.

```java
public enum LottoPrize {
    FIRST(1, Money.from(2_000_000_000), 6, false),
    SECOND(2, Money.from(30_000_000), 5, true),
    THIRD(3, Money.from(1_500_000), 5, false),
    FOURTH(4, Money.from(50_000), 4, false),
    FIFTH(5, Money.from(5_000), 3, false),
    NONE(0, Money.zero(), 0, false);

    // ...
}
```

이제 `LottoPrize`에서 등수 별 당첨금을 표현하기 위해 `Money`가 변경될까봐 걱정할 필요도 없고,

이를 위해 `Price`라는 불변 객체로 래핑할 필요도 없다.

`Money` 자체가 불변이기 때문이다.

메소드명이 모두 `-ed`가 붙은 형태이기 때문에 불변임을 대략적으로 유추할 수 있다.

협업을 한다면 물론 이를 문서 등에 명시하는 것이 더 좋을 것이다.

---

3차 로또 미션을 만들어보면서 `Money`를 불변화 하면서도 재귀적으로 구성된 코드의 구조를 변경하지 않고

간단히 `Money`를 래핑하고, 변경이 필요한 부분만 래퍼 타입으로 바꿔주는 것으로 문제를 해결할 수 있었다.

사실 처음 생각한 방법이 `Wallet`으로 `Money`를 래핑하는 방법이었지만,

더 좋은 방법이 없을지 고민해보다가 다양한 삽질을 해볼 수 있었으며,

그래도 삽질을 한 덕분에 다양한 가능성을 시도해 볼 수 있었고,

각 방법의 장단점에 대해 알아보고 학습해볼 수 있었다.

더 좋은 방법도 분명 있을 것이기 때문에 나중에 비슷한 사례를 다시 고민해 볼 것.