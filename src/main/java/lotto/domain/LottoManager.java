package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.ConsoleInput;
import lotto.ui.ConsoleOutput;
import lotto.ui.Input;
import lotto.ui.Output;

public class LottoManager {
    private Input input;
    private Output output;

    public LottoManager() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
    }

    public List<Lotto> buyLotto() {
        int price = getPrice();

        return new ArrayList<>();
    }

    private int getPrice() {
        output.printLottoPriceRequest();
        return input.getPrice();
    }
}
