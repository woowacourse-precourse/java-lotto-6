package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static LottoMachine lottoMachine = new LottoMachine();

    private LottoMachine() {
    }

    public static LottoMachine getInstance(){
        return lottoMachine;
    }

    public List<Lotto> produceLottos(int price){
        int number = price / 1000;

        List<Lotto> lottos = new List<Lotto>;

        for(int i=0; i<number; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);

            lottos.add(new Lotto(sortedNumbers));
        }
        return lottos;
    }

}
