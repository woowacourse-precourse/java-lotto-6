package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
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
        try {
            setting();
            settle();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void setting() {
        PlayerAmount playerAmount = getPlayerAmount();
        Lottos lottos = createLottos(playerAmount);
        outputView.printCreatedLotto(playerAmount, lottos);

        LottoResult lottoResult = setLottoResult();

        lottoService = new LottoService(lottos, lottoResult, playerAmount);
    }

    private PlayerAmount getPlayerAmount() {
        return new PlayerAmount(inputView.getPlayerAmount());
    }

    private Lottos createLottos(PlayerAmount playerAmount) {
        int count = playerAmount.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(0, count)
                .forEach(lotto -> lottos.add(new Lotto(RandomNumberGenerator.generate())));

        return Lottos.create(lottos);
    }

    private LottoResult setLottoResult() {
        List<Integer> winningNumber = Converter.convertToIntList(inputView.getLottoWinningNumbers());
        String bonusNumber = inputView.getBonusNumber();

        return LottoResult.create(winningNumber, bonusNumber);
    }

    private void settle() {
        RankResult rankResult = lottoService.getLottoRankResult();
        outputView.printLottoRank(rankResult);

        Profit profit = lottoService.getLottoProfitRate(rankResult);
        outputView.printLottoProfitRate(profit);
    }
}
