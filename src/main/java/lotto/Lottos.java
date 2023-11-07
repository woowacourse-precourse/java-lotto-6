package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void checkLottos(LottoWinningChecker checker){
        for (Lotto lotto : lottos){
            checker.check(lotto);
        }
    }
}
