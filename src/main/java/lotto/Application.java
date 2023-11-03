package lotto;

import java.util.List;
import lotto.Controller.LottoGameController;
import lotto.Model.BonusNumber;
import lotto.Model.Lotto;
import lotto.Model.RandomLottos;
import lotto.Model.LottoMatch;
import lotto.Model.TicketsAmount;
import lotto.View.InputVIew;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.start();
    }
}
