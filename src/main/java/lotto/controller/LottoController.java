package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.result.LottoMachine;
import lotto.domain.user.LottoCount;
import lotto.domain.user.UserLotto;
import lotto.domain.win.Bonus;
import lotto.domain.win.WinLotto;
import lotto.generator.RandomNumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoController(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void play() {
        LottoCount lottoCount = setLottoCount();
        UserLotto userLotto = setUserLotto(lottoCount);
        WinLotto winLotto = setWinLotto();
        compareLotto(userLotto, winLotto);
    }

    private LottoCount setLottoCount() {
        while (true) {
            try {
                return new LottoCount(Input.money());
            } catch (IllegalArgumentException e) {
                Output.message(e.getMessage());
            }
        }
    }

    private UserLotto setUserLotto(LottoCount lottoCount) {
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(randomNumberGenerator);
        Output.userLotto(userLotto);
        return userLotto;
    }

    private Lotto setLotto() {
        while (true) {
            try {
                return new Lotto(Input.winLottoNumbers());
            } catch (IllegalArgumentException e) {
                Output.message(e.getMessage());
            }
        }
    }

    private Bonus setBonus() {
        return new Bonus(Input.bonusNumber());
    }

    private WinLotto setWinLotto() {
        Lotto lotto = setLotto();
        while (true) {
            try {
                Bonus bonus = setBonus();
                return new WinLotto(lotto, bonus);
            } catch (IllegalArgumentException e) {
                Output.message(e.getMessage());
            }
        }
    }

    private void compareLotto(UserLotto userLotto, WinLotto winLotto) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.compare(userLotto, winLotto);

        Output.lottoResult(lottoMachine);
        Output.rateOfReturn(lottoMachine.calculateRate(userLotto));
    }
}
