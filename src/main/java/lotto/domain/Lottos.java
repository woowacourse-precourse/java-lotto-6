package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        Collections.sort(numbers);
        //System.out.println("오룸차순  " + numbers);
        validate(numbers);
        return numbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Lotto should have 6 numbers");
        }
    }

}
