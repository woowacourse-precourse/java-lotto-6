package lotto.controller.subcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.domain.Profit;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.LottoResultRepository;
import lotto.util.enumerator.LottoRank;
import lotto.util.enumerator.WinningAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class CalculateProfitController implements Controllable {
    private static final int LOTTO_UNIT = 1000;

    private final InputView inputView;
    private final OutputView outputView;

    public CalculateProfitController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        double totalProfitRate = calculateProfit();
        outputView.outputProfitRate(totalProfitRate);
    }

    private double calculateProfit() {
        Profit profit = new Profit();
        List<LottoRank> ranks = LottoResultRepository.findLottoRankResults();
        List<WinningAmount> winningAmounts = copyWinningAmountFromLottoRanks(ranks);

        long profitAmount = profit.calculateTotalProfitAmount(winningAmounts);
        int purchaseAmount = getPurchaseAmount();

        return profit.calculateTotalProfitRate(profitAmount, purchaseAmount);
    }

    private int getPurchaseAmount() {
        return LottoRepository.lotties().size() * LOTTO_UNIT;
    }

    private List<WinningAmount> copyWinningAmountFromLottoRanks(List<LottoRank> ranks) {
        List<WinningAmount> winningAmounts = new ArrayList<>();
        for (LottoRank rank : ranks) {
            winningAmounts.add(checkWinningAmount(rank));
        }
        return winningAmounts;
    }

    private WinningAmount checkWinningAmount(LottoRank rank) {
        if (isEqualRank(rank, LottoRank.FIRST)) {
            return WinningAmount.FIRST;
        }
        if (isEqualRank(rank, LottoRank.SECOND)) {
            return WinningAmount.SECOND;
        }
        if (isEqualRank(rank, LottoRank.THIRD)) {
            return WinningAmount.THIRD;
        }
        if (isEqualRank(rank, LottoRank.FOURTH)) {
            return WinningAmount.FOURTH;
        }
        if (isEqualRank(rank, LottoRank.FIFTH)) {
            return WinningAmount.FIFTH;
        }
        return WinningAmount.NONE;
    }

    private boolean isEqualRank(LottoRank first, LottoRank second) {
        return Objects.equals(first, second);
    }
}
