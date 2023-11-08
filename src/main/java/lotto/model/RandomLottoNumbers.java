package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class RandomLottoNumbers {

    public List<List<Integer>> createAutoLotto(int games) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        while(lottoNumbers.size() < games) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            if (!duplicateCheck(numbers)) {
                lottoNumbers.add(numbers);
            }
        }
        return sortLotto(lottoNumbers);
    }

    public Boolean duplicateCheck(List<Integer> numbers) {
        HashSet<Integer> numbersCheck = new HashSet<>(numbers);
        if(numbersCheck.size() == 6) {
            return false;
        }
        return true;
    }

    public List<List<Integer>> sortLotto(List<List<Integer>> lottoNumbers) {
        for(int i = 0; i < lottoNumbers.size(); i++) {
            if (!isSorted(lottoNumbers.get(i))) {
                Collections.sort(lottoNumbers.get(i));
            }
        }
        return lottoNumbers;
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
