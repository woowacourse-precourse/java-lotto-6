package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
        return lottoNumbers;
    }

    public Boolean duplicateCheck(List<Integer> numbers) {
        HashSet<Integer> numbersCheck = new HashSet<>(numbers);
        if(numbersCheck.size() == 6) {
            return false;
        }
        return true;
    }
}
