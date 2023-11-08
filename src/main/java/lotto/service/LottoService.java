package lotto.service;

import static lotto.domain.LottoAttribute.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoAttribute.LOTTO_MIN_NUMBER;
import static lotto.domain.LottoAttribute.LOTTO_PRICE;
import static lotto.repository.LottoRepository.getBudget;
import static lotto.repository.LottoRepository.getInstance;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {
    LottoRepository lottoRepository = getInstance();

    public void issueLottos() {
        for (int i = 0; i < getBudget() / LOTTO_PRICE.getValue(); i++) {
            lottoRepository.save(issueOneLotto());
        }
    }

    private Lotto issueOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue(), 6);
        return new Lotto(numbers);
    }
}
