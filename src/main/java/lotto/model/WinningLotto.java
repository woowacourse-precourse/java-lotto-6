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
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 지정된 범위안의 숫자로 넣어주세요. 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
    }

    private void validateNonNumericBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches("^[0-9]*")) {
            throw new IllegalArgumentException("[Error] 보너스 번호에 숫자가 아닌 값이 들어왔습니다.");
        }
    }

    private void vaildateOutOfRangeBonusNumber(Integer bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 지정된 범위안의 숫자로 넣어주세요. 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
    }

    private void vaildateLottoNumbersContainBonusNumber(Integer bonusNumber) {
        if (super.isInputNumberContainLottoNumbers(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 겹치면 안됩니다.");
        }
    }

    @Override
    protected Integer convertStringToInteger(String bonusNumber) {
        Integer convertBonusNumber;

        try {
            convertBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 지정된 범위안의 숫자로 넣어주세요. 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
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
        }
        if (numberOfHitLottoNumbers == 4) {
            return 4;
        }
        if (numberOfHitLottoNumbers == 5) {
            if (hitBonusNumber) {
                return 2;
            }
            return 3;
        }
        if (numberOfHitLottoNumbers == 6) {
            return 1;
        }
        return 0;
    }

}
