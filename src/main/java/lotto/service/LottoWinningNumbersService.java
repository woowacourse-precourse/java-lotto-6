package lotto.service;

import java.util.List;
import lotto.domain.LottoWinningNumbers;
import lotto.util.Parser;

public class LottoWinningNumbersService {

    public LottoWinningNumbers createLottoWinningNumbers(String numbers, String number) {
        List<Integer> winningNumbers = Parser.stringToIntList(numbers);
        int bonusNumber = Integer.parseInt(number);
        return LottoWinningNumbers.create(winningNumbers, bonusNumber);
    }
}
