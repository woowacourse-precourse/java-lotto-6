package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {


    private static List<Integer> generateLotteryNumber() {
        List<Integer> lottertyNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottertyNumbers);
        return lottertyNumbers;
    }

    public static List<Lotto> generateLottos(int numberOfLottoes) {
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoNumber = 0; lottoNumber < numberOfLottoes; lottoNumber++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        Lotto lotto = new Lotto(generateLotteryNumber());
        return lotto;
    }

}
