package lotto.view.input;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.WinningNumbersRequestDto;

public class WinningNumbersInputView {

    public static WinningNumbersRequestDto readWinningNumbers() {
        String input = Console.readLine();
        return toDto(validateNumbersFormat(input));
    }

    private static WinningNumbersRequestDto toDto(List<Integer> numbers) {
        WinningNumbersRequestDto dto = new WinningNumbersRequestDto();
        dto.setNumbers(numbers);
        return dto;
    }

    private static List<Integer> validateNumbersFormat(String input) {
        try {
            return Stream.of(input.split(","))
                    .map(n -> Integer.parseInt(n.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
