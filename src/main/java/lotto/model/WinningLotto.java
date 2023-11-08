package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto{
    private final Integer bonusNumber;

    public WinningLotto(String lottoNumbers, String bonusNumber) {
        super(lottoNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = convertStringToInteger(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) {
        validateConvertBeforeBonusNumber(bonusNumber);
        validateConvertAfterBonusNumber(convertStringToInteger(bonusNumber));
    }

    private void validateConvertBeforeBonusNumber(String bonusNumber) {
        validateNotNullBonusNumber(bonusNumber);
        validateNonNumericBonusNumber(bonusNumber);
    }

    private void validateConvertAfterBonusNumber(Integer bonusNumber) {
        vaildateOutOfRangeBonusNumber(bonusNumber);
        vaildateLottoNumbersContainBonusNumber(bonusNumber);
    }

    private void validateNotNullBonusNumber(String bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_BONUS_MONEY_ERROR.getMessage());
        }
    }

    private void validateNonNumericBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches("^[0-9]*")) {
            throw new IllegalArgumentException(Exception.NON_NUMERIC_BONUS_NUMBERS_ERROR.getMessage());
        }
    }

    private void vaildateOutOfRangeBonusNumber(Integer bonusNumber) {
        if (bonusNumber < LottoGameSettingConstValue.MIN_LOTTO_NUMBER.getValue() || bonusNumber > LottoGameSettingConstValue.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_BONUS_MONEY_ERROR.getMessage());
        }
    }

    private void vaildateLottoNumbersContainBonusNumber(Integer bonusNumber) {
        if (super.isInputNumberContainLottoNumbers(bonusNumber)) {
            throw new IllegalArgumentException(Exception.LOTTO_NUMBERS_CONTAIN_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    @Override
    protected Integer convertStringToInteger(String bonusNumber) {
        Integer convertBonusNumber;

        try {
            convertBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Exception.OUT_OF_RANGE_BONUS_MONEY_ERROR.getMessage());
        }
        return convertBonusNumber;
    }

    public Integer checkLottoRanking(Lotto lottoToCompare) {
        Integer numberOfHitLottoNumbers = 0;
        boolean hitBonusNumber = false;

        numberOfHitLottoNumbers = checkLottoNumber(lottoToCompare.getNumbers());
        hitBonusNumber = checkBonusNumber(lottoToCompare.getNumbers());
        return searchLottoRanking(numberOfHitLottoNumbers, hitBonusNumber);
    }

    private Integer checkLottoNumber(List<Integer> lottoNumbersToCompare) {
        Integer numberOfHitLottoNumbers = 0;

        for (Integer currentLottoNumber : lottoNumbersToCompare) {
            if (super.isInputNumberContainLottoNumbers(currentLottoNumber)) {
                numberOfHitLottoNumbers++;
            }
        }
        return numberOfHitLottoNumbers;
    }

    private boolean checkBonusNumber (List<Integer> lottoNumbersToCompare) {
        return lottoNumbersToCompare.contains(bonusNumber);
    }

    private Integer searchLottoRanking (Integer numberOfHitLottoNumbers, boolean hitBonusNumber) {
        if (numberOfHitLottoNumbers == 3) {
            return 5;
        } else if (numberOfHitLottoNumbers == 4) {
            return 4;
        } else if (numberOfHitLottoNumbers == 5) {
            if (hitBonusNumber) {
                return 2;
            }
            return 3;
        } else if (numberOfHitLottoNumbers == 6) {
            return 1;
        }
        return 0;
    }

}
