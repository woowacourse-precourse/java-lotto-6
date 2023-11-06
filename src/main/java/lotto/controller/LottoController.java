package lotto.controller;

import lotto.domain.Lotto;
import lotto.util.MakeLotto;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private InputController inputController = new InputController();
    private MakeLotto makeLotto = new MakeLotto();

    public LottoController(){
        int lottoTickets = getLottoTickets();
        List<Lotto> lottoList = makeLotto.makeLottoList(lottoTickets);
        List<Integer> winningNum = getWinningNum();
        int bonusNum = getBounsNum();
    }

    public int getLottoTickets(){
        OutputView.inputBuyMessage();
        return inputController.inputMoney();
    }

    public List<Integer> getWinningNum(){
        OutputView.printBlank();
        OutputView.inputWinningNumMessage();
        return inputController.inputWinningNum();
    }

    public int getBounsNum(){
        OutputView.printBlank();
        OutputView.inputBonusNumMessage();
        return inputController.inputBonusNum();
    }
}
