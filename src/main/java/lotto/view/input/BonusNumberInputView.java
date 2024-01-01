package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberRequestDto;

public class BonusNumberInputView {

    public static BonusNumberRequestDto readBonusNumber() {
        String input = Console.readLine();
        return toDto(validateNumberFormat(input));
    }

    private static BonusNumberRequestDto toDto(int number) {
        BonusNumberRequestDto dto = new BonusNumberRequestDto();
        dto.setNumber(number);
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
