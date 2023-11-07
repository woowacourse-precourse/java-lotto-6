package lotto.service;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.generator.LottoNumberGenerator;

public class LottoBuyService {

    private static final int LOTTO_PRICE = 1000;
    private static final LottoNumberGenerator lottoGenerator = new LottoNumberGenerator();
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public int getLottoAmount(int price) {
        int lottoAmount;

        lottoAmount = price / LOTTO_PRICE;
        return lottoAmount;
    }

    public List<Lotto> exchangeLotto(int lottoAmount) {
        for (int ticket = 0; ticket < lottoAmount; ticket++) {
            Lotto lotto = new Lotto(lottoGenerator.generate());
            lottoRepository.addLotto(lotto);
        }
        return lottoRepository.getLottoTicket();
    }
}
