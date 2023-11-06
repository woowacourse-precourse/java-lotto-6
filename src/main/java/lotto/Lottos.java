package lotto;

import java.util.List;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    @Override
    public String toString() {
        String res = "";
        for (Lotto lotto : lottos) {
            res += lotto.toString() + "\n";
        }
        return res;
    }
}
