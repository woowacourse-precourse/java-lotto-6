package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

public class Create {
    public static Lotto[] createLottos(int amount) {
        Lotto[] lottos = new Lotto[amount];
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = createRandomNumbers();
            lottos[i] = new Lotto(lottoNumbers);
        }
        return lottos;
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers = sortLottos(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Integer> sortLottos(List<Integer> lottoNumbers) {
        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(lottoNumbers);
        sorted.sort(null);

        return sorted;
    }

}
