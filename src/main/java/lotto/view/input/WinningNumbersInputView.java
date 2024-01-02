package lotto.view.input;


import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;
import lotto.dto.WinningNumbersRequestDto;

public class WinningNumbersInputView {

    public static WinningNumbersRequestDto readWinningNumbers() {
        String input = Console.readLine();
        validateNumbersFormat(input);
        return toDto(input);
    }

    private static WinningNumbersRequestDto toDto(String numbers) {
        WinningNumbersRequestDto dto = new WinningNumbersRequestDto();
        dto.setNumbers(numbers);
        return dto;
    }

    private static void validateNumbersFormat(String input) {
        try {
            Stream.of(input.split(","))
                    .forEach(n -> Integer.parseInt(n.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
