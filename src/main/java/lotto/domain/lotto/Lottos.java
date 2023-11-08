package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.utils.constant.BuyPrice;
import lotto.utils.generator.LottoGenerator;
import lotto.utils.view.Messages;

public class Lottos {
    private final List<Lotto> lottos;
    private final BuyPrice buyPrice;

    public Lottos(BuyPrice buyPrice) {
        this.lottos = generateLotto(buyPrice);
        this.buyPrice = buyPrice;
    }

    private List<Lotto> generateLotto(BuyPrice buyPrice) {
        return Stream.generate(LottoGenerator::generate)
                .limit(buyPrice.getBuyCount())
                .toList();
    }

    public int getCount() {
        return lottos.size();
    }

    public String getBuyMessage() {
        return String.format(Messages.SETUP_BUY_LOTTO_MESSAGE.getMessage(), lottos.size());
    }

    public String getLottoMessages() {
        return lottos.stream()
                .map(Lotto::getLottoMessage)
                .collect(Collectors.joining("\n"));
    }

    public WinningResult getWinningResult(WinningNumbers winningNumbers) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            winningResult.addWinning(lotto.compare(winningNumbers));
        }
        return winningResult;
    }
}
