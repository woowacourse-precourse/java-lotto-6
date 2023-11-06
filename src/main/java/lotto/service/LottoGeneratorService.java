package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class LottoGeneratorService {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MAX_LOTTO_NUMBER_SIZE = 6;

    public Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(generateLottoNumbers());
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private Set<Integer> generateLottoNumbers() {
        Set<Integer> numbers;
        do {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                    MAX_LOTTO_NUMBER_SIZE);
            numbers = new HashSet<>(randomNumbers);
        } while (!(numbers.size() == MAX_LOTTO_NUMBER_SIZE));
        return numbers;
    }
}
