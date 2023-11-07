package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private int ticket;
    private final LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.getInstance();

    private static final LottoStore instance = new LottoStore();

    private LottoStore() {
    }

    public static LottoStore getInstance() {
        return instance;
    }

    private void buyTicket(int money) {
        this.ticket = money / 1000;
    }

    public List<Lotto> buyLotto(int money) {
        buyTicket(money);
        List<List<Integer>> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            purchasedLotto.add(lottoNumberGenerator.generate());
        }
        return purchasedLotto.stream().map(Lotto::new).toList();
    }
}
