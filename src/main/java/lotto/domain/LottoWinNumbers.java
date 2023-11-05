package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class LottoWinNumbers {
    List<Integer> lottoWinNumbers;

    public List<Integer> getLottoWinNumbers() {
        return lottoWinNumbers;
    }

    public LottoWinNumbers(String input) {
        this.lottoWinNumbers = sliceLottoNumbers(input);
        sizeCheck();
        rangeCheck();
        uniqueCheck();
    }

    public void rangeCheck() {
        if (lottoWinNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO
                            + ErrorMessage.LOTTO_RANGE_ERROR);
        }
    }

    public List<Integer> sliceLottoNumbers(String input) {
        try {
            return Arrays.stream(input.split(Constants.COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO
                            + ErrorMessage.LOTTO_STRING_ERROR);
        }
    }

    public void sizeCheck() {
        if (lottoWinNumbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO
                            + ErrorMessage.LOTTO_SIZE_ERROR);
        }
    }

    private void uniqueCheck() {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoWinNumbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO
                            + ErrorMessage.LOTTO_UNIQUE_ERROR);
        }
    }
}
