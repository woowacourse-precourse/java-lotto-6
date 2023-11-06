package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.generator.RandomNumberGenerator;

public class LottoService {
    public static List<Lotto> issueLottoTickets(int purchasePrice) {
        int lottoAmount = purchasePrice / 1000;

        List<Lotto> lottos = new ArrayList<>(lottoAmount);
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> uniqueRandomNums = RandomNumberGenerator.generateUniqueRandomValues();
        return new Lotto(uniqueRandomNums);
    }
}
