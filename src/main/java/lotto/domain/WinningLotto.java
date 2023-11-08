package lotto.domain;

import static lotto.constant.ErrorMessageConstant.DUPLICATE_NUMBER_ERROR_MESSAGE;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public LottoResult matchLotto(Lotto playerLotto) {
        int count = matchNumber(playerLotto.getNumbers());
        boolean bonus = matchBonus(playerLotto.getNumbers(), count);

        return LottoResult.valueOf(count, bonus);
    }

    private boolean matchBonus(List<Integer> playerLotto, int count) {
        return playerLotto.contains(bonusNumber) && count == 5;
    }

    private int matchNumber(List<Integer> playerLotto) {
        List<Integer> winningLotto = lotto.getNumbers();

        return (int) winningLotto.stream()
                .filter(playerLotto::contains)
                .count();
    }
}
