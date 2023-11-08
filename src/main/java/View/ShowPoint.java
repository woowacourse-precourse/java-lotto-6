package View;

import java.util.List;

enum PRINT_MESSAGE {
    MATCH3("3개 일치 (5,000원) - "),
    MATCH4("4개 일치 (50,000원) - "),
    MATCH5("5개 일치 (1,500,000원) - "),
    MATCH5B("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH6("6개 일치 (2,000,000,000원) - "),
    END_TAG("개"),
    TOTAL_EARNING("총 수익률은 "),
    EARNING_END_TAG("%입니다.");
    private final String label;

    PRINT_MESSAGE(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}

public class ShowPoint {
    public static double totalMoney = 0;

    private void ShowPoint() {

    }

    public static double showPointsInRow(List<Integer> point) {
        System.out.printf("%s%d%s\n", PRINT_MESSAGE.MATCH3.label(), point.get(0), PRINT_MESSAGE.END_TAG.label());
        totalMoney = point.get(0) * 5000;
        System.out.printf("%s%d%s\n", PRINT_MESSAGE.MATCH4.label(), point.get(1), PRINT_MESSAGE.END_TAG.label());
        totalMoney = totalMoney + point.get(1) * 50000;
        System.out.printf("%s%d%s\n", PRINT_MESSAGE.MATCH5.label(), point.get(2), PRINT_MESSAGE.END_TAG.label());
        totalMoney = totalMoney + point.get(2) * 1500000;
        System.out.printf("%s%d%s\n", PRINT_MESSAGE.MATCH5B.label(), point.get(3), PRINT_MESSAGE.END_TAG.label());
        totalMoney = totalMoney + point.get(3) * 30000000;
        System.out.printf("%s%d%s\n", PRINT_MESSAGE.MATCH6.label(), point.get(4), PRINT_MESSAGE.END_TAG.label());
        totalMoney = totalMoney + point.get(4) * 2000000000;
        return (double)totalMoney;
    }
    public static String showEarningRate(double price, double totalMoney){
        String result = String.format("%.2f",(double)totalMoney/price);
        System.out.printf("%s%s%s\n", PRINT_MESSAGE.TOTAL_EARNING.label(),result,PRINT_MESSAGE.EARNING_END_TAG.label());
        return result;
    }

}

