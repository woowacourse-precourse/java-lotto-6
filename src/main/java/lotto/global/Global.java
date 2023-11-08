package lotto.global;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Global {
    private static final Publish PUBLISH = new Publish();
    private static final Statistics STATISTICS = new Statistics();
    private List<Lotto> issuedLottos;

    public Global() {
        this.issuedLottos = new ArrayList<>();
    }

    public void setIssuedLottos(List<Lotto> issuedLottos) {
        this.issuedLottos = issuedLottos;
    }

    public void issueLottos(int lottoPurchaseMoney) {
        int lottoCount = PUBLISH.getLottoCount(lottoPurchaseMoney);
        setIssuedLottos(PUBLISH.getIssuedLottos(lottoCount));
        PUBLISH.printIssuedLottoCountAndNumbers(issuedLottos);
    }

    public void getLottoRanking(List<Integer> winningLotto) {
        STATISTICS.calculateRanking(winningLotto, issuedLottos);
        STATISTICS.printRanking();
    }

    public void getRateOfReturn(int lottoPurchaseMoney) {
        double rateOfReturn = STATISTICS.calculateRateOfReturn(lottoPurchaseMoney);
        STATISTICS.printRateOfReturn(rateOfReturn);
    }
}
