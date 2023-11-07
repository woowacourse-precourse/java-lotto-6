package lotto.service;

import static lotto.message.ErrorMessage.INVALID_AMOUNT_ERROR;
import static lotto.message.ErrorMessage.INVALID_LOTTO_NUMBER_ERROR;
import static lotto.message.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static lotto.message.ErrorMessage.SAME_NUMBER_ERROR;

import java.util.HashSet;
import java.util.Set;

public class LottoValidator {

    public boolean isValidAmount(int buyAmount) {
        try {
            if(buyAmount % 1000 != 0 || buyAmount < 1000) {
                throw new IllegalArgumentException(INVALID_AMOUNT_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isValidLottoNumbers(int[] lottoNumbers)  {
        try {
            if(!isValidLottoSize(lottoNumbers)) {
                throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.getMessage());
            }
            if(!isValidNumber(lottoNumbers)) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR.getMessage());
            }
            if(hasSameNumber(lottoNumbers)) {
                throw new IllegalArgumentException(SAME_NUMBER_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean isValidLottoSize(int[] lottoNumbers) {
        return lottoNumbers.length == 6;
    }

    private boolean hasSameNumber(int[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int num : numbers) {
            if (!uniqueNumbers.add(num)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidNumber(int[] lottoNumbers) {
        for(int i = 0; i < lottoNumbers.length; i++) {
            if(lottoNumbers[i] < 1 || lottoNumbers[i] > 45) {
                return false;
            }
        }
        return true;
    }


}
