package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    static final int start = 1;
    static final int end = 45;
    static final int lottoNumbersCount = 6;
    static final int bonusNumbersCount = 1;

    public List<Integer> numbersGenerator() {
        List <Integer> immutableNumbers = Randoms.pickUniqueNumbersInRange(start,end,lottoNumbersCount);
        List<Integer> numbers = new ArrayList<>(immutableNumbers);
        Collections.sort(numbers);
        return numbers;
    }
    public int bonusNumberGenerator(List<Integer> winNumbers) {
        List<Integer> bonusNumber;
        int bonusNumberForReturn;
        do {
            bonusNumber = Randoms.pickUniqueNumbersInRange(start,end,bonusNumbersCount);
        } while (winNumbers.contains(bonusNumber));
        bonusNumberForReturn = bonusNumber.get(0);
        return bonusNumberForReturn;
    }

    public List<List<Integer>> createGames(int ticket) {
        List<List<Integer>> games = new ArrayList<>();
        List<Integer> tempLotto;
        for (int i = 0; i < ticket; i++) {
            Lotto lotto = new Lotto(numbersGenerator());
            tempLotto = lotto.getNumbers();
            System.out.println(tempLotto);
            games.add(tempLotto);
        }
        return games;
    }

}
