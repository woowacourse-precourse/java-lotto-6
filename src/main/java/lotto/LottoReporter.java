package lotto;

public class LottoReporter {
    public static void printPrize(int count, long prize, int place) {
        System.out.printf("%d개 일치 (%s원) - %d개%n", place, formatPrize(prize), count);
    }

    private static String formatPrize(long prize) {
        return String.format("%,d", prize);
    }

    // 당첨 통계를 출력하는 메서드
    public static void lottoReport(int firstPlaceCount, int secondPlaceCount, int thirdPlaceCount, int fourthPlaceCount, int fifthPlaceCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printPrize(fifthPlaceCount, Lotto.FIFTH_PRIZE_AMOUNT, 3);
        printPrize(fourthPlaceCount, Lotto.FOURTH_PRIZE_AMOUNT, 4);
        printPrize(thirdPlaceCount, Lotto.THIRD_PRIZE_AMOUNT, 5);
//        printPrize(secondPlaceCount, Lotto.SECOND_PRIZE_AMOUNT, 5); // 보너스 볼은 다른 방식으로 표현해야 할 수 있음
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPlaceCount + "개");
        printPrize(firstPlaceCount, Lotto.FIRST_PRIZE_AMOUNT, 6);
    }

    public static void rateOfReturn(double totalReward, int money) {
        double result = Math.max(totalReward - money, 0);
        result = (result / money) * 100;
        result = Math.round(result*10)/10.0;
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}
