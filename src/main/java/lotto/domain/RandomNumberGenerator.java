package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {

    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 45;
    private final static int COUNT = 6;

    public List<Integer> createSortedLottoNumbers() {
        List<Integer> randomNumbers = pickUniqueLottoNumbers();
        return sortLottoNumbers(randomNumbers);
    }

    private List<Integer> pickUniqueLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                COUNT);

    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<List<Integer>> generateMultipleLottoSets(int ticketCount) {
        List<List<Integer>> multipleLottoSets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> randomNumbers = createSortedLottoNumbers();
            multipleLottoSets.add(randomNumbers);
        }
        return multipleLottoSets;
    }
}
