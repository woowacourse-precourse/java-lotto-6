package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.WinningPrize.*;

public class WinningDetails {

    private Map<WinningPrize, Integer> winningStatus = new HashMap<>();

    public WinningDetails() {
        winningStatus.put(FIRST_PRIZE, 0);
        winningStatus.put(SECOND_PRIZE, 0);
        winningStatus.put(THIRD_PRIZE, 0);
        winningStatus.put(FOURTH_PRIZE, 0);
        winningStatus.put(FIFTH_PRIZE, 0);
    }

    public Map<WinningPrize, Integer> compareWinningNumber(List<Integer> playerNumber, List<Lotto> winningNumber) {

        WinningPrize winningPrize;

        for (int i = 0; i < winningNumber.size(); i++) {
            int matchedCount = 0;

            for (int j = 0; j < playerNumber.size(); j++) {
                if (playerNumber.get(j) == winningNumber.get(i).getNumbers().get(j)) {
                    matchedCount++;
                }
            }

            if (matchedCount == 3) {
                winningPrize = WinningPrize.values()[4];
                winningStatus.put(winningPrize, winningStatus.get(winningPrize) + 1);
            }
            if (matchedCount == 4) {
                winningPrize = WinningPrize.values()[3];
                winningStatus.put(winningPrize, winningStatus.get(winningPrize) + 1);
            }
            if (matchedCount == 5) {
                winningPrize = WinningPrize.values()[2];
                winningStatus.put(winningPrize, winningStatus.get(winningPrize) + 1);
            }
            if (matchedCount == 6) {
                winningPrize = WinningPrize.values()[0];
                winningStatus.put(winningPrize, winningStatus.get(winningPrize) + 1);
            }

        }
        return winningStatus;
    }



}
