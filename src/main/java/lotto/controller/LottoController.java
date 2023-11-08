package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PlayerAmount;
import lotto.domain.Profit;
import lotto.domain.RankResult;
import lotto.service.LottoService;
import lotto.util.Converter;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        start();
        getTotalResult();
    }

    private void start() {
        PlayerAmount playerAmount = getPlayerAmount();
        Lottos lottos = createLottos(playerAmount);
        outputView.printCreatedLotto(playerAmount, lottos);

        LottoResult lottoResult = setLottoResult();

        lottoService = new LottoService(lottos, lottoResult, playerAmount);
    }

    private PlayerAmount getPlayerAmount() {
        try {
            return new PlayerAmount(inputView.getPlayerAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerAmount();
        }
    }

    private Lottos createLottos(PlayerAmount playerAmount) {
        int count = playerAmount.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(0, count)
                .forEach(lotto -> lottos.add(new Lotto(RandomNumberGenerator.generate())));

        return Lottos.create(lottos);
    }

    private Lotto getWinningLotto() {
        try {
            List<Integer> winningNumber = Converter.convertToIntList(inputView.getLottoWinningNumbers());
            return new Lotto(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber() {
        try {
            return new BonusNumber(inputView.getBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private LottoResult setLottoResult() {
        try {
            Lotto winningLotto = getWinningLotto();
            BonusNumber bonusNumber = getBonusNumber();

            return LottoResult.create(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLottoResult();
        }
    }

    private void getTotalResult() {
        RankResult rankResult = lottoService.getLottoRankResult();
        outputView.printLottoRank(rankResult);

        Profit profit = lottoService.getLottoProfitRate(rankResult);
        outputView.printLottoProfitRate(profit);
    }
}
