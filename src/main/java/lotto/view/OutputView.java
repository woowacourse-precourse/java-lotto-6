package lotto.view;

import lotto.domain.Lotto;
import lotto.utils.MessageConstant;

import java.util.List;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(MessageConstant.LOTTO_COUNT + "%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(MessageConstant.RESULT);
    }

    public static void printCount(String message, int count) {
        System.out.printf(message + MessageConstant.COUNT + "%n", count);
    }

    public static void printRateOfReturn(double rate) {
        System.out.printf((MessageConstant.RATE_OF_RETURN) + "%n", rate);
    }
}
