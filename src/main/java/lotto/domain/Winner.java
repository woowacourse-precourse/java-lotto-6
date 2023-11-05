package lotto.domain;

import java.util.List;

public class Winner {

    private Lotto lotto;
    private Bonus bonus;

    public Winner(String lottoNumbers) {
        lotto = new Lotto(lottoNumbers);
    }
}
