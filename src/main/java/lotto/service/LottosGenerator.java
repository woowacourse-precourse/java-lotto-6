package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottosGenerator {
    private static final int LOTTO_MAX_NUMBER =45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    public Lottos generateLottos(int budget){
        Lottos lottos = new Lottos();
        for(int i=0;i<countToGenerateLotto(budget);i++){
            lottos.addLotto(generateLotto());
        }
        return lottos;
    }

    private int countToGenerateLotto(int budget){
        return budget/LOTTO_PRICE;
    }

    private Lotto generateLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE));
    }
}
