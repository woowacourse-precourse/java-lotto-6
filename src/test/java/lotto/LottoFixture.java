package lotto;

import java.util.Arrays;
import java.util.List;

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

    Lotto toLotto() {
        return lotto;
    }

    static WinningNumbers standard() {
        return new WinningNumbers(STANDARD, BONUS);
    }

    static List<Lotto> all() {
        return Arrays.stream(LottoFixture.values())
                .map(LottoFixture::toLotto)
                .toList();
    }
}
