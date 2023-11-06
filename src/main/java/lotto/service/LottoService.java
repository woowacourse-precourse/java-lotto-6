package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.generator.LottoNumberGenerator;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final LottoNumberGenerator lottoGenerator = new LottoNumberGenerator();

    public int getLottoAmount(int price) {
        int lottoAmount;

        lottoAmount = price / LOTTO_PRICE;
        return lottoAmount;
    }

    public List<Lotto> exchangeLotto(int lottoAmount) {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int ticket = 0; ticket < lottoAmount; ticket++) {
            List<Integer> lotto = lottoGenerator.generate();
            lottoTicket.add(new Lotto(lotto));
        }

        return lottoTicket;
    }
}
