package lotto;

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

    public static void countRank(int correctCount) {

        if (correctCount == 3) {

            fifth++;
        } else if (correctCount == 4) {

            fourth++;
        } else if (correctCount == 5) {

            third++;
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
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
    }

    public static void printRateOfReturn() {

    }
}
