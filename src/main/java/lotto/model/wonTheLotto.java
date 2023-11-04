package lotto.model;

import java.util.Arrays;

public class wonTheLotto {
    private final Lotto wonTheLotto;
    private final int bonus;

    public wonTheLotto(Lotto lotto, int bonus) {
        wonTheLotto = lotto;

        this.bonus = bonus;
    }

    private void validate(int bonus) {
        validateRange(bonus);
        validateDuplicate(bonus);
    }

    private void validateRange(int bonus) {
        if (1 > bonus || bonus > 46) {
            throw new IllegalArgumentException(
                    String.format("보너스 숫자는 1과 46사이의 숫자입니다. 입력하신 숫자는: %d", bonus)
            );
        }
    }

    private void validateDuplicate(int bonus) {
        if (wonTheLotto.contains(bonus)) {
            throw new IllegalArgumentException(
                    String.format("로또는 중복된 숫자를 허용하지 않습니다. 입력하신 숫자는: %d", bonus)
            );
        }
    }

    public Ranking compare(Lotto lotto) {
        int count = getMatchingCount(lotto);
        boolean bonus = lotto.contains(this.bonus);
        return Arrays.stream(Ranking.values()).filter(ranking -> ranking.winnerLotto(count, bonus)).findFirst()
                .orElse(Ranking.MISS);
    }

    private int getMatchingCount(Lotto lotto) {
        return (int) lotto.cloneNumbers().stream().filter(wonTheLotto::contains).count();
    }

}
