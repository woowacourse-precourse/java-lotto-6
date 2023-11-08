package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerLottos {

    private final List<LottoFactory> lottoFactories;

    public PlayerLottos(int numberOfLottoTickets) {
        this.lottoFactories = generateLottoPlayerNumbers(numberOfLottoTickets);
    }

    public List<LottoFactory> getLottoPlayerNumbers() {
        return lottoFactories;
    }

    private List<LottoFactory> generateLottoPlayerNumbers(int numberOfLottoTickets) {
        List<LottoFactory> lottoFactories = new ArrayList<>();

        for (int count = 0; count < numberOfLottoTickets; count++) {
            lottoFactories.add(new LottoFactory());
        }
        return lottoFactories;
    }
}
