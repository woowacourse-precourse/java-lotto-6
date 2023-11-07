package lotto.service;

import static lotto.validation.constant.CommonErrorConstant.SPLIT_MESSAGE;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoWinningNumbers;

public class LottoWinningNumbersService {

    public LottoWinningNumbers createLottoWinningNumbers(String numbers, String number) {
        List<Integer> winningNumbers = stringToCollection(numbers);
        int bonusNumber = Integer.parseInt(number);
        return LottoWinningNumbers.create(winningNumbers, bonusNumber);
    }

    private List<Integer> stringToCollection(String input) {
        return Arrays.stream(input.split(SPLIT_MESSAGE.getMessage()))
                .map(Integer::parseInt)
                .toList();
    }
}
