package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.Constant;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {

    private static final LottoService instance = new LottoService(LottoRepository.getInstance());
    private final LottoRepository lottoRepository;

    private LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public static LottoService getInstance() {
        return instance;
    }

    public List<Lotto> createLottos(int purchaseAmount) {
        for (int i = Constant.LOTTO_TICKET_PRICE; i <= purchaseAmount; i += Constant.LOTTO_TICKET_PRICE) {
            createLotto();
        }
        return lottoRepository.findAll();
    }

    private void createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constant.MIN, Constant.MAX, Constant.SIZE);
        Lotto lotto = new Lotto(numbers);
        lottoRepository.save(lotto);
    }
}
