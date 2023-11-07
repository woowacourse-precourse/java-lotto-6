package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;
    private LottoRepository lottoRepository;

    public LottoService() {
        lottoRepository = new LottoRepository();
    }

    public String createPurchaseAmount(String amountInput) {
        return lottoRepository.updatePurchaseAmount(amountInput);
    }

    public String generateByQuantity() {
        int totalQuantity = lottoRepository.getPurchaseQuantity();
        for (int quantity = 0; quantity < totalQuantity; quantity++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            numbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(numbers);
            lottoRepository.insertLotto(lotto);
        }
        return lottoRepository.getLotteriesInfo();
    }
}
