package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMsg;
import lotto.exception.UserInputException;

public class LottoService {

    public List<Integer> createWinningNumbers(String winningInputNumbers) {
        String[] winningNumberSplit = winningInputNumbers.split(",");
        Set<Integer> winningNumbers = new HashSet<>();
        for (String winning : winningNumberSplit) {
            int winningParser = Integer.parseInt(winning);
            winningNumbers.add(winningParser);
        }
        validateDuplicateWinningNumber(winningNumberSplit.length, winningNumbers.size());
        return new ArrayList<>(winningNumbers);
    }

    private void validateDuplicateWinningNumber(int originLength, int afterLength) {
        if (originLength != afterLength) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    public int createBonusNumber(String commonInput) {
        return Integer.parseInt(commonInput);
    }
}
