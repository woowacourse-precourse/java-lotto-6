package lotto.validator;

import static lotto.Option.ErrorMessage.NOT_LOTTO_DUPLICATION;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.win.Bonus;

public class WinLottoValidator {
    public static void go(Lotto lotto, Bonus bonus) {
        duplication(lotto, bonus);
    }

    private static void duplication(Lotto lotto, Bonus bonus) {
        List<Integer> lottoAndBonus = new ArrayList<>(lotto.getLotto());
        lottoAndBonus.add(bonus.getBonusNumber());

        if (isDuplication(lottoAndBonus)) {
            throw new IllegalArgumentException(NOT_LOTTO_DUPLICATION.getErrorMessage());
        }
    }

    private static boolean isDuplication(List<Integer> validator) {
        return validator.stream()
                .distinct()
                .count() != validator.size();
    }
}
