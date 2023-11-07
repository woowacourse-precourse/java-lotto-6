package lotto.output;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoResultOutput {

    public static final String WIN_RESULT_START = "\n당첨 통계\n---\n";
    public static final LinkedHashMap<Integer, String> PRIZE_MONEY = new LinkedHashMap<>();

    static {
        PRIZE_MONEY.put(3, "5,000원");
        PRIZE_MONEY.put(4, "50,000원");
        PRIZE_MONEY.put(5, "1,500,000원");
        PRIZE_MONEY.put(6, "30,000,000원");
        PRIZE_MONEY.put(7, "2,000,000,000원");
    }


    public static String[] lottoOutput(List<Integer> winnings) {
        System.out.print(WIN_RESULT_START);
        String[] results = new String[5];
        int index = 0;
        for (int count : winnings) {
            int matchedNumbers = index + 3;
            String prize = getPrize(matchedNumbers);
            results[index] = getMoneyMessage(matchedNumbers, prize, count);
            index++;
        }
        return results;
    }

    public static void printResult(List<Integer> winnings) {
        String[] result = lottoOutput(winnings);
        for (String line : result) {
            System.out.println(line);
        }
    }

    public static String getMoneyMessage(int matchedNumbers, String prize, int count) {
        if (matchedNumbers == 6) {
            String message = "5개 일치, 보너스 볼 일치 (" + prize + ") - " + count + "개";
            return message;
        } else if (matchedNumbers == 7) {
            String message = "6개 일치 (" + prize + ") - " + count + "개";
            return message;
        }

        String message = matchedNumbers + "개 일치 (" + prize + ") - " + count + "개";
        return message;
    }

    protected static String getPrize(int matchedNumbers) {
        return PRIZE_MONEY.get(matchedNumbers);
    }
}
