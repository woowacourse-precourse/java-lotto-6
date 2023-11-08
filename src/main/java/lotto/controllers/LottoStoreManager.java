package lotto.controllers;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoNumberMatcher;
import lotto.views.LottoView;

import java.util.ArrayList;

import static lotto.controllers.LottoNumberChecker.LotteryResult;
import static lotto.controllers.LottoNumberChecker.comparisonMyLottoNumberAndWinningNumber;
import static lotto.model.InputValidator.*;
import static lotto.model.Utilities.divide;
import static lotto.model.Utilities.inputIntegerParsing;
import static lotto.views.MessageManager.*;

public class LottoStoreManager {
    private String inputAmount;
    private final double LOTTO_PRICE = 1000;
    private static int lottoTicketCount;

    LottoView view = new LottoView();
    LottoNumberMatcher model = new LottoNumberMatcher();

    private ArrayList<Lotto> myLottoTicket = new ArrayList<>();

    public LottoStoreManager (){
        getPurchaseAmountPromptMessage();
        purchaseAmount();
        myLottoTicket=lottoMachine().getLottoTickets();
        System.out.println();

        view.lottoTicketCountView(lottoTicketCount);
        displayLottoTicketsNumber(myLottoTicket);

        System.out.println();
        getLottoNumberPromptMessage();
        new DongHangLottery();

        comparisonMyLottoNumberAndWinningNumber(myLottoTicket);

        LotteryResult();
        view.showRateOfReturn(model.calculateRateOfReturn(inputIntegerParsing(inputAmount)));
    }
    public void purchaseAmount() {
        inputAmount = InputProcessor.readLine();

        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                validatePurchaseAmount(inputAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                inputAmount = InputProcessor.readLine();
                attempts++;
            }
        }

        if (attempts == maxAttempts) {
            getProgramClosePromoptMessage();
        }
        lottoTicketCount = (int) divide(Double.parseDouble(inputAmount), LOTTO_PRICE);
    }

    public static LottoGenerator lottoMachine() {
        return new LottoGenerator(lottoTicketCount);
    }

    public void displayLottoTicketsNumber(ArrayList<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

}
