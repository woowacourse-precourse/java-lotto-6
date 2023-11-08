package lotto.controller;

import lotto.Util.Validate;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static PlayerBuyLotto playerBuyLotto;
    private static List<Lotto> lottoTickets;
    private static List<Integer> lotto = new ArrayList<>();
    private static WinningCheck winningCheck;

    public LottoController() {
    }

    public void startLotto() {
        InputView.inputPlayerPayMessage();
        int lottoTicketCount = inputPlayerBuyLotto();
        System.out.println();

        OutputView.printBuyLottoCount(lottoTicketCount);
        lottoTickets = makeLottoTickets(lottoTicketCount);
        System.out.println();

        winningCheck = bonusNum(winningNum());
        System.out.println();

        OutputView.printWinningResult();
        lottoResult(lottoTickets, winningCheck, lottoTicketCount);
    }

    public int inputPlayerBuyLotto() {
        while(true){
            try {
                playerBuyLotto = new PlayerBuyLotto(InputView.inputPlayerPay());
                return playerBuyLotto.calcLottoCount();
            }catch (IllegalArgumentException e){
                System.out.print("");
            }
        }
    }

    private static List<Lotto> makeLottoTickets(int ticketCount) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(makeLotto());
        }
        return lottoTickets;
    }

    private static Lotto makeLotto() {
        lotto = Lottos.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public static List<Integer> winningNum(){
        InputView.inputLottoWinningNumMessage();
        while (true){
            try {
                Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
                List<Integer> winningNumber = lotto.getLottoNumbers();
                return winningNumber;
            }catch (IllegalArgumentException e){
                System.out.print("");
            }
        }
    }

    public static WinningCheck bonusNum(List<Integer> winningNumber){
        System.out.println();
        InputView.inputBonusNumberMessage();
        while (true){
            try {
                int ball = InputView.inputBonusNumber();
                Validate.validateBonusNum(winningNumber, ball);
                winningCheck = new WinningCheck(new Lotto(winningNumber), ball);
                return winningCheck;
            }catch (IllegalArgumentException e){
                System.out.print("");
            }
        }
    }

    private void lottoResult(List<Lotto> lottoTickets, WinningCheck winningNumAndBonusNum, int lottoTicketCount) {
        Map<RankingLotto, Integer> result = setResult();
        RankingLotto rank;

        for (int i = 0; i < lottoTickets.size(); i++) {
            rank = winningNumAndBonusNum.match(lottoTickets.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, lottoTicketCount);
    }

    private Map<RankingLotto, Integer> setResult() {
        Map<RankingLotto, Integer> result = new LinkedHashMap<>();

        for (RankingLotto rank : RankingLotto.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private void printResult(Map<RankingLotto, Integer> result) {
        for (int i = RankingLotto.values().length - 1; i >= 0; i--) {
//            System.out.println(RankingLotto.values()[i]);
            if(RankingLotto.values()[i] != RankingLotto.EMPTY){
                OutputView.printWinningMessage(RankingLotto.values()[i].getMessage(), result.get(RankingLotto.values()[i]));
            }
        }
    }

    private void printEarningRate(Map<RankingLotto, Integer> result, int lottoTicketCount) {
        double revenueRate = 0;
        for (RankingLotto rank : result.keySet()) {
            revenueRate =
                    revenueRate + ((double) (rank.getPrizeMoney()) / (lottoTicketCount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));
        }
        OutputView.printRevenueRate(revenueRate);
    }
}