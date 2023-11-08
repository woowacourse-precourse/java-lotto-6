package lotto.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Winning;

public class LottoArgument {

    private final List<Lotto> lottos;
    private final Winning winning;

    public static LottoArgument of(List<Lotto> lottos, Winning winning) {
        return new LottoArgument(lottos, winning);
    }

    private LottoArgument(List<Lotto> lottos, Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
    }
    
    public List<Lotto> getLottos() {
        return lottos;
    }

    public Winning getWinning() {
        return winning;
    }
}
