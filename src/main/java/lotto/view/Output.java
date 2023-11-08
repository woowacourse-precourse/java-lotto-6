package lotto.view;

public class Output {
    public void showResult(int[] result) {
        System.out.println("3개 일치 (5,000원) - " + result[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[6] + "개");
    }

    public void showRevenue(int[] result, int cash) {
        int revenue = (5000 * result[3]) + (50000 * result[4]) + (1500000 * result[5])
                + (30000000 * result[7]) + (2000000000 * result[6]);
        double value = (revenue / (double) cash) * 100;

        System.out.println("총 수익률은 " + String.format("%.2f%%", value) + "%입니다.");
    }
}
