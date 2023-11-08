package lotto.service;

import lotto.constant.Message.OutputMessage;
import lotto.constant.Message.WinningStatusMessage;
import lotto.constant.Sign;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputService {
    public void printLottos(Lottos lottos, Buyer buyer) {
        String message = String.format(OutputMessage.SHOW_PURCHASED_LOTTO_NUMBER.getOutputMessage(), buyer.getNumberOfLotto());
        System.out.println(message);
        ArrayList<Lotto> allLottos = lottos.getLottos();
        for (int i = 0; i < allLottos.size(); i++) {
            System.out.println(allLottos.get(i));
        }
        System.out.print(Sign.LINE_BREAKER.getSign());
    }

    public void printFinalResult(HashMap<String,Integer> winningPrize, float totalReturn) {
        System.out.println(WinningStatusMessage.WINNING_STATUS_MESSAGE.getWinningStatusMessage());
        System.out.println(Sign.DIVIDER.getSign());
        System.out.println(String.format(WinningStatusMessage.FIFTH_PRIZE_STATUS_MESSAGE.getWinningStatusMessage(), winningPrize.get("1")));
        System.out.println(String.format(WinningStatusMessage.SECOND_PRIZE_STATUS_MESSAGE.getWinningStatusMessage(), winningPrize.get("2")));
        System.out.println(String.format(WinningStatusMessage.THIRD_PRIZE_STATUS_MESSAGE.getWinningStatusMessage(), winningPrize.get("3")));
        System.out.println(String.format(WinningStatusMessage.FOURTH_PRIZE_STATUS_MESSAGE.getWinningStatusMessage(), winningPrize.get("4")));
        System.out.println(String.format(WinningStatusMessage.FIFTH_PRIZE_STATUS_MESSAGE.getWinningStatusMessage(), winningPrize.get("5")));
        System.out.println(String.format(WinningStatusMessage.TOTAL_RETURN_MESSAGE.getWinningStatusMessage(), winningPrize.get("5")));
    }
}
