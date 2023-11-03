package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Create {
    public static Lotto[] createLottos(int amount) {
        Lotto[] lottos = new Lotto[amount];
        for(int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = createRandomNumbers();
            lottos[i] = new Lotto(lottoNumbers);
        }
        return lottos;
    }
    public static List<Integer> createRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }
}
