package lotto.domain;

import static lotto.util.Constants.*;

import java.util.Arrays;
import java.util.List;
import lotto.util.StringToNumberConvertor;

public class WinningNumbers {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        validateBonusNumberDuplication();
    }

    private void validateBonusNumberDuplication() {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    LottoErrorMessages.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    public static WinningNumbers of(String winningNumbers, int bonusNumber) {
        List<Integer> numbers = Arrays.stream(winningNumbers.split(COMMA.getValue()))
                .map(String::trim)
                .map(StringToNumberConvertor::convert)
                .toList();
        return new WinningNumbers(numbers, bonusNumber);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}