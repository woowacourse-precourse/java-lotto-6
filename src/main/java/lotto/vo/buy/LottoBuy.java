package lotto.vo.buy;

public class LottoBuy {
    private static long buymoney = 0;
    private static long lottoIssuanceNumber = 0;

    public LottoBuy(long buyMoney, long lottoissuancenumber) {
        buymoney = buyMoney;
        lottoIssuanceNumber = lottoissuancenumber;
    }

    public static void SetBuyMoney(long money) {
        buymoney = money;
    }

    public static void SetlottoIssuanceNumber(long IssuanceNumber) {
        lottoIssuanceNumber = IssuanceNumber;
    }

    public static long GetBuyMoney() {
        return buymoney;
    }

    public static long GetLottoIssuanceNumber() {
        return lottoIssuanceNumber;
    }
}
