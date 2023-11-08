package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.controller.LottoErrorMessage;

import java.util.List;

public class LottoBonusInputView {

    public int getBonusInput(List<Integer> winNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        int bonus = parseBonusInput(winNumbers, bonusInput);
        checkBonusIsValid(winNumbers, bonus);
        return bonus;
    }

    public int parseBonusInput(List<Integer> winNumbers, String bonusInput) {
        int bonus;
        try {
            bonus = Integer.parseInt(bonusInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    LottoErrorMessage.INVALID_LOTTO_NUMBER_TYPE.getMessage());
        }
        return bonus;
    }

    public void checkBonusIsValid(List<Integer> winNumbers, int bonus) {
        checkBonusRange(bonus);
        checkBonusDuplication(winNumbers, bonus);
    }

    private void checkBonusRange(int bonus) {
        if (bonus <= 0 || bonus > 45) {
            throw new IllegalArgumentException(
                    LottoErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void checkBonusDuplication(List<Integer> winNumbers, int bonus) {
        if (winNumbers.contains(bonus)) {
            throw new IllegalArgumentException(
                    LottoErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }
}
