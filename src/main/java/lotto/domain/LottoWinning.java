package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.IntegerConstants;
import lotto.exceptions.DuplicateException;
import lotto.exceptions.InvalidLengthException;
import lotto.exceptions.InvalidNumberException;

public class LottoWinning {
    private final List<Integer> winings;

    public LottoWinning(List<Integer> winnings) {
        validate(winnings);
        this.winings = winnings;
    }

    private void validate(List<Integer> winnings) {
        if (winnings.size() != IntegerConstants.LOTTO_NUMBERS_COUNT) {
            throw new InvalidLengthException();
        }

        Set<Integer> uniqueWinnings = new HashSet<>(winnings);
        if (uniqueWinnings.size() != winnings.size()) {
            throw new DuplicateException();
        }

        List<Integer> validWinnings = winnings.stream()
                .filter(w -> IntegerConstants.LOTTO_RANGE_START <= w && w <= IntegerConstants.LOTTO_RANGE_END)
                .toList();
        if (validWinnings.size() != winnings.size()) {
            throw new InvalidNumberException();
        }
    }

    public List<Integer> getWinnings() {
        return winings;
    }
}
