package lotto.controller;

import lotto.constants.MsgConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.service.LottoPurchaseService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public void start() {
        String purchaseAmount = getPurchaseAmount();
        LottoTicket lottoTicket = getLottoTicket(purchaseAmount);
        printPurchasedLottoNumber(lottoTicket);
        String winningNumber = getWinningNumber();


    }

    private String getPurchaseAmount() {
        try{
            OutputView.printEnterPurchaseAmount();
            return InputView.getInputPurchaseAmount();
        }
        catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getPurchaseAmount();
        }

    }
    private LottoTicket getLottoTicket(String purchaseAmount) {
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        return lottoPurchaseService.purchaseLottoTicket(purchaseAmount);
    }

    private void printPurchasedLottoNumber(LottoTicket lottoTicket) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(MsgConstants.PURCHASED_SOME_PIECES.getData(),
                lottoTicket.getPurchaseQuantity()));
        List<Lotto> lottoList = lottoTicket.getLottoList();

        for(Lotto lotto: lottoList) {
            List<Integer> lottoNumber = lotto.getLotto();
            stringBuilder.append("[").append(convertLottoNumToString(lottoNumber)).append("]").append("\n");
        }
        OutputView.printPurchasedLottoNumber(stringBuilder.toString());

    }
    private String convertLottoNumToString(List<Integer> lottoNumber) {
        Collections.sort(lottoNumber);
        return lottoNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private String getWinningNumber() {
        try{
            OutputView.printEnterPurchaseAmount();
            return InputView.getInputPurchaseAmount();
        }
        catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getWinningNumber();
        }
    }
    private String getBonusNumber() {
        try{
            OutputView.printEnterBonusNumber();
            return InputView.getInputBonusNumber();
        }
        catch (Exception ex) {
            OutputView.printErrorMessage(ex.getMessage());
            return getWinningNumber();
        }
    }
}
