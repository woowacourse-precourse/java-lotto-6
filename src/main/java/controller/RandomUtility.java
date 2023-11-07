package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtility {
    public List<Integer> generateRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
        sortRandomLottoNumbers(sortedNumbers);
        return sortedNumbers;
    }

    private void sortRandomLottoNumbers(List<Integer> sortedNumbers) {
        sortedNumbers.sort(Comparator.naturalOrder());
    }

}
