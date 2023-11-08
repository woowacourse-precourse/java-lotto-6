package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

class LottoGenerator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;

    static List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoNumber = 0; lottoNumber < numberOfLottos; lottoNumber++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        Lotto lotto = new Lotto(generateLotteryNumber());
        return lotto;
    }

    private static List<Integer> generateLotteryNumber() {
        List<Integer> lottertyNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE));
        Collections.sort(lottertyNumbers);
        return lottertyNumbers;
    }
}
