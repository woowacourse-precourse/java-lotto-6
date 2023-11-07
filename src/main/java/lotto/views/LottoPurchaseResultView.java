package lotto.views;

import java.util.List;
import lotto.Lotto;
import lotto.constants.StringConstants;

public class LottoPurchaseResultView implements View<Void> {
    private final List<Lotto> lottos;

    public LottoPurchaseResultView(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public Void render() {
        System.out.printf(StringConstants.BUY_FORMAT_MESSAGE + "\n", lottos.size());
        for (var lotto : lottos) {
            System.out.println(lotto);
        }
        return null;
    }
}
