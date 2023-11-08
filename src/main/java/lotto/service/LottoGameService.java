package lotto.service;

import lotto.config.MoneyException;
import lotto.domain.Money;
import lotto.view.LottoGameView;

import static lotto.controller.LottoGameController.player;

public class LottoGameService {
    public static int inputPlayerMoney(){
        try {
            Money money = new Money(LottoGameView.inputMoney());
            return money.money;
        }
        catch (IllegalArgumentException e){
            System.out.println(MoneyException.ERROR_MESSAGE);
            return inputPlayerMoney();
        }
    }

    public static void printDisplayPlayerLotto(){
        player.createLotto(player.lottoTicketNum);
        System.out.printf("%d개를 구매했습니다.", player.lottoTicketNum);
        System.out.println();
        player.displayLotto();
    }

    public static void printDisplayGameResult(){
        player.countInRankingEachRank();
        player.printWinningScore();
        player.printProfit();
    }


}
