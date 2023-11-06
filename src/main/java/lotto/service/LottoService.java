package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyPrice;
import lotto.repository.LottoRepository;
import lotto.util.RandomNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<Lotto> buyLotto(LottoBuyPrice lottoBuyPrice) {
        List<Lotto> lottos = new ArrayList<>();
        int availableLottoBuyCount = lottoBuyPrice.getAvailableLottoBuyCount();

        for (int i = 0; i < availableLottoBuyCount; i++) {
            List<Integer> numbers = RandomNumberUtil.generateAndSortUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
            lottos.add(new Lotto(numbers));
        }

        lottoRepository.saveAll(lottos);

        return lottos;
    }
}
