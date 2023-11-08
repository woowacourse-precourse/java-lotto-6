package lotto.utils;

import lotto.Lotto;
import lotto.Result;
import lotto.enums.MessageType;
import lotto.enums.ResultType;

public class OutputUtils {

    private static final String BOUGHT_NUMBER_MSG = "개를 구매했습니다.";

    public static void printBasicMessage(MessageType messageType){
        System.out.println(messageType.getMsg());
    }
    public static void printLottos(Lotto[] lottos, int numberOfLottos) {
        System.out.println(String.format("%d%s", numberOfLottos, BOUGHT_NUMBER_MSG));
        for(Lotto l : lottos){
            System.out.println(l.getNumbers());
        }
    }

    public static void printResult(Result result) {
        System.out.print(buildResultMessage(ResultType.FIFTH, result.getFifth()));
        System.out.print(buildResultMessage(ResultType.FOURTH, result.getForth()));
        System.out.print(buildResultMessage(ResultType.THIRD, result.getThird()));
        System.out.print(buildResultMessage(ResultType.SECOND, result.getSecond()));
        System.out.print(buildResultMessage(ResultType.FIRST, result.getFirst()));

    }

    public static void printGain(Result result, int amount) {
        int totalGain = 0;
        totalGain += calculateGain(ResultType.FIFTH, result.getFifth());
        totalGain += calculateGain(ResultType.FOURTH, result.getForth());
        totalGain += calculateGain(ResultType.THIRD, result.getThird());
        totalGain += calculateGain(ResultType.SECOND, result.getSecond());
        totalGain += calculateGain(ResultType.FIRST, result.getFirst());

        double totalGainPercent = calculateGainPercent(totalGain, amount);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", totalGainPercent));
    }

    private static String buildResultMessage(ResultType type, int count) {
        StringBuilder result = new StringBuilder();
        result.append(type.getMsg()).append(" - ").append(count).append("개").append("\n");

        return result.toString();
    }

    private static int calculateGain(ResultType type, int count) {
        return type.getPrize() * count;
    }

    private static double calculateGainPercent(int totalGain, int amount) {
        return (100.0) * totalGain / amount;
    }

}
