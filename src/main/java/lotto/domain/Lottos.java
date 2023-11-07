package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Integer> randomLottos;

    public Lottos(final List<Integer> randomLottos){
        this.randomLottos = randomLottos;
    }

    public List<Integer> getRandomLottos(){
        return randomLottos;
    }

    public static void displayLottos(Lottos lottos){
        System.out.println(lottos.getRandomLottos());
    }
}
