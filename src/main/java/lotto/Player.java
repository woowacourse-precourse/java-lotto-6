package lotto;

import java.util.List;


public class Player {
    private final List<Lotto> lottos;

    public Player(int n) {
        this.lottos = LottoGenerator.getLottosByCount(n);
    }

    public int getLottoSize() {
        return this.lottos.size();
    }

    public void printLottos(){
        for (Lotto lotto:
             lottos) {
            OutputService.printLottoNumbers(lotto);
        }
    }



}
