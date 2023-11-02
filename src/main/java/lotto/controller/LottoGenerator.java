package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private Lotto generateLotto(){
        final int LOTTO_LENGTH = 6;
        final int LOTTO_START_NUMBER = 1;
        final int LOTTO_END_NUMBER = 45;
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_LENGTH);
        return new Lotto(numbers);
    }

    public List<Lotto> generateLottos(int numberOfLotto){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLotto; i++){
            lottos.add(generateLotto());
        }
        return lottos;
    }
}
