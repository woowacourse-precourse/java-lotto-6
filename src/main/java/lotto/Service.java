package lotto;

public class Service {

    static long calculateTotalPrizeMoney() {
        long totalPrizeMoney = CompareWinnerNum.Match_3_Count * 5000L + CompareWinnerNum.Match_4_Count * 50000L
                + CompareWinnerNum.Match_5_Count * 1500000L
                + CompareWinnerNum.Match_5_AndBonusCount * 30000000L + CompareWinnerNum.Match_6_Count * 2000000000L;
        return totalPrizeMoney;
    }

    static void printProfitability() {

    }
}
