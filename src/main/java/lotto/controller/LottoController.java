package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
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
        userLotto.create(randomNumberGenerator); //이것도 파라미터로?

        output.userLotto(userLotto);

        WinLotto winLotto = setWinLotto();
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.compare(userLotto, winLotto);

        output.lottoResult(lottoMachine);
        output.rateOfReturn(lottoMachine.calculateRate(userLotto));
    }

    private LottoCount setLottoCount() {
        boolean isContinue = true;
        while (isContinue) {
            try {
                LottoCount lottoCount = new LottoCount(input.money());
                isContinue = false;
                return lottoCount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    private UserLotto setUserLotto(LottoCount lottoCount) {
        return new UserLotto(lottoCount);
    }

    private Lotto setLotto() {
        boolean isContinue = true;
        while (isContinue) {
            try {
                Lotto lotto = new Lotto(input.winLottoNumbers());
                isContinue = false;
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    private Bonus setBonus() {
        boolean isContinue = true;
        while (isContinue) {
            try {
                Bonus bonus = new Bonus(input.bonusNumber());
                isContinue = false;
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    private WinLotto setWinLotto() {
        boolean isContinue = true;
        while (isContinue) {
            Lotto lotto = setLotto();
            Bonus bonus = setBonus();
            try {
                WinLotto winLotto = new WinLotto(lotto, bonus);
                isContinue = false;
                return winLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
