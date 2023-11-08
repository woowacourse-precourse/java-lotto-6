package lotto.controller;

import java.util.stream.Collectors;
import lotto.common.Validation;
import lotto.domain.Buyer;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private Buyer buyer;
    private WinningLotto winningLotto;
    private Rank rank;
    private Integer buyPrice;
    private Integer buyLottoCount;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public boolean run() {
        start();
        buy();
        randomLotto();
        winningLotto();
        lottoResult();
        rate();
        return true;
    }

    private void start() {
        outputView.outputStartMessage();
        buyPrice = inputView.inputPrice();
    }

    private void buy() {
        buyLottoCount = lottoService.buyLottoCount(buyPrice);
    }

    private void randomLotto() {
        outputView.outputLottoCountMessage(buyLottoCount);
        buyer = lottoService.setBuyer(lottoService.getRandomLotto(buyLottoCount));
        randomLottoPrint();
    }

    private void randomLottoPrint() {
        buyer.getLottos()
                .forEach(lotto -> outputView.outputLottoMessage(lotto.getNumbers()
                        .stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))));
    }

    private void winningLotto() {
        String strLotto = inputLotto();
        String strBonus = inputBonus();
        winningLotto = lottoService.setWinningLotto(strLotto, strBonus);
    }

    private String inputLotto() {
        outputView.inputLottoNumber();
        return inputView.inputLotto();
    }

    private String inputBonus() {
        outputView.inputBonusNumber();
        return inputView.inputBonus();
    }

    private void lottoResult() {
        outputView.outputLottoResult();
        rank = lottoService.setLottoResult(buyer, winningLotto);

        outputView.outputRankFiveResult(rank.getFive());
        outputView.outputRankFourResult(rank.getFour());
        outputView.outputRankThreeResult(rank.getThree());
        outputView.outputRankTwoResult(rank.getTwo());
        outputView.outputRankOneResult(rank.getOne());
    }

    private void rate() {
        double rateOfReturn = rank.getResultPrice(buyPrice);
        outputView.outputRate(rateOfReturn);
    }
}
