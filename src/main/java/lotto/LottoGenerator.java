package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            Lotto lotto = generateSingleLotto();
            List<Integer> sortedNumbers = getSortedLottoNumbers(lotto);
            System.out.println(sortedNumbers);
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private List<Integer> getSortedLottoNumbers(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }
}
