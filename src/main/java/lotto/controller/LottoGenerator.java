package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoMetaData;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private Lotto generateLotto(){
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(
                LottoMetaData.LOWER.getValue(), LottoMetaData.UPPER.getValue(), LottoMetaData.SIZE.getValue());
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
