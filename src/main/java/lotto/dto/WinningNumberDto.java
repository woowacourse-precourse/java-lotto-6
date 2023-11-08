package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberDto {
    private List<Integer> winngingNumber;
    private int bonusNumber;

    public WinningNumberDto(String winningNumber, String bonusNumber) {
        this.winngingNumber = castTypeStringListToIntegerList(castTypeStringToStringListByComma(winningNumber));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinngingNumber() {
        return winngingNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<String> castTypeStringToStringListByComma(String input) {
        final String COMMA = ",";

        List<String> result = List.of(input.split(COMMA));

        return result;
    }

    private List<Integer> castTypeStringListToIntegerList(List<String> input) {
        List<Integer> result = input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return result;
    }
}
