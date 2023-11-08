package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void printLottoNumbers() {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getLotto());
        }
    }
}
