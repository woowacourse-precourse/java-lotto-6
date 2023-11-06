package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoGenerate {
    private final HashMap<Integer, List<Integer>> randomLottoNumbers;

    public LottoGenerate(int lottoTicket) {
        HashMap<Integer, List<Integer>> randomLottoNumbers = new HashMap<>();

        for (int i = 0; i < lottoTicket; i++) {
            randomLottoNumbers.put(i, createRandomLotto());
        }

        this.randomLottoNumbers = randomLottoNumbers;
    }

    public HashMap<Integer, List<Integer>> getRandomLottoNumbers() {
        return randomLottoNumbers;
    }

    private List<Integer> createRandomLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Config.MIN_LOTTO_NUMBER,
                Config.MAX_LOTTO_NUMBER, Config.SIZE_OF_LOTTO);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
