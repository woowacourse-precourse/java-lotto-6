package lotto.Domain;

import static lotto.Dictionary.LottoDictionary.LOTTO_MAX_NUMBER;
import static lotto.Dictionary.LottoDictionary.LOTTO_MIN_NUMBER;
import static lotto.Dictionary.LottoDictionary.LOTTO_NUMBER_SIZE;
import static lotto.Dictionary.LottoDictionary.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LottoGroup {

    private final List<Lotto> lottoGroup;

    private LottoGroup(Money money) {
        this.lottoGroup = new LinkedList<>();
        int lottoCount = findLottoCount(money);
        for (int i = 0; i < lottoCount; i++) {
            this.lottoGroup.add(Lotto.from(generateLottoNumbers()));
        }
    }

    public static LottoGroup from(Money money) {
        return new LottoGroup(money);
    }

    private Integer findLottoCount(Money money) {
        return money.getMoney()/LOTTO_PRICE.getValue();
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(),
                LOTTO_NUMBER_SIZE.getValue());
    }

    public Integer findLottoNumbersSize() {
        return lottoGroup.size();
    }

    public Lotto findLottoByIndex(Integer index) {
        return lottoGroup.get(index);
    }
}