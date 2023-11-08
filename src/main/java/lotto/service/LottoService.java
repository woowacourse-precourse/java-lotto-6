package lotto.service;

import static lotto.repository.LottoRepository.LOTTO_PRICE;
import static lotto.repository.LottoRepository.getBudget;
import static lotto.repository.LottoRepository.getInstance;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {
    LottoRepository lottoRepository = getInstance();

    public void issueLottos() {
        for (int i = 0; i < getBudget() / LOTTO_PRICE; i++) {
            lottoRepository.save(issueOneLotto());
        }
    }

    private Lotto issueOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
