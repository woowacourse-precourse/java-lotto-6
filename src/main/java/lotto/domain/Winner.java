package lotto.domain;

import java.util.List;

public class Winner {

    private Lotto lotto;

    public Winner(String lottoNumbers) {
        lotto = new Lotto(lottoNumbers);
    }

    public List<Integer> noticeLottoWinningNumbers() {
        return lotto.getLottoNumbers();
    }
}
