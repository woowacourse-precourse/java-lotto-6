package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final List<Lotto> myLotto = new ArrayList<>();

    public LottoGenerator(int chance) {
        setMyLotto(chance);
    }
    public void setMyLotto(int chance) {
        IntStream.range(0, chance)
                .mapToObj(i -> new Lotto(generateRandomLottoNumbers()))
                .forEach(myLotto::add);
    }

    private List<Integer> generateRandomLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUM,
                Constants.LOTTO_MAX_NUM,
                Constants.LOTTO_NUM_LENGTH
        );
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
    }
}
