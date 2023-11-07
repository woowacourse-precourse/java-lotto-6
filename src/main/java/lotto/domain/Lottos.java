package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final long money;

    public Lottos(long money) {
        lottos = new ArrayList<>();
        generateLottos(money);
        this.money = money;
    }

    private void generateLottos(long money){
        int times = (int)money/1000;
        for(int i=0; i<times; i++){
            Lotto lotto = new Lotto(LottoGenerator.generateLotto());
            lottos.add(lotto);
        }
    }
}
