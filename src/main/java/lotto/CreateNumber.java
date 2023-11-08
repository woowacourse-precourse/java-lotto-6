package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateNumber {
    public ArrayList<List<Integer>> createLottoNumbers(int buyNumber) {
        ArrayList<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < buyNumber; i++) {
            List<Integer> lottoNumber = createLottoNumber();
            List<Integer> cloneNumber = new ArrayList<>(lottoNumber);
            Collections.sort(cloneNumber);
            lottoNumbers.add(cloneNumber);
            System.out.println(cloneNumber);
        }
        return lottoNumbers;
    }

    public List<Integer> createLottoNumber() {
        while (true) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            try {
                Lotto lotto = new Lotto(numbers);
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }
}
