package lotto.service;

import static lotto.domain.LottoResult.*;
import static lotto.globar.GlobalConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningCombination;
import lotto.generator.RandomNumberGenerator;

public class LottoService {
    private LottoService() {
    }

    public static List<Lotto> issueLottoTickets(long purchasePrice) {
        int lottoAmount = (int) (purchasePrice / SINGLE_LOTTO_PRICE);

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

    public static List<LottoResult> determineLottoResults(List<Lotto> lottos, LottoWinningCombination lottoWinningCombination) {
        List<LottoResult> lottoResults = new ArrayList<>();

        lottos.stream()
                .map(lotto -> createLottoResult(lotto, lottoWinningCombination))
                .filter(Objects::nonNull)
                .forEach(lottoResults::add);

        return lottoResults;
    }
}
