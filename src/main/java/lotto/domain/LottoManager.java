package lotto.domain;

import java.util.List;
import lotto.ui.ConsoleInput;
import lotto.ui.ConsoleOutput;
import lotto.ui.Input;
import lotto.ui.Output;

public class LottoManager {
    private Input input;
    private Output output;
    private LottoGenerator lottoGenerator;

    public LottoManager() {
        this(new ConsoleInput(), new ConsoleOutput(), new LottoGenerator());
    }

    public LottoManager(Input input, Output output, LottoGenerator lottoGenerator) {
        this.input = input;
        this.output = output;
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLotto() {
        int price = getPrice();
        int numberOfLotto = getNumberOfLotto(price);
        List<Lotto> lottos = lottoGenerator.generateLottos(numberOfLotto);
        output.printPurchasedLotto(lottos);

        return lottos;
    }

    private int getNumberOfLotto(int price) {
        return price / 1000;
    }

    private int getPrice() {
        output.printLottoPriceRequest();
        return input.getPrice();
    }
}
