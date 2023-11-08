package lotto;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.view.Input;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController();
            controller.run();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
