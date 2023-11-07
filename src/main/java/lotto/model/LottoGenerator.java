package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static Lotto generateLotto() {
        List<Integer> numbers = pickUniqueLottoNumbers();
        numbers.sort(Integer::compareTo);
        return new Lotto(numbers);
    }

    public static List<Lotto> generateLottos(int count) {
        validateLottoCount(count);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static List<Integer> pickUniqueLottoNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 6));
    }

    private static void validateLottoCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("로또 개수는 1개 이상이어야 합니다.");
        }
    }
}
