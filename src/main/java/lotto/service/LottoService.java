package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {

    private static final LottoService instance = new LottoService(LottoRepository.getInstance());
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_TICKET_PRICE = 1000;
    private final LottoRepository lottoRepository;

    private LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public static LottoService getInstance() {
        return instance;
    }

    public List<Lotto> createLottos(int purchaseAmount) {
        for (int i = LOTTO_TICKET_PRICE; i <= purchaseAmount; i += LOTTO_TICKET_PRICE) {
            createLotto();
        }
        return lottoRepository.findAll();
    }

    private void createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        lottoRepository.save(lotto);
    }
}
