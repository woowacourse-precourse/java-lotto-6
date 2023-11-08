package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class Lottos {
    private static final String PURCHASE_NUM_INFORMATION_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private List<Lotto> lottoCollection;

    public Lottos(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    public static Lottos createLottos(Money money) {
        List<Lotto> lottoCollection = new ArrayList<>();
        int lottoNum = money.getMoney() / Money.UNIT_PRICE;
        OutputView.printMessage(String.format(PURCHASE_NUM_INFORMATION_MESSAGE_FORMAT, lottoNum));
        for (int i = 0; i < lottoNum; i++) {
            lottoCollection.add(Lotto.createLotto());
        }
        OutputView.printMessage();
        return new Lottos(lottoCollection);
    }
}
