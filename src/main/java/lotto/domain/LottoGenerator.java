package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final List<Lotto> myLotto = new ArrayList<>();

    public LottoGenerator(int chance) {
        setMyLotto(chance);
    }

    private void setMyLotto(int chance) {
        IntStream.range(Constants.INIT_VALUE_ZERO, chance)
                .mapToObj(i -> new Lotto(sortedRandomLottoNumbers()))
                .forEach(myLotto::add);
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUM,
                Constants.LOTTO_MAX_NUM,
                Constants.LOTTO_NUM_LENGTH
        );
    }

    private List<Integer> sortedRandomLottoNumbers() {
        List<Integer> mutableList = new ArrayList<>(generateRandomLottoNumbers());
        Collections.sort(mutableList);
        return mutableList;
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
    }
}
