package lotto.io;

import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Price;

import static lotto.util.StringConverter.toLong;

public class ConsoleManager {
    private final View view;

    public ConsoleManager(View view) {
        this.view = view;
    }

    public Price getPrice() {
        while (true) {
            String value = view.readPurchasePrice();
            try {
                return new Price(toLong(value));
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    public void printLottoCount(LottoCount count) {
        view.printLottoCountMessage(count);
    }

    public void printLottos(Lottos lottos) {
        view.printPurchaseLottos(lottos.getLottos());
    }

}
