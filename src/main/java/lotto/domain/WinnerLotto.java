package lotto.domain;

public class WinnerLotto {

    private final Lotto lotto;
    private final LottoNumber bounus;

    public WinnerLotto(Lotto lotto, LottoNumber bounus) {
        validContainBounus(lotto, bounus);
        this.lotto = lotto;
        this.bounus = bounus;
    }

    private static void validContainBounus(Lotto lotto, LottoNumber bounus) {
        if (isContain(lotto, bounus)) {
            throw new IllegalArgumentException("보너스넘버가 잘못 되었습니다.");
        }
    }

    private static boolean isContain(Lotto lotto, LottoNumber bounus) {
        return lotto.contain(bounus);
    }
}
