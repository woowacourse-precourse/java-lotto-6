package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;

public enum LottoFixture {
    SIX(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
    FIVE_WITH_BONUS(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
    FIVE_WITHOUT_BONUS(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
    FOUR(new Lotto(List.of(1, 2, 3, 4, 7, 8))),
    THREE(new Lotto(List.of(1, 2, 3, 7, 8, 9))),
    TWO(new Lotto(List.of(1, 2, 8, 9, 10, 11))),
    ONE(new Lotto(List.of(1, 8, 9, 10, 11, 12))),
    NONE(new Lotto(List.of(8, 9, 10, 11, 12, 13)));

    public static final Lotto STANDARD = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    public static final int BONUS = 7;
    private final Lotto lotto;

    LottoFixture(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto toLotto() {
        return lotto;
    }

    public static WinningNumbers standard() {
        return new WinningNumbers(STANDARD, BONUS);
    }

    public static List<Lotto> all() {
        return Arrays.stream(LottoFixture.values())
                .map(LottoFixture::toLotto)
                .toList();
    }

    public static int numberOfFixture() {
        return (int) Arrays.stream(LottoFixture.values())
                .count();
    }
}
