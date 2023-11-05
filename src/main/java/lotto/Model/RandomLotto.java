package lotto.Model;

import java.util.List;

public class RandomLotto {
    private int count;
    private List<Lotto> randomLottos;


    public RandomLotto(Price price, Lottos lottos) {
        count = price.divideWithOneThousands();
        this.randomLottos = lottos.createLottos(count);
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getRandomLottos() {
        return randomLottos;
    }


}
