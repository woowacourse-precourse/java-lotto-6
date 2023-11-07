package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.compareSystem.LottoMachine;
import lotto.domain.user.LottoCount;
import lotto.domain.user.UserLotto;
import lotto.domain.win.Bonus;
import lotto.domain.win.WinLotto;
import lotto.generator.RandomNumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private final Input input;
    private final Output output;
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoController(Input input, Output output, RandomNumberGenerator randomNumberGenerator) {
        this.input = input;
        this.output = output;
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
                return new LottoCount(input.money());
            } catch (IllegalArgumentException e) {
                output.message(e.getMessage());
            }
        }
    }

    private UserLotto setUserLotto(LottoCount lottoCount) {
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(randomNumberGenerator);
        output.userLotto(userLotto);
        return userLotto;
    }

    private Lotto setLotto() {
        while (true) {
            try {
                return new Lotto(input.winLottoNumbers());
            } catch (IllegalArgumentException e) {
                output.message(e.getMessage());
            }
        }
    }

    private Bonus setBonus() {
        return new Bonus(input.bonusNumber());
    }

    private WinLotto setWinLotto() {
        Lotto lotto = setLotto();
        while (true) {
            try {
                Bonus bonus = setBonus();
                return new WinLotto(lotto, bonus);
            } catch (IllegalArgumentException e) {
                output.message(e.getMessage());
            }
        }
    }

    private void compareLotto(UserLotto userLotto, WinLotto winLotto) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.compare(userLotto, winLotto);

        output.lottoResult(lottoMachine);
        output.rateOfReturn(lottoMachine.calculateRate(userLotto));
    }
}
