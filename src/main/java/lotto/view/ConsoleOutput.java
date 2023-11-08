package lotto.view;

import lotto.Lotto;
import lotto.model.Model;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput {
    public static void buyInfoMessage() {
        System.out.println(InfoMessage.BUY.getMessage());
    }

    public static void howMuchLottoMessage(int number) {
        System.out.println(number + InfoMessage.HOW_MUCH.getMessage());
    }

    public static void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lottos);
        }
    }

    public static void winningNumberInfoMessage() {
        System.out.println(InfoMessage.WINNING_NUM.getMessage());
    }

    public static void bonusNumberInfoMessage() {
        System.out.println(InfoMessage.BONUS_NUM.getMessage());
    }

    public static void resultMessage(Model model) {
        System.out.println(InfoMessage.INFO_RESULT.getMessage());
        System.out.println(InfoMessage.RESULT_5.getMessage() + model.getFifth());
        System.out.println(InfoMessage.RESULT_4.getMessage() + model.getFourth());
        System.out.println(InfoMessage.RESULT_3.getMessage() + model.getThird());
        System.out.println(InfoMessage.RESULT_2.getMessage() + model.getSecond());
        System.out.println(InfoMessage.RESULT_1.getMessage() + model.getFirst());
        System.out.println(InfoMessage.EARNING_RATE.getMessage());
    }
}
