package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자가 아닙니다.";

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showMoneyInputMessage();
        int money = toInt(input.readMoney());

        int count = money / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            makeLotto();
        }
    }

    private int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private Lotto makeLotto() {
        return new Lotto(makeLottoNumbers());
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
