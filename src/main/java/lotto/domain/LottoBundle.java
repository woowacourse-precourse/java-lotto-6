package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Config;
import lotto.Validation;

public class LottoBundle {

    private final List<Lotto> bundle = new ArrayList<>();

    /**
     * 로또 묶음을 생성한다.
     *
     * @param price : 구입 금액
     * @throws IllegalArgumentException : 금액이 양수가 아니거나 로또 가격 단위가 아닌 경우
     */
    public void makeLotto(int price) throws IllegalArgumentException {
        Validation.isNumeric(price);
        Validation.isCorrectUnit(price, Config.LOTTO_PRICE);

        int quantity = price / Config.LOTTO_PRICE;
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Config.MIN_VALUE, Config.MAX_VALUE,
                    Config.LOTTO_LENGTH);
            this.bundle.add(new Lotto(numbers));
        }
    }

    /**
     * 당첨 결과를 계산한다.
     *
     * @param winningLotto : 당첨 로또
     * @param bonus        : 보너스 번호
     * @return : 당첨 결과
     */
    public Map<Rank, Integer> makeResult(Lotto winningLotto, int bonus) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : this.bundle) {
            Rank rank = Rank.values()[correctCount(lotto, winningLotto)];
            if (rank == Rank.SECOND) {
                rank = Rank.FIRST;
            }
            if (rank == Rank.THIRD && lotto.hasNumber(bonus)) {
                rank = Rank.SECOND;
            }
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    /**
     * 일치하는 숫자의 개수를 구한다.
     *
     * @param lotto        : 비교할 로또
     * @param winningLotto : 당첨 로또
     * @return : 당첨 개수
     */
    private static int correctCount(Lotto lotto, Lotto winningLotto) {
        int count = 0;

        for (Integer lottoNumber : lotto.getNumbers()) {
            if (winningLotto.hasNumber(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 로또 리스트를 문자열로 만든다.
     *
     * @return : 문자열로 변환된 로또 리스트
     */
    public String toString() {
        StringBuilder string = new StringBuilder(this.bundle.get(0).toString());

        for (Lotto lotto : this.bundle.subList(1, this.bundle.size())) {
            string.append("\n");
            string.append(lotto.toString());
        }
        return String.valueOf(string);
    }

    /**
     * 로또 리스트의 크기를 반환한다.
     *
     * @return : 로또 리스트의 크기
     */
    public int size() {
        return this.bundle.size();
    }
}