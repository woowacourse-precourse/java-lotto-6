package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int quantity){
        this.lottos = generateLottos(quantity);
    }

    private List<Lotto> generateLottos(int quantity){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<quantity;i++){
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
