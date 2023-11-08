package lotto.game;

import lotto.buyer.Buyer;
import lotto.company.LotteryResult;
import lotto.company.Lotto;
import lotto.company.LottoCompany;

import java.util.List;

public class Game {
    private Buyer buyer;
    private LottoCompany lottoCompany;

    public Game() {
        this.buyer = new Buyer();
        this.lottoCompany = new LottoCompany();
    }

    public void play() {
        int buyAmount = buyer.payForLotto();
        List<Lotto> generatedLottos = lottoCompany.generateLottoList(buyAmount);
        lottoCompany.printLottoList(generatedLottos);
        buyer.receiveLottos(generatedLottos);

        LotteryResult lotteryResult = lottoCompany.getLotteryResult();
        buyer.compareWithLotteryResult(lotteryResult);
        buyer.printLotteryResult();
    }
}
