package lotto.manager;

import java.util.Collections;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.money.LottoCount;

public class LottoManager {
    private Lottos lottos;
    private LottoCount lottoCount;

    private LottoManager(Lottos lottos, LottoCount lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public static LottoManager of(Lottos lottos, LottoCount lottoCount) {
        return new LottoManager(lottos, lottoCount);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos.getLottos());
    }

    public String getLottosInfo() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos.getLottos()) {
            sb.append(lotto.printLottoInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
}
