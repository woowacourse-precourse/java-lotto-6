package lotto.Model.Util;

import System.Phrase;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaffleUtil {

    public List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(Phrase.RAFFLE_DELIMITER.getConstant()))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
