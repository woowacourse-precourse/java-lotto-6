package lotto.domain;

import java.util.List;

public class LottoHistory {

    public String getLottoHistory() {
        List<Lotto> lottos = LottoStore.getInstance().getLotto();
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbers().toString()+"\n");
        }

        return String.valueOf(sb);
    }
}
