package lotto.domain.money;

/**
 * 불변 클래스 `Money`를 래핑하여 내부적으로 `Money`를 재할당 하는 식으로 불변 객체인 `Money`를 가변 객체처럼 다룰 수 있게 합니다.
 */
public final class Wallet {
    private Money money;

    public Wallet(final Money money) {
        this.money = money;
    }

    /**
     * 잔액이 0인 `Money`를 들고 있는 `Wallet`을 생성합니다.
     */
    public static Wallet empty() {
        return new Wallet(Money.zero());
    }

    /**
     * 원하는 만큼의 잔액을 가진 `Wallet`을 생성합니다.
     */
    public static Wallet with(final long amount) {
        return new Wallet(Money.from(amount));
    }

    /**
     * 아래 메소드들은 `Money`에 비슷한 기능을 하는 다른 이름의 메소드가 존재하지만,
     * <p>
     * `Wallet`에 맞춘 이름으로 도메인에 맞게 이름을 맞춰 주었습니다. 내부에 들고 있는 `Money`에서 인자로 받은 잔액 만큼을 제하여 새로운 `Money`를 `Wallet` 내에 생성 및
     * 재할당합니다.
     */
    public void spend(final Money other) {
        this.money = Money.clone(money.decreased(other));
    }

    /**
     * 내부에 들고 있는 `Money`에서 인자로 받은 잔액 만큼을 합하여 새로운 `Money`를 `Wallet` 내에 생성 및 재할당합니다.
     */
    public void fill(final Money other) {
        this.money = Money.clone(money.increased(other));
    }

    /**
     * 현재 `Wallet` 내의 잔액이 인자로 받은 금액 이상인지 확인합니다.
     */
    public boolean hasEqualOrMoreThan(final Money money) {
        return this.money.isEqualsOrGreaterThan(money);
    }
}
