package lotto.view;

import lotto.config.Message;
import lotto.config.ConstNum;
import lotto.domain.LottoTickets;
import lotto.domain.Result;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static DecimalFormat df = new DecimalFormat("#,###");
    private static DecimalFormat rf = new DecimalFormat("#,##0.0");
    public static void moneyMessage() {
        printView(Message.MONEY.getMessage());
    }

    public static void buyComplete(Integer money) {
        String s = String.format("\n%d개를 구매했습니다.", money / ConstNum.PRICE.getNum());
        printView(s);
    }

    public static void printLotto(LottoTickets lottoTickets) {
        List<String> tickets = lottoTickets.getTickets();

        for (String ticket : tickets) {
            printView(ticket);
        }
    }

    public static void winningMessage() {
        printView(Message.WINNING_NUM.getMessage());
    }

    public static void bonusMessage() {
        printView(Message.BONUS_NUM.getMessage());
    }

    public static void resultMessage(Result result,Integer money) {
        printView(Message.RESULT.getMessage());

        printView(String.format("%d개 일치 (%s원) - %d개",3,df.format(ConstNum.FIFTH_PRIZE.getNum()),result.getCount(5)));
        printView(String.format("%d개 일치 (%s원) - %d개",4,df.format(ConstNum.FOURTH_PRIZE.getNum()),result.getCount(4)));
        printView(String.format("%d개 일치 (%s원) - %d개",5,df.format(ConstNum.THIRD_PRIZE.getNum()),result.getCount(3)));
        printView(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", 5, df.format(ConstNum.SECOND_PRIZE.getNum()), result.getCount(2)));
        printView(String.format("%d개 일치 (%s원) - %d개",6,df.format(ConstNum.FIRST_PRIZE.getNum()),result.getCount(1)));

        printView(String.format("총 수익률은 %s%%입니다.", rf.format(result.getProfitPercentage(money))));
    }
    public static void errorMessage(String message) {
        printView(String.format("[ERROR] %s",message));
    }

    private static void printView(String s) {
        System.out.println(s);
    }
}
