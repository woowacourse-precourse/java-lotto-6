package lotto.domain;

import lotto.domain.inputOutput.input.InputLottoDraw;
import lotto.domain.inputOutput.input.InputLotto;
import lotto.domain.inputOutput.output.LottoOutput;
import lotto.domain.inputOutput.output.WinningOutput;
import lotto.domain.lottoDrawMachine.lottoDraw.LottoDraw;
import lotto.domain.lottoDrawMachine.LottoDrawMachine;
import lotto.domain.vendingMachine.LottoVendingMachine;
import lotto.domain.vendingMachine.lotto.Lotto;
import lotto.domain.winningManager.WinningManager;

import java.util.List;

public class LottoProcess {
    private final LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
    private final LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
    private final WinningManager winningCheck = new WinningManager();
    private final LottoOutput lottoOutput = new LottoOutput();
    private final InputLotto inputLotto = new InputLotto();

    public void run() {
        List<Lotto> lottos = null;
        boolean isCollectMoneyInput = true;
        while (isCollectMoneyInput) {
            try {
                Integer money = inputLotto.inputPayLottoMoney();
                lottos = lottoVendingMachine.buyLotto(money);
                isCollectMoneyInput = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoOutput.displayLottosNumber(lottos);
        LottoDraw lottoDraw = null;
        lottoDraw = lottoDrawMachine.Raffle();
        winningCheck.discrimination(lottos, lottoDraw);
    }
}
