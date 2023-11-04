package lotto.dto.input;

public record MoneyDto(int money) {
    public static MoneyDto from(String input) {
        return new MoneyDto(Integer.parseInt(input));
    }
}
