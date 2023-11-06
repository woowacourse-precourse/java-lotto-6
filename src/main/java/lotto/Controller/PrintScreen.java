package lotto.Controller;

import lotto.Lotto;
import lotto.fixeddata.Text;
import lotto.vo.buy.LottoBuy;
import lotto.vo.issuanced.LottosNumber;
import lotto.util.io.output.viewer.UserScreen;
import lotto.util.io.output.viewer.Viewer;

public class PrintScreen {
    Viewer output = new UserScreen();

    public void PrintLottoIssuanceNumber() {
        long IssuanceNumber = LottoBuy.GetLottoIssuanceNumber();
        output.ViewPrint(IssuanceNumber + Text.BUY_NUMBER);
    }

    public void PrintLottoIssuance() {
        for (Lotto lotto : LottosNumber.GetLottos()) {
            output.ViewPrint(lotto.GetLotto());
        }
        output.ViewPrint();
    }

    public void StartPrintWinningStatistics() {
        output.ViewPrint(Text.LOTTO_WINNING_STATICSTICS);
        output.ViewPrint(Text.HORIZON);
    }

    public void ShowRateofReturn(double rateofreturn) {
        output.ViewPrint(
                Text.RATE_OF_RETURN_OPENING + String.format("%.1f", rateofreturn) + Text.RATE_OF_RETURN_ENDING);
    }
}
