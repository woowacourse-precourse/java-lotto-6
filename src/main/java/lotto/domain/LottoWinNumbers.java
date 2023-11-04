package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;
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
    }

    public void rangeCheck() {
        if (lottoWinNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO.getMessage()
                            + ErrorMessage.LOTTO_WIN_SIZE_ERROR.getMessage());
        }
    }

    public List<Integer> sliceLottoNumbers(String input) {
        try {
            return Arrays.stream(input.split(Constants.COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO.getMessage()
                            + ErrorMessage.LOTTO_WIN_SIZE_ERROR.getMessage());
        }
    }

    public void sizeCheck(){
        if(lottoWinNumbers.size()!=6){
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO.getMessage()
                            + ErrorMessage.LOTTO_WIN_SIZE_ERROR.getMessage());
        }
    }
}
