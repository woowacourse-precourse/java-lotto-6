package lotto.game;

import lotto.buyer.Buyer;
import lotto.company.Lotto;
import lotto.company.LottoCompany;

import java.util.List;

public class Game {
    private final Buyer buyer;
    private final LottoCompany lottoCompany;

    public Game() {
        this.buyer = new Buyer();
        this.lottoCompany = new LottoCompany();
    }

    public void play() {
        buyAndReceiveLottos();
        buyer.compareWithLotteryResult(lottoCompany.getLotteryResult());
        buyer.printLotteryResult();
    }

    private void buyAndReceiveLottos() {
        int buyAmount = buyer.payForLotto();
        List<Lotto> generatedLottos = lottoCompany.generateLottoList(buyAmount);
        lottoCompany.printLottoList(generatedLottos);
        buyer.receiveLottos(generatedLottos);
    }
}
