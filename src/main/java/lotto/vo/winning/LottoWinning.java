package lotto.vo.winning;

import lotto.Lotto;

public class LottoWinning {
    private static Lotto winningnumber;
    private static int bonusnumber;
    private static long totalwinningprice;

    public static void setWinningnumber(final Lotto winningnumber) {
        LottoWinning.winningnumber = winningnumber;
    }

    public static void setBonusnumber(int bonusnumber) {
        LottoWinning.bonusnumber = bonusnumber;
    }

    public static void setTotalWinningPrice(long totalwinningprice) {
        LottoWinning.totalwinningprice = totalwinningprice;
    }

    public static Lotto GetWinningNumber() {
        return winningnumber;
    }

    public static int GetBonusNumber() {
        return bonusnumber;
    }

    public static long GetTotalWinningPrice() {
        return totalwinningprice;
    }
}
