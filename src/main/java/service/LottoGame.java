package service;

import domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import utils.Utils;

public class LottoGame {
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> generateLottoTickets(int spend) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int purchasedLottoCount = calculatePurchasedLottoCount(spend);
        for (int i = 1; i <= purchasedLottoCount; i++) {
            lottoTickets.add(generateLottoNumbers());
        }
        return lottoTickets;
    }

    private int calculatePurchasedLottoCount(int spend) {
        return spend / 1_000;
    }

    private Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Utils.generateRandomUniqueNumbers(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_NUMBER_COUNT));
        return new Lotto(lottoNumbers);
    }
}
