package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    private static final LottoService LOTTO_SERVICE = new LottoService();
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generate());
        }

        return lottos;
    }

    public LottoRank checkWinning(List<Integer> userNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = userNumbers.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }
}
