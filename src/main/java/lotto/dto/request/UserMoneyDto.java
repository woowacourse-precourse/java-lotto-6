package lotto.dto.request;

public final class UserMoneyDto {
    private final int money;

    public UserMoneyDto(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
