package lotto.service;

import lotto.GameUtils;
import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.RankStatistics;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class NumberService {
    private PurchaseAmount purchaseAmount;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private RankStatistics rankStatistics;

    public int getPurchaseNumber() {
        return purchaseAmount.getPurchaseNumber();
    }

    public String getLottosOutput() {
        return lottos.toString();
    }

    public String getRankStatisticsOutput() {
        return rankStatistics.toString();
    }

    public void initPurchaseAmount(String input) {
        this.purchaseAmount = new PurchaseAmount(input);
    }

    public void initWinningNumbers() {
        this.winningNumbers = new WinningNumbers();
    }

    public void initLottos() {
        this.lottos = new Lottos(createLottos());
    }

    public void initWinningLotto(String input) {
        winningNumbers.initWinningLotto(input);
    }

    public void initBonusNumber(String input) {
        winningNumbers.initBonusNumber(input);
    }

    public void initRankStatistics() {
        this.rankStatistics = new RankStatistics(new EnumMap<>(Rank.class));
        rankStatistics.initStatistics(lottos, winningNumbers);
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.getPurchaseNumber(); count++) {
            lottos.add(GameUtils.createRandomLotto(Lotto.LOTTO_SIZE));
        }
        return lottos;
    }
}
