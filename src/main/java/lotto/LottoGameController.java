package lotto;

import java.util.List;
import java.util.Objects;

public class LottoGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public BuyCash inputBuyCash() {
        return new BuyCash(inputView.inputBuyCashFromUser());
    }

    public Lottos purchaseLotto(BuyCash buyCash) {
        List<Lotto> lottos = LottoGenerator.INSTANCE.generate(buyCash.getLottoAmount());

        return new Lottos(lottos);
    }

    public void printBuyLottosInformation(Lottos lottos) {
        outputView.printUserLottos(lottos.getAllLottoNumbersMessage(), lottos.getLottoAmount());
    }

    public Lotto inputWinningLotto() {
        return generateWinningLotto(inputView.inputWinningNumbers());
    }

    public Lotto generateWinningLotto(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public LottoNumber inputBonusNumber() {
        return new LottoNumber(inputView.inputBonusNumberFromUser());
    }

    public Result getResult(Lottos lottos, WinningLotto winningLotto) {
        Result result = new Result();

        lottos.getLottoTickets().stream()
                .map(winningLotto::getRank)
                .filter(Objects::nonNull)
                .forEach(result::addRank);

        return result;
    }

    public void printWinningResult(Result result, BuyCash buyCash) {
        outputView.printWinningResult(result.getAllRankStatistics(),
                buyCash.getTotalProfitRate(result.getTotalProfit()));
    }
}
