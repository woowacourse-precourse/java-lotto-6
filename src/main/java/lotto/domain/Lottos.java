package lotto.domain;

import java.util.List;

public class Lottos {
    private List<Integer> randomLottos;

    public Lottos(List<Integer> randomLottos){
        this.randomLottos = randomLottos;
    }

    public List<Integer> getRandomLottos(){
        return randomLottos;
    }
}
