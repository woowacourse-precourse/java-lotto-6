package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                ", buyPrice=" + buyPrice +
                '}';
    }
}
