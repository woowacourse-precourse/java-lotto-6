package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.util.Constants;

public class LottoService {
    private static LottoService lottoService = new LottoService();

    private LottoService() {
    }

    public static LottoService getInstance() {
        return lottoService;
    }

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / Constants.LOTTO_PRICE;
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
