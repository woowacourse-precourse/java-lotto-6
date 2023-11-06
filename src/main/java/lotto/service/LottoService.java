package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyPrice;
import lotto.dto.LottoNumbers;
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

    public List<LottoNumbers> buyLotto(LottoBuyPrice lottoBuyPrice) {
        int availableLottoBuyCount = lottoBuyPrice.getAvailableLottoBuyCount();
        List<Lotto> createdLottos = createAndSaveLotto(availableLottoBuyCount);

        return convertLottoToLottoNumbers(createdLottos);
    }

    private List<Lotto> createAndSaveLotto(int createCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < createCount; i++) {
            List<Integer> numbers = RandomNumberUtil.generateAndSortUniqueNumbersInRange(
                    LOTTO_START_NUMBER,
                    LOTTO_END_NUMBER,
                    LOTTO_NUMBER_COUNT
            );
            lottos.add(new Lotto(numbers));
        }

        lottoRepository.saveAll(lottos);

        return lottos;
    }

    private List<LottoNumbers> convertLottoToLottoNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> new LottoNumbers(lotto.getNumbers()))
                .toList();
    }
}
