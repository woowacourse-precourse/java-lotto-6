package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.enums.ExceptionMessages;
import lotto.enums.Patterns;

public class LottoResultManager {
    private Lotto winningLotto;
    private Integer bonusNumber;

    private void validateWinningLotto(String winningLottoNumber) {
        if (!isValidWinningLotto(winningLottoNumber)) {
            System.out.println("ok");
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    private Boolean isValidWinningLotto(String lottoNumbers) {
        return Patterns.LOTTO_NUMBERS_CHECK.getPattern().matcher(lottoNumbers).matches();
    }

    private List<Integer> convertWinningNumbersToList(String winningLottoNumbers) {
        List<Integer> result = new ArrayList<>();
        String[] numberString = winningLottoNumbers.split(",");
        Arrays.stream(numberString).forEach(number -> {
            result.add(Integer.parseInt(number));
        });
        return result;
    }

    private void validateBonusNumber(String bonusNumber) {
        if (!isValidBonusNumber(bonusNumber) || hasDuplicatedBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private Boolean isValidBonusNumber(String bonusNumber) {
        return Patterns.LOTTO_BONUS_NUMBER_CHECK.getPattern().matcher(bonusNumber).matches();
    }

    private Boolean hasDuplicatedBonusNumber(String bonusNumber) {
        return this.winningLotto.getNumbers().contains(Integer.valueOf(bonusNumber));
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningLotto(String winningLottoNumbers) {
        validateWinningLotto(winningLottoNumbers);
        this.winningLotto = new Lotto(convertWinningNumbersToList(winningLottoNumbers));
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.valueOf(bonusNumber);
    }
}
