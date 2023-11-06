package lotto.model;

import java.util.List;

public class Purchase<T> {
    public static final int PURCHASE_MONEY_UNIT = 1_000;
    private static final String PURCHASE_MONEY_NOT_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String PURCHASE_MONEY_MINIMUM_LIMIT = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    private static final String PURCHASE_MONEY_UNIT_LIMIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    private static final String PURCHASE_ITEMS_SIZE_NOT_MATCH = "[ERROR] 구입 금액과 구매 개수가 일치하지 않습니다.";

    private final int money;
    private List<T> items;

    public Purchase(String inputMoney) {
        this.money = validatePurchaseMoney(inputMoney);
    }

    private int validatePurchaseMoney(String inputMoney) {
        int money = parseMoney(inputMoney);
        validateMinimumLimit(money);
        validateUnitLimit(money);
        return money;
    }

    private int parseMoney(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_MONEY_NOT_NUMBER);
        }
    }

    private void validateMinimumLimit(int money) {
        if (money < PURCHASE_MONEY_UNIT) {
            throw new IllegalArgumentException(PURCHASE_MONEY_MINIMUM_LIMIT);
        }
    }

    private void validateUnitLimit(int money) {
        if (money % PURCHASE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_UNIT_LIMIT);
        }
    }

    public void purchaseItems(List<T> items) {
        this.items = validatePurchaseItems(items);
    }

    private List<T> validatePurchaseItems(List<T> items) {
        if (items.size() != money / PURCHASE_MONEY_UNIT) {
            throw new IllegalStateException(PURCHASE_ITEMS_SIZE_NOT_MATCH);
        }

        return items;
    }

    public int getMoney() {
        return money;
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return items.stream()
                .map(T::toString)
                .reduce((item1, item2) -> item1 + "\n" + item2)
                .orElse("");
    }
}
