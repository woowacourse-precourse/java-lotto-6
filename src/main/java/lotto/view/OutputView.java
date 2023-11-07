package lotto.view;

import lotto.enums.Constants;
import lotto.enums.Messages;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.utils.Order;
import lotto.utils.Split;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printOneLotto(Lotto lotto) {
        List<Integer> numbers = Order.orderNumbers(lotto.getNumbers());
        System.out.println(numbers.toString());
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d%s\n", lottos.size(), Messages.OUTPUT_BUY_MESSAGE.getMessage());
        for (Lotto lotto : lottos) {
            printOneLotto(lotto);
        }
    }

    public static void printAskWinNumbers() {
        System.out.println();
        System.out.println(Messages.INPUT_WINNUMER_MESSAGE.getMessage());
    }

    public static void printAstBonusNumbers() {
        System.out.println();
        System.out.println(Messages.INPUT_BONUSNUMER_MESSAGE.getMessage());
    }

    public static void printStatistics(List<Rank> ranks) {
        int[] rankStatistics = new int[6];
        for (Rank rank : ranks) {
            rankStatistics[rank.getRank()]++;
        }
        System.out.println();
        System.out.println(Messages.LOTTERY_STATISTICS.getMessage());
        System.out.println(Constants.BOUNDARY.getString());
        printStatisticsDetail(rankStatistics);
    }

    public static void printStatisticsDetail(int[] rankStatistics) {
        System.out.printf("%s%d개\n", Messages.WIN_FIFTH_MESSAGE.getMessage(), rankStatistics[5]);
        System.out.printf("%s%d개\n", Messages.WIN_FOURTH_MESSAGE.getMessage(), rankStatistics[4]);
        System.out.printf("%s%d개\n", Messages.WIN_THIRD_MESSAGE.getMessage(), rankStatistics[3]);
        System.out.printf("%s%d개\n", Messages.WIN_SECOND_MESSAGE.getMessage(), rankStatistics[2]);
        System.out.printf("%s%d개\n", Messages.WIN_FIRST_MESSAGE.getMessage(), rankStatistics[1]);
    }

    public static void printReturnRate(float money) {
        System.out.printf("총 수익률은 %.1f%%입니다.", money);
    }
}
