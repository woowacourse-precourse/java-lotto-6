package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;


public class LottoWinNumbers {
    List<Integer> lottoWinNumbers = new ArrayList<>();

    public LottoWinNumbers(String input) {
        this.lottoWinNumbers = sliceLottoNumbers(input);
        sizeCheck();
        rangeCheck();
        uniqueCheck();
    }

    private void rangeCheck() {
        if (lottoWinNumbers.stream()
                .anyMatch(number -> number < Constants.LOTTO_MIN_NUM || number > Constants.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR);
        }
    }

    private List<Integer> sliceLottoNumbers(String input) {
        try {
            return Arrays.stream(input.split(Constants.COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_STRING_ERROR);
        }
    }

    private void sizeCheck() {
        if (lottoWinNumbers.size() != Constants.LOTTO_NUM_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR);
        }
    }

    private void uniqueCheck() {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoWinNumbers);
        if (uniqueNumbers.size() != Constants.LOTTO_NUM_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_UNIQUE_ERROR);
        }
    }

    public List<Integer> getLottoWinNumbers() {
        return lottoWinNumbers;
    }
}
