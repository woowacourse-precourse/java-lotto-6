package lotto.domain;

import java.util.List;

public class Winner {

    private Lotto lotto;
    private int bonus;

    public Winner(String lottoNumbers) {
        lotto = new Lotto(lottoNumbers);
    }

    public List<Integer> noticeLottoWinningNumbers() {
        return lotto.getLottoNumbers();
    }

    public void lottoWinningBonusNumber(String lottoWinningBonus) {
        this.bonus = changeInteger(lottoWinningBonus);
    }

    private int changeInteger(String lottoWinningBonus) {
        return Integer.parseInt(lottoWinningBonus);
    }
}
