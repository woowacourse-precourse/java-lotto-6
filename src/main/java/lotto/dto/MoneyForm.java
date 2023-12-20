package lotto.dto;

public class MoneyForm {

    private final int price;

    public MoneyForm(String price) {
        this.price = validateNumberFormat(price);
    }

    private int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getPrice() {
        return price;
    }
}
