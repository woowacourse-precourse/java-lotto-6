package lotto.domain;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class WinLottoNumbers {
    List<Integer> winLottoNumbers;

    public List<Integer> getWinLottoNumbers() {
        return winLottoNumbers;
    }

    public WinLottoNumbers(String input) {
        this.winLottoNumbers = sliceLottoNumbers(input);
        sizeCheck();
        rangeCheck();
    }

    public void rangeCheck() {
        if (winLottoNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO.getMessage()
                            + ErrorMessage.WIN_LOTTO_RANGE_ERROR.getMessage());
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
                            + ErrorMessage.WIN_LOTTO_STRING_ERROR.getMessage());
        }
    }

    public void sizeCheck(){
        if(winLottoNumbers.size()!=6){
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INFO.getMessage()
                            + ErrorMessage.WIN_LOTTO_SIZE_ERROR.getMessage());
        }
    }
}
