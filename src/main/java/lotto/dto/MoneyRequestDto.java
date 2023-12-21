package lotto.dto;

public class MoneyRequestDto {

    private final int price;

    public MoneyRequestDto(String price) {
        this.price = validateNumberFormat(price);
    }

    private int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getPrice() {
        return price;
    }
}
