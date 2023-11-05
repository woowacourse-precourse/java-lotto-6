package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.service.Lotto;
import lotto.service.PlayerLottoAmount;
import lotto.service.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;


    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = validateBonus();

        lottoResult(lottoList, winningResult, ticketCount);

    }

    public int inputPlayerAmount() {
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calculateLottoCount();
    }

}


