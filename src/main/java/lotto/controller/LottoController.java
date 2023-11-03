package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showMoneyInputMessage();
        input.readMoney();

        makeLottoNumbers();
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
