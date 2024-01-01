package lotto.view.input;


import camp.nextstep.edu.missionutils.Console;
import lotto.dto.MoneyRequestDto;

public class MoneyInputView {

    public static MoneyRequestDto readMoney() {
        String input = Console.readLine();
        return toDto(validateNumberFormat(input));
    }

    private static MoneyRequestDto toDto(int price) {
        MoneyRequestDto dto = new MoneyRequestDto();
        dto.setPrice(price);
        return dto;
    }

    private static int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
