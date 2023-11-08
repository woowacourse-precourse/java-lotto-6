package lotto;

import lotto.Controller.LottoController;
import lotto.Model.CalculateWinning;
import lotto.Model.User;
import lotto.View.LottoView;

public class Application {
    public static void main(String[] args) {

       User user = new User();
        LottoView view = new LottoView();
        CalculateWinning calculateWinning = new CalculateWinning();
        LottoController control = new LottoController(user,view,calculateWinning);
        control.lottoGame();
    }
}
