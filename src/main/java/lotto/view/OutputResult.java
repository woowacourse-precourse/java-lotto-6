package lotto.view;

public class OutputResult {

    public static void printResult(int[] prizeCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원) - " + prizeCount[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount[1] + "개");
    }

}
