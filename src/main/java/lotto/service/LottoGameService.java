package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.LottoRankResultDTO;
import lotto.model.LottoRank;
import lotto.model.LottoRankResult;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameService {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;

    public LottoGameService(ConsoleInputView inputView, ConsoleOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int calculateLottoCountOnBuy(final LottoBuyer buyer) {
        outputView.requestPurchaseAmount();
        try {
            buyer.pay(readPurchaseAmount());
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

    public void printWinningResult(final WinningLotto winningLotto, Lottos lottos) {
        outputView.printWinningStatistics();
        LottoRankResult result = calculateWinningResult(winningLotto, lottos);
        printWinningCountsByRank(result);
    }

    private Lotto getWinningLottoNumbers() {
        outputView.requestWinningLottoNumbers();
        try {
            return new Lotto(readWinningLotto());
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return getWinningLottoNumbers();
        }
    }

    private WinningLotto getWinningLottoByBonusNumber(Lotto lotto) {
        outputView.requestBonusLottoNumber();
        try {
            return new WinningLotto(lotto, readBonusNumber());
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return getWinningLottoByBonusNumber(lotto);
        }
    }

    private int readPurchaseAmount() {
        return inputView.readIntegerInput();
    }

    private List<Integer> readWinningLotto() {
        return inputView.readWinningLotto();
    }

    private int readBonusNumber() {
        return inputView.readIntegerInput();
    }

    private void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    private LottoRankResult calculateWinningResult(WinningLotto winningLotto, Lottos lottos) {
        LottoRankResult result = new LottoRankResult();
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.findLottoByIndex(i);
            result.countWinningResult(winningLotto, lotto);
        }
        return result;
    }

    private void printWinningCountsByRank(LottoRankResult result) {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        IntStream.range(1, ranks.size())
                .forEach(i -> {
                    LottoRank rank = ranks.get(i);
                    outputView.printWinningNumberCount(new LottoRankResultDTO(rank, result));
                });
    }
}
