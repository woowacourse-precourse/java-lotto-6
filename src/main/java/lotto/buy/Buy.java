package lotto.buy;

import lotto.util.io.input.Input;
import lotto.util.io.input.Keyboard;
import lotto.util.io.output.viewer.UserScreen;
import lotto.util.io.output.viewer.Viewer;
import lotto.fixeddata.Text;

public class Buy {
    private static long buymoney = 0;
    private long lottoIssuanceNumber = 0;

    Input input = new Keyboard();
    Viewer output = new UserScreen();

    public Buy(long buyMoney, long lottoIssuanceNumber) {
        buymoney = buyMoney;
        this.lottoIssuanceNumber = lottoIssuanceNumber;
    }

    private void MultipleRead() {
        output.ViewPrint(Text.BUY_REQUEST);
        buymoney = MoneyInputConversion(input.GetData());
    }

    public void RequestBuyMoney() {
        try {
            MultipleRead();
        } catch (IllegalArgumentException e) {
            output.ViewPrint(e.getMessage());        //EEROR화면 띄우는 곳.
            RequestBuyMoney();
        }
        lottoIssuanceNumber = buymoney / 1000;
    }

    private long MoneyInputConversion(String input) {
//        long data = TextNumberConvert.MoneyConvert(input);
        return 0L;//data로 수정 예정.
    }

    public void SetBuyMoney(long money) {
        buymoney = money;
    }

    public void SetlottoIssuanceNumber(long IssuanceNumber) {
        lottoIssuanceNumber = IssuanceNumber;
    }

    public static long GetBuyMoney() {
        return buymoney;
    }

    public long GetLottoIssuanceNumber() {
        return lottoIssuanceNumber;
    }

    public void PrintLottoIssuanceNumber() {
        long IssuanceNumber = GetLottoIssuanceNumber();
        output.ViewPrint(IssuanceNumber + Text.BUY_NUMBER);
    }
}
