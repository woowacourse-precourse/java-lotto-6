package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.entity.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int COUNT_NUMBER = 6;

    public List<Lotto> buyLotto(Integer money) {

        int lottoCount = money / 1000;

        List<Lotto> boughtLotto = new ArrayList<>();
        while (lottoCount > 0){
            boughtLotto.add(new Lotto(getLottoNumbers()));
            lottoCount--;
        }


        return boughtLotto;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER);
        return numbers;
    }


}
