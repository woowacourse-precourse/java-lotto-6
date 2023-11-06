package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class Output {

    private static int first = 0;
    private static int second = 0;
    private static int third = 0;
    private static int fourth = 0;
    private static int fifth = 0;

    private static final int LOTTOPRICE = 1000;
    private static final int FIRSTNUM = 6;
    private static final int SECONDNUM = 5;
    private static final int THIRDNUM = 5;
    private static final int FOURTHNUM = 4;
    private static final int FIFTHNUM = 3;
    private static final int BONUSNNUM = 1;

    public static void printbuyLottos(int wallet) {

        wallet /= LOTTOPRICE;
        System.out.println(wallet + "개를 구매했습니다.");
    }

    public static void printCustomerLottos(List<Integer> numbers) {

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {

            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {

                sb.append(", ");
            }
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void countRank(int correctCount, int correctBonus) {

        if (correctCount == FIFTHNUM) {

            fifth++;
        } else if (correctCount == FOURTHNUM) {

            fourth++;
        } else if (correctCount == THIRDNUM) {

            third++;
        } else if (correctCount == SECONDNUM && correctBonus == BONUSNNUM) {

            second++;
        } else if (correctCount == FIRSTNUM) {

            first++;
        }
    }

    public static void printResult() {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
    }

    public static void printRateOfReturn(Customer customer) {

        double reward = 0;
        reward += fifth * Prize.FIFTH.getPrizeAmount();
        reward += fourth * Prize.FOURTH.getPrizeAmount();
        reward += third * Prize.THIRD.getPrizeAmount();
        reward += second * Prize.SECOND.getPrizeAmount();
        reward += first * Prize.FIRST.getPrizeAmount();

        double rate = customer.calculateRateOfReturn(reward);

        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String formattedNumber = decimalFormat.format(rate);

        System.out.println("총 수익률은 " + formattedNumber + "%입니다.");
    }
}
