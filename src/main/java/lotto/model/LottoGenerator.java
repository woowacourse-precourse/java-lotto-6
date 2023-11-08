package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final int NUM_DIGITS = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public List<Lotto> lottoGenerator(int purchasePrice) {
        List<Lotto> lottos = new ArrayList<>();
        int numberOfLottos = purchasePrice / LOTTO_PRICE;
        for (int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = new Lotto(createLottoNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < NUM_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }
}
