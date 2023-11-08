package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author 민경수
 * @description lottos
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = List.copyOf(lottoTickets);
    }

    public static LottoTickets of(List<Lotto> lottos) {
        return new LottoTickets(lottos);
    }

    public int size() {
        return lottoTickets.size();
    }

    public void acceptLottoNumbers(Consumer<List<Integer>> consumer) {
        for (Lotto lottoTicket : lottoTickets) {
            lottoTicket.acceptLottoNumbers(consumer);
        }
    }

    public List<LottoPrize> getLottoPrizes(WinningLotto winningLotto) {
        List<LottoPrize> lottoPrizes = new ArrayList<>();

        for (Lotto boughtLottoTicket : lottoTickets) {
            lottoPrizes.add(LottoPrize.findByMatchingCountAndBonusBall(boughtLottoTicket, winningLotto));
        }

        return lottoPrizes;
    }

    public BigDecimal totalPurchasedAmount() {
        return BigDecimal.valueOf(Lotto.PRICE * size());
    }
}