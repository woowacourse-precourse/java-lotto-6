package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers(){
        try {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(numbers);
            validateNumbers(numbers);
            return numbers;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return generateRandomNumbers();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Lotto should have 6 numbers");
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] Lotto Numbers shouldn't be duplicated. ");
        }
    }

}
