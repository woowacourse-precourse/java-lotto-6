package lotto.global.config;

import lotto.domain.game.GameController;
import lotto.domain.game.LottoGame;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.WinningNormalNumbers;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.number.NumberGenerator;
import lotto.domain.number.NumberUtil;
import lotto.global.view.io.LottoInputProcessor;
import lotto.global.view.io.LottoInputView;

public class Dependency {

    public NumberUtil numberUtil() {
        return new NumberGenerator();
    }
    public WinningNormalNumbers winningNormalNumbers() {
        return new WinningNormalNumbers();
    }

    public BonusNumber bonusNumber() {
        return new BonusNumber();
    }

    public WinningNumbers winningNumbers() {
        return new WinningNumbers(winningNormalNumbers(), bonusNumber());
    }

    public LottoInputProcessor lottoInputProcessor() {
        return new LottoInputProcessor(winningNumbers());
    }

    public LottoGame lottoGame() {
        return new LottoGame();
    }

    public LottoInputView lottoInputView() {
        return new LottoInputView(lottoInputProcessor());
    }

    public GameController gameController() {
        return new GameController(lottoInputView(), numberUtil(), lottoGame());
    }
}


