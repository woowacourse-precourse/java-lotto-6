package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private static final int ZERO = 0;
    private static final int FIVE = 5;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private List<Integer> winningLottoTicket = new ArrayList<>();
    private List<Integer> ranks = new ArrayList<>();

    public LottoResult(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        generateWinningLottoTicket(winningNumber, bonusNumber);
        initWinningNumberCounts();
    }

    private void generateWinningLottoTicket(List<Integer> winningNumber, int bonusNumber) {
        winningLottoTicket = new ArrayList<>(winningNumber);
        winningLottoTicket.add(bonusNumber);
    }

    private void initWinningNumberCounts() {
        for (int i = ZERO; i < FIVE; i++) {
            ranks.add(ZERO);
        }
    }

    public List<Integer> compareWithLottoTickets(LottoTickets lottoTickets) {
        for (Lotto lottoTicket : lottoTickets.getLottoTickets()) {
            int matchCount = calculateMatchCount(lottoTicket.getNumbers(), winningLottoTicket);
            if (matchCount == 6) {
                ranks.set(4, ranks.get(4) + 1);
            } else if (matchCount == 7) {
                ranks.set(3, ranks.get(3) + 1);
            } else if (matchCount == 5) {
                ranks.set(2, ranks.get(2) + 1);
            } else if (matchCount == 4) {
                ranks.set(1, ranks.get(1) + 1);
            } else if (matchCount == 3) {
                ranks.set(0, ranks.get(0) + 1);
            }
        }
        return ranks;
    }

    private int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        int bonusMatch = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch += 1;
            }
        }
        if (matchCount == 5 && bonusMatch != 0) {
            matchCount = 7;
        }
        return matchCount;
    }
}
