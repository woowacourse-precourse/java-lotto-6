package Model;

import java.util.List;

public class LottoValidator {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private  static final int MAX_LOTTO_NUMBER = 45;

    void validateWinningNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    String deleteWhiteSpace(String predictedLottoNumber) {
        return predictedLottoNumber.replace("\\s", "");
    }

    String correctCommas(String predictedLottoNumber) {
        predictedLottoNumber = predictedLottoNumber.replaceAll("^,|,$", "");
        predictedLottoNumber = predictedLottoNumber.replaceAll(",+", ",");
        return predictedLottoNumber;
    }

    void validateWinningNumberRange(List<Integer> winningNumber) {
        for (Integer lottoNumber : winningNumber) {
            if (MIN_LOTTO_NUMBER > lottoNumber || MAX_LOTTO_NUMBER < lottoNumber) {
                throw  new IllegalArgumentException();
            }
        }
    }
}
