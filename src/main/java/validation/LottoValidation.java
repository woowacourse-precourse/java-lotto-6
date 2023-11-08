package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import view.OutputMessage;

public class LottoValidation {
    private static final int LOTTO_PRICE = 1000;

    public boolean validateInputPrice(int inputPrice) {
        if (inputPrice % LOTTO_PRICE != 0) {
            return false;
        }
        return true;
    }

    public boolean isPriceInteger(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]" + OutputMessage.OUTPUT_ERROR_PRICE_VALID.getMessage());
        }
    }

    public boolean isBiggerThanZero(int inputPrice) {
        if (inputPrice < 0) {
            return false;
        }
        return true;
    }

    public void lottoNumberCount(String[] lottoNumbersByUser) {
        if (lottoNumbersByUser.length < 6 || lottoNumbersByUser.length > 6) {
            throw new IllegalArgumentException("[ERROR]" + OutputMessage.OUTPUT_ERROR_LOTTO_COUNT.getMessage());
        }
    }

    public void lottoNumberOverlap(List<Integer> lottoNumbersByUser) {
        Set<Integer> uniqueLottoNumber = new HashSet<>(lottoNumbersByUser);
        if (uniqueLottoNumber.size() != lottoNumbersByUser.size()) {
            throw new IllegalArgumentException(OutputMessage.OUTPUT_ERROR_LOTTO_NUMBER_UNIQUE.getMessage());
        }
    }

    public boolean isLottoNubmerInteger(String lottoNumber) {
        try {
            Integer.parseInt(lottoNumber);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]" + OutputMessage.OUTPUT_ERROR_LOTTO_NUMBER_VALID.getMessage());
        }
    }

    public boolean validateLottoNumber(int lottoNumber) {
        if (lottoNumber <= 0 || lottoNumber > 45) {
            return false;
        }
        return true;
    }
    public void isOverlapWithWinningNumbers(List<Integer> winningLottoNumbers, int bonusNumber) {
        for (int winningNumber: winningLottoNumbers) {
            if(winningNumber == bonusNumber){
                throw new IllegalArgumentException("[ERROR]" + OutputMessage.OUTPUT_ERROR_LOTTO_NUMBER_UNIQUE.getMessage());
            }
        }
    }


}
