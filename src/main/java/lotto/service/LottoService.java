package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;
import lotto.util.generator.LottoNumberGenerator;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final LottoNumberGenerator lottoGenerator = new LottoNumberGenerator();

    public int getLottoAmount(int price) {
        int lottoAmount;

        lottoAmount = price / LOTTO_PRICE;
        return lottoAmount;
    }

    public LottoTicket exchangeLotto(int lottoAmount) {
        LottoTicket lottoTicket = new LottoTicket();
        for (int ticket = 0; ticket < lottoAmount; ticket++) {
            Lotto lotto = new Lotto(lottoGenerator.generate());
            lottoTicket.addLotto(lotto);
        }

        return lottoTicket;
    }
}
