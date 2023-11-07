package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;

    public static List<Lotto> randomsLottos(LottoAmount lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != lottoAmount.getLottoCount()) {
            lottos.add(creatLotto());
        }
        return lottos;

    }

    private static Lotto creatLotto() {
        return new Lotto(sortNumbers(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_LENGTH)));
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


}
