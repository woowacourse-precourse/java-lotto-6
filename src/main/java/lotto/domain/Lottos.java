package lotto.domain;

import static lotto.utils.ConstantString.NEW_LINE;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.service.WinningLotto;
import lotto.utils.LottoConstantValue;
import lotto.utils.Prize;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.getAvailableLottoCount(); count++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public int getPrizeCount(Prize prize, WinningLotto winningLotto) {
        int prizeCount = 0;
        for (Lotto lotto : lottos) {
            if (winningLotto.getPrize(lotto) == prize) {
                prizeCount++;
            }
        }
        return prizeCount;
    }

    @Override
    public String toString() {
        StringJoiner lottosPrinting = new StringJoiner(NEW_LINE);
        for (Lotto lotto : lottos) {
            lottosPrinting.add(lotto.toString());
        }
        return lottosPrinting.toString();
    }
}
