package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoNumberRange;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private final Set<Integer> numbers = new HashSet<>();
    private final int MAX_SIZE = 6;

    private void initNumbers() {
        numbers.clear();
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(
                LottoNumberRange.MIN.getValue(),
                LottoNumberRange.MAX.getValue()
        );
    }

    public List<Integer> generateLottoNumbers() {
        initNumbers();

        while (numbers.size() < MAX_SIZE) {
            numbers.add(generateRandomNumber());
        }

        return numbers.stream().toList();
    }

    public int generateBonusNumber(List<Integer> lotto) {
        int result = generateRandomNumber();
        while (lotto.contains(result)) {
            result = generateRandomNumber();
        }

        return result;
    }
}
