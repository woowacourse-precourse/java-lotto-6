package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static final int LOTTO_PRICE = 1000;

    public static Lotto generateLotto() {
        try {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 6));
            numbers.sort(Integer::compareTo);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("로또 번호 생성 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public static List<Lotto> generateLottos(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("로또 개수는 1개 이상이어야 합니다.");
        }
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }
}
