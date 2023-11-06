package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lotto.Controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView());
        lottoController.start();
    }
}
