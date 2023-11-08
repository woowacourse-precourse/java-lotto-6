package model;

import lotto.Lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningPriceResult {
    private final Map<WinningPrice, Integer> winningPriceResult;

    public WinningPriceResult() {
        winningPriceResult = new EnumMap<WinningPrice, Integer>(WinningPrice.class);
        Arrays.stream(WinningPrice.values())
                .forEach(winningPrice -> winningPriceResult.put(winningPrice, 0));
    }

    public void calcWinningPriceResult(LotteryNumbers lotteryNumbers, LottoObjectManagement lottoObjectManagement) {
        for (Lotto lotto : lottoObjectManagement.getObjectManagement()) {
            WinningPrice winningPrice = WinningPrice.winningPrice(lotto.getCorrectLottoNumber(lotteryNumbers),
                    lotto.isContain(lotteryNumbers.getBonusNumber()));
            updateWinningPriceCount(winningPrice);
        }
    }

    private void updateWinningPriceCount(WinningPrice winningPrice) {
        winningPriceResult.put(winningPrice, winningPriceResult.get(winningPrice) + 1);
    }

    public Integer getWininngPriceCount(WinningPrice winningPrice) {
        return winningPriceResult.get(winningPrice);
    }
}