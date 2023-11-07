package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottoTickets;

    public LottoService() {
        this.lottoTickets = new ArrayList<>();
    }

    public void generateLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = generateSortedLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
    }

    private List<Integer> generateSortedLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }


}
