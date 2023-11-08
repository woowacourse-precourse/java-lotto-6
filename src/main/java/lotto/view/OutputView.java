package lotto.view;

import lotto.Model.Lotto;
import lotto.Model.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private final String MSG_STATUS = "당첨 통계---";
    private final String MSG_DIVIDER = "---";
    private final String MSG_TOTAL_PREFIX = "총 수익률은 %s%%입니다.";
    private final  String MSG_TICKET_COUNT = "%d개를 구매했습니다.";

    public void printPurchaseTicket(int ticket,List<Lotto> lottoPublished){
        System.out.printf(MSG_TICKET_COUNT,ticket);
        printLottonPublish(lottoPublished);
        System.out.println();
    }

    public void printLottonPublish(List<Lotto> publishedLotto){
        publishedLotto.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
    public void printWinningCount(HashMap<Rank, Integer> winningCount){
        System.out.println();
        System.out.println(MSG_STATUS);
        for (Rank print : Rank.getRanks()){
            System.out.println(print.getWinningMessage(winningCount.get(print)));
        }
    }

    public void printTotalPrefix(String result){
        System.out.printf(MSG_TOTAL_PREFIX,result);
    }

}
