package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class Output {

    private static int first = 0;
    private static int second = 0;
    private static int third = 0;
    private static int fourth = 0;
    private static int fifth = 0;

    public static void printbuyLottos(int wallet) {

        wallet /= 1000;
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

        if (correctCount == 3) {

            fifth++;
        } else if (correctCount == 4) {

            fourth++;
        } else if (correctCount == 5) {

            third++;
        } else if (correctCount == 5 && correctBonus == 1) {

            second++;
        } else if (correctCount == 6) {

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
        reward += fifth * 5000;
        reward += fourth * 50000;
        reward += third * 1_500_000;
        reward += first * 2_000_000_000;

        double rate = customer.calculateRateOfReturn(reward);

        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String formattedNumber = decimalFormat.format(rate);

        System.out.println("총 수익률은 " + formattedNumber + "%입니다.");
    }
}
