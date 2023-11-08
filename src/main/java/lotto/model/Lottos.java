package lotto.model;

import java.util.ArrayList;

public class Lottos {

    private ArrayList<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public ArrayList<Lotto> getLottos(){
        return lottos;
    }

    public void printLottosNumbers() {
        for (int i = 0; i < lottos.size(); i++) {
            lottos.get(i).printLottoNumbers();
        }
    }

}
