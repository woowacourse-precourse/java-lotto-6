package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Const.*;

public class LottoNumbers {



    public static List<Lotto> randomsLottos(LottoAmount lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != lottoAmount.getLottoCount()) {
            lottos.add(creatLotto());
        }
        return lottos;

    }

    private static Lotto creatLotto() {
        return new Lotto(sortNumbers(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)));
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


}
