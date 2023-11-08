package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.constants.LottoConstraint;

public class LottoGenerator {
    private static List<Integer> generateLottoNumbers() {
        return sortLottoNumbers(Randoms.pickUniqueNumbersInRange(LottoConstraint.MIN_NUMBER.getValue(), LottoConstraint.MAX_NUMBER.getValue(), LottoConstraint.LOTTO_SIZE.getValue()));
    }

    private static List<Integer> sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public static List<Lotto> generateLottos(int lottoTicketCount) {
        return IntStream.range(0, lottoTicketCount)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }
}
