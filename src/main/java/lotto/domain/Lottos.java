package lotto.domain;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private ArrayList<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
