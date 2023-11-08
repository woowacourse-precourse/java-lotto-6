package lotto.domain;

import java.util.List;
import lotto.util.LottoGenerator;
import lotto.view.OutputView;

public class User {
    private List<Lotto> lottos;
    private int count;

    public User(int count) {
        this.count = count;
        OutputView.quantityInformationMessage(this.count);
        this.lottos = LottoGenerator.generateLottos(this.count);
        printUserLotto();
    }

    public void printUserLotto() {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
