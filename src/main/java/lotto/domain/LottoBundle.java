package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Config;
import lotto.Validation;

public class LottoBundle {

    private static final int MIN_VALUE = Config.MIN_VALUE;
    private static final int MAX_VALUE = Config.MAX_VALUE;
    private static final int LOTTO_LENGTH = Config.LOTTO_LENGTH;
    private static final int LOTTO_PRICE = Config.LOTTO_PRICE;
    private final List<Lotto> bundle = new ArrayList<>();

    public List<Lotto> getBundle() {
        return bundle;
    }

    /**
     * 로또 묶음을 생성한다.
     *
     * @param price : 구입 금액
     * @throws IllegalArgumentException : 금액이 양수가 아니거나 로또 가격 단위가 아닌 경우
     */
    public void makeLotto(int price) throws IllegalArgumentException {
        Validation.isOver(price, 0);
        Validation.isCorrectUnit(price, LOTTO_PRICE);

        int quantity = price / LOTTO_PRICE;
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_LENGTH);
            List<Integer> sorted = new ArrayList<>(numbers);
            sorted.sort(Comparator.naturalOrder());
            bundle.add(new Lotto(sorted));
        }
    }

    /**
     * 로또 번호마다 결과를 계산한다.
     *
     * @param winning : 당첨 번호
     * @param bonus   : 보너스 번호
     * @return : 당첨 결과
     */
    public Map<Rank, Integer> result(Lotto winning, int bonus) {
        Map<Rank, Integer> result = new HashMap<>();
        List<Integer> winningNumbers = winning.getNumbers();

        for (Lotto lotto : bundle) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Rank rank = Rank.values()[getCount(lottoNumbers, winningNumbers)];
            if (rank == Rank.THIRD && lottoNumbers.contains(bonus)) {
                rank = Rank.SECOND;
            }
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    /**
     * 당첨 정도를 확인한다.
     *
     * @param lottoNumbers   : 로또 번호
     * @param winningNumbers : 당첨 번호
     * @return : 당첨 개수
     */
    private static int getCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }
}