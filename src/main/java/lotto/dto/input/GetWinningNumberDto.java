package lotto.dto.input;

import java.util.List;

public class GetWinningNumberDto {
    private final List<Integer> winningNumbers;

    public GetWinningNumberDto(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }


}
