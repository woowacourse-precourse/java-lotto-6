package lotto.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Winning;

public class LottoArgumentDTO {

    private final int lottoSize;
    private final List<Lotto> lottos;
    private final Winning winning;

    public static LottoArgumentDTO of(int lottoSize, List<Lotto> lottos, Winning winning) {
        return new LottoArgumentDTO(lottoSize, lottos, winning);
    }

    private LottoArgumentDTO(int lottoSize, List<Lotto> lottos, Winning winning) {
        this.lottoSize = lottoSize;
        this.lottos = lottos;
        this.winning = winning;
    }

    public int getLottoSize() {
        return lottoSize;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Winning getWinning() {
        return winning;
    }
}
