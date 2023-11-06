package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.RandomUtil;

public class PlayerLotto {
    private final List<Lotto> playerLottos;
    private final int purchasesPrice;
    private final int lottoAmount;

    public PlayerLotto(int price) {
        this.purchasesPrice = price;
        this.lottoAmount = price / 1000;
        this.playerLottos = createPlayerLottos();
    }

    private List<Lotto> createPlayerLottos() {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = RandomUtil.createLottoNumber();
            lotto.add(new Lotto(numbers));
        }

        return lotto;
    }

    public List<Lotto> getPlayerLottos() {
        return this.playerLottos;
    }

    public int getPurchasesPrice() {
        return purchasesPrice;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
