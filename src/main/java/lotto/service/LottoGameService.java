package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.LottoRankResultDTO;
import lotto.dto.LottoTotalReturnDTO;
import lotto.model.rank.LottoRank;
import lotto.model.rank.LottoRankResult;
import lotto.model.lotto.Lotto;
import lotto.model.trade.LottoBuyer;
import lotto.model.trade.LottoSeller;
import lotto.model.lotto.Lottos;
import lotto.model.rank.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoRankResult lottoRankResult;

    public LottoGameService(
            final InputView inputView,
            final OutputView outputView,
            final LottoRankResult lottoRankResult
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoRankResult = lottoRankResult;
    }

    public int calculateLottoCountOnBuy(final LottoBuyer buyer) {
        outputView.requestPurchaseAmount();
        try {
            buyer.pay(inputView.readIntegerInput());
            return buyer.getCountOfLotto();
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return calculateLottoCountOnBuy(buyer);
        }
    }

    public Lottos generateLottosOnSell(final LottoSeller seller, final int countOfLotto) {
        outputView.printCountOfLotto(countOfLotto);
        return seller.sell(countOfLotto);
    }

    public void printLottoNumbersByCount(final Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.findLottoByIndex(i);
            LottoNumbersDTO lottoNumbers = new LottoNumbersDTO(lotto.getLotto());
            outputView.printLottoNumbers(lottoNumbers);
        }
    }

    public WinningLotto generateWinningLotto() {
        Lotto winningLottoNumbers = getWinningLottoNumbers();
        return getWinningLottoByBonusNumber(winningLottoNumbers);
    }

    public void printWinningResult(final WinningLotto winningLotto, final Lottos lottos) {
        outputView.printWinningStatistics();
        LottoRankResult result = calculateWinningResult(winningLotto, lottos);
        printWinningCountsByRank(result);
    }

    public void printTotalReturn(final int countOfLotto) {
        LottoTotalReturnDTO result = new LottoTotalReturnDTO(lottoRankResult, countOfLotto);
        outputView.printTotalReturn(result);
    }

    public void endGame() {
        inputView.close();
    }

    private Lotto getWinningLottoNumbers() {
        outputView.requestWinningLottoNumbers();
        try {
            return new Lotto(inputView.readWinningLotto());
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return getWinningLottoNumbers();
        }
    }

    private WinningLotto getWinningLottoByBonusNumber(final Lotto lotto) {
        outputView.requestBonusLottoNumber();
        try {
            return new WinningLotto(lotto, inputView.readIntegerInput());
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return getWinningLottoByBonusNumber(lotto);
        }
    }

    private void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    private LottoRankResult calculateWinningResult(final WinningLotto winningLotto, final Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.findLottoByIndex(i);
            lottoRankResult.countWinningResult(winningLotto, lotto);
        }
        return lottoRankResult;
    }

    private void printWinningCountsByRank(final LottoRankResult result) {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        IntStream.range(1, ranks.size())
                .forEach(i -> {
                    LottoRank rank = ranks.get(i);
                    outputView.printWinningNumberCount(new LottoRankResultDTO(rank, result));
                });
    }
}
