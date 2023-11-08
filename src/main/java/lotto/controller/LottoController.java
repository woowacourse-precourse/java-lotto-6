package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashMap;

public class LottoController {

    public void run() {
        Money money = purchaseLotto();
        LottoTicket lottoTicket = createLottoTicket(money);
        printLottoList(lottoTicket);
        WinningLotto winningLotto = createWinningLottoTicket();
        setBonusNumber(winningLotto);
        printLottoResult(lottoTicket, winningLotto, money.getPurchasePrice());
    }

    private void printTotalReturn(double totalPrize, int money) {
        double totalReturn = (totalPrize / money) * 100;
        Output.getFormatOfTotalReturn(totalReturn);
    }

    private void printLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto, int money) {
        HashMap<Rank, Integer> result = new HashMap<>();
        LottoCalculator lottoCalculator = new LottoCalculator();
        result = lottoCalculator.crateResult(lottoTicket, winningLotto);
        Output.getMessageOfResult(result);
        printTotalReturn(lottoCalculator.getTotalPrize(), money);
    }

    private void setBonusNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                Output.getMessageOfInputBonusNumber();
                winningLotto.setBonusNumber(Input.getBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                Output.getErrorMessage(e);
            }
        }
    }

    private WinningLotto createWinningLottoTicket() {
        while (true) {
            try {
                LottoBuilder lottoBuilder = new LottoBuilder();
                Output.getMessageOfInputWinningNumber();
                return new WinningLotto(lottoBuilder.createWinningLotto(Input.getWinningNumber()));
            } catch (IllegalArgumentException e) {
                Output.getErrorMessage(e);
            }
        }
    }

    private void printLottoList(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottoList()) {
            Output.printLottoList(lotto);
        }
    }

    private LottoTicket createLottoTicket(Money money) {
        LottoBuilder lottoBuilder = new LottoBuilder();
        return lottoBuilder.createLotto(money);
    }

    private Money purchaseLotto() {
        while (true) {
            try {
                Output.getMessageOfPurchaseLotto();
                Money money = new Money(Input.getPurchaseMoney());
                Output.getFormatOfPurchaseMessage(money.getLottoCount());

                return money;
            } catch (IllegalArgumentException e) {
                Output.getErrorMessage(e);
            }
        }
    }
}
