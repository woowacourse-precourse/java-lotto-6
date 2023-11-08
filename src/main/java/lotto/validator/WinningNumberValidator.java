package lotto.validator;

import lotto.domain.Constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {
    Constants constants = new Constants();

    public void checkLottoNumber(String lottoInput) {
        checkLottoNumberValid(lottoInput);
        List<String> lotto = Arrays.asList(lottoInput.split(","));
        checkLottoNumberIsNumber(lotto);
        checkLottoInRange(lotto);
        checkLottoDuplicate(lotto);
    }

    public void checkBonusNumber(List<Integer> lotto, String bonusNumber) {
        checkBonusNumberIsNumber(bonusNumber);
        checkBonusNumberInRange(Integer.parseInt(bonusNumber));
        checkBonusDuplicate(lotto, Integer.parseInt(bonusNumber));
    }

    public void checkLottoNumberValid(String lotto) {
        if(!lotto.contains(",")) {
            System.out.printf(constants.WINNING_NUMBER_NOT_VALID_ERROR);
            throw new IllegalArgumentException();
        }
        if(Arrays.asList(lotto.split(",")).size() != constants.LOTTO_NUMBER) {
            System.out.printf(constants.WINNING_NUMBER_NOT_SIX_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void checkLottoNumberIsNumber(List<String> lotto) {
        for (int i = 0; i < lotto.size(); i++) {
            String lottoNumber = lotto.get(i);
            try{
                Integer.parseInt(lottoNumber);
            }
            catch(NumberFormatException e) {
                System.out.printf(constants.WINNING_NUMBER_NOT_NUMBER_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkLottoDuplicate(List<String> lotto) {
        Set<String> lottoWithoutDuplicate = new HashSet<>(lotto);
        if (lotto.size() != lottoWithoutDuplicate.size()) {
            System.out.printf(constants.WINNING_NUMBER_DUPLICATED_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void checkLottoInRange(List<String> lotto) {
        for (int i=constants.ZERO_NUMBER; i<lotto.size(); i++) {
            int lottoNumber = Integer.parseInt(lotto.get(i));
            if(lottoNumber >= constants.LOTTO_NUMBER_MIN && lottoNumber <= constants.LOTTO_NUMBER_MAX) {
                continue;
            }
            System.out.printf(constants.WINNING_NUMBER_RANGE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void checkBonusNumberIsNumber(String bonusNumber) {
        try{
            Integer.parseInt(bonusNumber);
        }
        catch(NumberFormatException e) {
            System.out.printf(constants.BONUS_NUMBER_NOT_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void checkBonusNumberInRange(int bonusNumber) {
        if(bonusNumber >= constants.LOTTO_NUMBER_MIN && bonusNumber <= constants.LOTTO_NUMBER_MAX) {
            return;
        }
        System.out.printf(constants.BONUS_NUMBER_RANGE_ERROR);
        throw new IllegalArgumentException();
    }

    public void checkBonusDuplicate(List<Integer> lotto, int bonusNumber) {
        for (int i = 0; i < constants.LOTTO_NUMBER; i++) {
            if(lotto.get(i) == bonusNumber) {
                System.out.printf(constants.BONUS_NUMBER_DUPLICATED_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }
}
