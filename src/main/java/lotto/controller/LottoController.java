package lotto.controller;


import lotto.domain.*;
import lotto.util.Convert;
import lotto.util.ExceptionHandling;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

import java.util.List;

public class LottoController {

    public static List<Integer> winningLotto;
    public static int bonusNumber;


    public void playLotto() {
        LottoTicketStore lottoTicketStore = new LottoTicketStore(getPurchaseAmount());
        OutputMessage.printLottos(lottoTicketStore.getLottos());

        winningLotto = getWinningLotto();
        bonusNumber = getBonusNumber();

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lottoTicketStore.getLottos(), winningLotto, bonusNumber);
        OutputMessage.printLottoResult(lottoResult);

        LottoProfit lottoProfit = new LottoProfit();
        double rate = lottoProfit.calculateProfitRate(lottoResult, lottoTicketStore.getPurchaseAmount());
        OutputMessage.printLottoProfit(rate);
    }

    public int getBonusNumber() {
        try {
            int number = Convert.convertToNumber(InputMessage.RequestBonusNumber());
            ExceptionHandling.isNumberOverRange(List.of(number));
            ExceptionHandling.isSameBonusNumber(winningLotto, number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    public List<Integer> getWinningLotto() {
        try {
            List<Integer> winningLotto = Convert.convertToNumbers(InputMessage.RequestWinningNumber());
            Lotto lotto = new Lotto(winningLotto);
            return lotto.getNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }


    public int getPurchaseAmount() {
        try {
            int purchaseAmount = Convert.convertToNumber(InputMessage.RequestPurchaseAmount());
            ExceptionHandling.isValidPrice(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

}
