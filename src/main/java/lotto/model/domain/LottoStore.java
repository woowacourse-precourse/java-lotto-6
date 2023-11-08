package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoGenerator;
import lotto.util.message.SystemMessage;

public class LottoStore {

    private int ticket;
    private final LottoGenerator lottoNumberGenerator = LottoGenerator.getInstance();

    private static final LottoStore instance = new LottoStore();

    private LottoStore() {
    }

    public static LottoStore getInstance() {
        return instance;
    }

    private void buyTicket(int money) {
        this.ticket = money / 1000;
        SystemMessage.LOTTO_PURCHASE.printMessage(ticket);
    }

    public List<Lotto> buyLotto(int money) {
        buyTicket(money);
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            purchasedLotto.add(lottoNumberGenerator.generate());
        }
        return purchasedLotto;
    }
}
