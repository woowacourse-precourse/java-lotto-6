package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.generator.LottoNumberGenerator;

public class LottoBuyService {

    private static final int LOTTO_PRICE = 1000;
    private static final LottoNumberGenerator lottoGenerator = new LottoNumberGenerator();

    public int getLottoAmount(int price) {
        int lottoAmount;

        lottoAmount = price / LOTTO_PRICE;
        return lottoAmount;
    }

    public LottoRepository exchangeLotto(int lottoAmount) {
        LottoRepository lottoRepository = LottoRepository.getInstance();
        for (int ticket = 0; ticket < lottoAmount; ticket++) {
            Lotto lotto = new Lotto(lottoGenerator.generate());
            lottoRepository.addLotto(lotto);
        }
        //싱글톤으로 바꿔서 리턴하지않고 lottoWinnerService에서도 사용
        return lottoRepository;
    }
}
