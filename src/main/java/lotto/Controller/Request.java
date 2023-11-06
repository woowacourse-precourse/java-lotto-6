package lotto.Controller;

import lotto.Lotto;
import lotto.fixeddata.Text;
import lotto.vo.buy.LottoBuy;
import lotto.vo.winning.LottoWinning;
import lotto.service.generator.TextNumberConvert;
import lotto.util.io.input.Input;
import lotto.util.io.input.Keyboard;
import lotto.util.io.output.viewer.UserScreen;
import lotto.util.io.output.viewer.Viewer;

public class Request {
    Input input = new Keyboard();
    Viewer output = new UserScreen();

    private long MoneyInputConversion(String input) {
        return TextNumberConvert.MoneyConvert(input);
    }

    private void MoneyInputMultipleRead() {
        output.ViewPrint(Text.BUY_REQUEST);
        LottoBuy.SetBuyMoney(MoneyInputConversion(input.GetData()));
    }

    public void RequestBuyMoney() {
        try {
            MoneyInputMultipleRead();
        } catch (IllegalArgumentException e) {
            output.ViewPrint(e.getMessage());
            RequestBuyMoney();
        }
        LottoBuy.SetlottoIssuanceNumber(LottoBuy.GetBuyMoney() / 1000);
    }

    private Lotto WinningNumberInputConversion(String input) {
        Lotto data = TextNumberConvert.WinnerNumberConvert(input);
        return data;
    }

    private void WinningNumberMultipleRead() {
        output.ViewPrint(Text.WINNER_NUMBER_REQUEST);
        LottoWinning.setWinningnumber(WinningNumberInputConversion(input.GetData()));
    }

    private void RequestLottoWinningNumber() {
        try {
            WinningNumberMultipleRead();
        } catch (IllegalArgumentException e) {
            output.ViewPrint(e.getMessage());        //EEROR화면 띄우는 곳.
            RequestLottoWinningNumber();
        }
    }

    private int BonusNumberInputConversion(String input) {
        int data = TextNumberConvert.BonusNumberConversion(input);
        return data;
    }

    private void BonusNumberMultipleRead() {
        output.ViewPrint(Text.BONUS_NUMBER_REQUEST);
        LottoWinning.setBonusnumber(BonusNumberInputConversion(input.GetData()));
    }

    private void RequestLottoBonusNumber() {
        try {
            BonusNumberMultipleRead();
        } catch (IllegalArgumentException e) {
            output.ViewPrint(e.getMessage());        //EEROR화면 띄우는 곳.
            BonusNumberMultipleRead();
        }
    }

    public void RequestSetWinningNumber() {
        RequestLottoWinningNumber();
        RequestLottoBonusNumber();
    }
}
