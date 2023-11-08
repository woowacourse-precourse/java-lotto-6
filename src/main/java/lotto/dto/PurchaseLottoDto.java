package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottery.Lotto;

public class PurchaseLottoDto {
    private final List<LottoDto> totalPurchaseLotto;

    public PurchaseLottoDto(final List<Lotto> lottos) {
        this.totalPurchaseLotto = create(lottos);
    }

    private List<LottoDto> create(final List<Lotto> lottos) {
        List<LottoDto> playerLotto = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoDto lottoDto = new LottoDto(lotto.getLottoNumbers());
            playerLotto.add(lottoDto);
        }
        return playerLotto;
    }

    @Override
    public String toString() {
        return String.valueOf(totalPurchaseLotto);
    }

    public int size() {
        return totalPurchaseLotto.size();
    }

    public List<LottoDto> getTotalPurchaseLotto() {
        return totalPurchaseLotto;
    }
}
