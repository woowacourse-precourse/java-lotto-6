package lotto;

import java.util.ArrayList;
import java.util.List;

public class lottoPlayer {
    private final List<Lotto> lottos = new ArrayList<>();
    private int money = 0;

    public void generateLottos(int number) {
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
            lottos.add(lotto);
        }
    }

    public void removeLottos() {
        lottos.clear();
    }

    public void addMoney(int additionalMoney) {
        money += additionalMoney;
    }
}
