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
    private LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
    private LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
    private WinningManager winningCheck = new WinningManager();
    private LottoOutput lottoOutput = new LottoOutput();
    private InputLotto inputLotto = new InputLotto();
    private WinningOutput winningOutput = new WinningOutput();
    private InputLottoDraw inputLottoDraw = new InputLottoDraw();

    public void run(){
        Integer money = inputLotto.inputPayLottoMoney();

        List<Lotto> lottos = lottoVendingMachine.buyLotto(money);
        lottoOutput.displayLottosNumber(lottos);

        LottoDraw lottoDraw = lottoDrawMachine.Raffle();

        winningCheck.discrimination(lottos, lottoDraw);

    }
}
