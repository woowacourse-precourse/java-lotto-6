package lotto;

public class MoneyToBuy {
    private final Integer value;

    public MoneyToBuy(Integer value) {
        this.value = value;
    }

    public static MoneyToBuy stringToMoney(String string) {
        Integer integer;
        try {
            integer = Integer.parseInt(string);
            validate(integer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return new MoneyToBuy(integer);
    }

    private static void validate(Integer value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        else if (value % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
