package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinnerLotto;

public interface Counter {

    Lottos buyLotto();

    WinnerLotto generateWinnerLotto(Lotto lotto);

    Lotto generateLotto();
}
