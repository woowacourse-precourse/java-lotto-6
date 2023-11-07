package lotto.domain;

import lotto.constant.PrizeMoney;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final WinningInfo winningInfo;
    private final Map<String, Integer> prize;
    private int matchNumbers;
    private boolean matchBonus;

    private long prizeMoney;

    public GameResult(WinningInfo winningInfo) {

        this.winningInfo = winningInfo;
        matchNumbers = 0;
        matchBonus = false;

        prize = new HashMap<>();

        makePrizeInfo(prize);
    }

    private void makePrizeInfo(Map<String, Integer> prize) {

        prize.put("1등", 0);
        prize.put("2등", 0);
        prize.put("3등", 0);
        prize.put("4등", 0);
        prize.put("5등", 0);
    }

    public void matchPurchasedLottos(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {
            for (int num : lotto.getNumbers()) {

                compareNumbers(num);
            }
            makeGameResult();
        }

        calculatePrizeMoney();
    }

    private void compareNumbers(int num) {

        List<Integer> winningNumbers = winningInfo.getWinningNumbers();
        int bonusNumber = winningInfo.getBonusNumber();

        for (int winningNumber : winningNumbers) {

            if (winningNumber == num) {

                matchNumbers += 1;
            }

            if (bonusNumber == num) {

                matchBonus = true;
            }
        }
    }

    private void makeGameResult() {

        if (matchNumbers == 6) {

            prize.put("1등", prize.get("1등") + 1);
        }

        if (matchNumbers == 5 && matchBonus) {

            prize.put("2등", prize.get("2등") + 1);
        }

        if (matchNumbers == 5 && !matchBonus) {

            prize.put("3등", prize.get("3등") + 1);
        }

        if (matchNumbers == 4) {

            prize.put("4등", prize.get("4등") + 1);
        }

        if (matchNumbers == 3) {

            prize.put("5등", prize.get("5등") + 1);
        }

        matchNumbers = 0;
        matchBonus = false;

    }

    private void calculatePrizeMoney() {

        long firstPrize = Long.parseLong(PrizeMoney.FIRST.replaceAll("\\,", ""));
        long secondPrize = Long.parseLong(PrizeMoney.SECOND.replaceAll("\\,", ""));
        long thirdPrize = Long.parseLong(PrizeMoney.THIRD.replaceAll("\\,", ""));
        long forthPrize = Long.parseLong(PrizeMoney.FORTH.replaceAll("\\,", ""));
        long fifthPrize = Long.parseLong(PrizeMoney.FIFTH.replaceAll("\\,", ""));

        prizeMoney = firstPrize * prize.get("1등") +
                     secondPrize * prize.get("2등") +
                     thirdPrize * prize.get("3등") +
                     forthPrize * prize.get("4등") +
                     fifthPrize * prize.get("5등");
    }

    public long getPrizeMoney() {

        return prizeMoney;
    }

    public Map<String, Integer> getPrize() {

        return prize;
    }
}
