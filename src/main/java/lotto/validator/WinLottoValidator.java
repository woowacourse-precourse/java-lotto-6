package lotto.validator;

import static lotto.Option.ErrorMessage.NOT_BONUS_DUPLICATION;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.win.Bonus;

public class WinLottoValidator {
    private WinLottoValidator() {
    }

    public static void check(Lotto lotto, Bonus bonus) {
        duplication(lotto, bonus);
    }

    private static void duplication(Lotto lotto, Bonus bonus) {
        List<Integer> lottoAndBonus = new ArrayList<>(lotto.numbers());
        lottoAndBonus.add(bonus.number());

        if (isDuplication(lottoAndBonus)) {
            throw new IllegalArgumentException(NOT_BONUS_DUPLICATION.getErrorMessage());
        }
    }

    private static boolean isDuplication(List<Integer> validator) {
        return validator.stream()
                .distinct()
                .count() != validator.size();
    }
}
