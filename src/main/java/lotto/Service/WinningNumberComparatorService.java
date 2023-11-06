package lotto.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Domain.PlayerNumber;
import lotto.Domain.PlayerPrice;
import lotto.View.OutputView;
import lotto.Enum.LottoRankingInfo;

public class WinningNumberComparatorService {
    private final OutputView outputView = new OutputView();
    private final Map<LottoRankingInfo, Integer> winningCounts = new HashMap<>();

    public void winningComparison(PlayerPrice playerPrice, Lotto lotto) {
        totalWinningNumbersCount(playerPrice, lotto);
        outputView.printWinningResult(winningCounts);
        outputView.printROI(extractROI(playerPrice, playerPrice.getWinningMoney()));
    }

    public void totalWinningNumbersCount(PlayerPrice playerPrice, Lotto lotto) {
        List<PlayerNumber> playerIssuedNumbers = playerPrice.getLottoTickets();
        playerIssuedNumbers.forEach(playerNumber -> countPlayerNumbersByWinning(playerPrice, playerNumber.getNumbers(), lotto));
    }

    public void countPlayerNumbersByWinning(PlayerPrice playerPrice, List<Integer> numbers, Lotto lotto) {
        int matchingLottoNumbers = compareWinningAndPlayerNumbers(numbers, lotto.getLottoNumbers());

        if (compareBasicCase(matchingLottoNumbers)) {
            RealWinning(matchingLottoNumbers, playerPrice);
            return;
        }
        if (compareBonusCase(matchingLottoNumbers, numbers, lotto)) {
            RealWinning(7, playerPrice);
            return;
        }
        if (checkSecondPrizeWinning(matchingLottoNumbers, numbers, lotto)) {
            RealWinning(matchingLottoNumbers, playerPrice);
            return;
        }
    }

    public void RealWinning(int value, PlayerPrice playerPrice) {
        recordWinningCounts(LottoRankingInfo.ONE_MATCH.valueOf(value));
        playerPrice.addWinningMoney(LottoRankingInfo.ONE_MATCH.valueOf(value).getRankWinningPrize());
    }

    public int compareWinningAndPlayerNumbers(List<Integer> playerNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (playerNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void recordWinningCounts(LottoRankingInfo lottoRankingInfo) {
        winningCounts.put(lottoRankingInfo, winningCounts.getOrDefault(lottoRankingInfo, 0) + 1);
    }

    public boolean compareBasicCase(int compareRealWinningNumbers) {
        if (compareRealWinningNumbers == 3 || compareRealWinningNumbers == 4 || compareRealWinningNumbers == 6) {
            return true;
        }
        return false;
    }

    public boolean compareBonusCase(int compareRealWinningNumbers, List<Integer> numbers, Lotto lotto) {
        if (compareRealWinningNumbers == 5 && numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public boolean checkSecondPrizeWinning(int compareRealWinningNumbers, List<Integer> numbers, Lotto lotto) {
        if (compareRealWinningNumbers == 5 && !numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public String extractROI(PlayerPrice playerPrice, int totalPlayerPay) {
        if (playerPrice.getBuyingPay() == 0) {
            return "0.0";
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        return decimalFormat.format((double) totalPlayerPay / playerPrice.getBuyingPay() * 100);
    }
}