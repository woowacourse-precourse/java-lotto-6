package lotto.view;

import lotto.Model.Lotto;

import java.util.List;

public class OutputView {
    private final String MSG_STATUS = "\n당첨 통계\n---";
    private final String MSG_DIVIDER = "---";
    private final String MSG_TOTAL_PREFIX = "총 수익률은 %.1f%%입니다.";
    private final  String MSG_TICKET_COUNT = "%d개를 구매했습니다.";

    public void printPurchaseTicket(int ticket){
        System.out.println(ticket+MSG_TICKET_COUNT);
    }

    public void printLottonPublish(List<Lotto> publishedLotto){
        publishedLotto.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
    public void printStatusMessage(){
        System.out.println(MSG_STATUS);
    }

    public void printTotalPrefix(float result){
        System.out.println(result + MSG_TOTAL_PREFIX);
    }

}
