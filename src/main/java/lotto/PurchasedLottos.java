package lotto;

import static lotto.LottoGenerator.makeRandomNumbersInLotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PurchasedLottos {

    private List<Lotto> lottos = new ArrayList<>();
    private Map<LottoReward, Integer> rewardmap;

    private final Purchase purchase;

    public PurchasedLottos(Purchase purchase) {
        this.purchase = purchase;
        rewardmap = new EnumMap<>(LottoReward.class);
        for (LottoReward reward : LottoReward.values()) {
            rewardmap.put(reward, 0); // Initialize each reward count to zero
        }
        for (int i = 0; i < purchase.getTicketCount(); i++) {
            Lotto lotto = new Lotto(makeRandomNumbersInLotto());
            lottos.add(lotto);
        }
    }

    public String LottosToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
