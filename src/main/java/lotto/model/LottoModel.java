package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoModel {
    private List<List<Integer>> lottoTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Integer> result;

    public LottoModel(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void lottoPlaying() {
        for (int i = 0; i < lottoTickets.size(); i++) {
            List<Integer> lottoTicket = lottoTickets.get(i);
            int sameNumberCount = countSameNumbers(winningNumbers, lottoTicket);
            generateResult(sameNumberCount, lottoTicket);
        }
    }

    private int countSameNumbers(List<Integer> winningNumbers, List<Integer> ticketNumbers) {
        int count = 0;
        for (int number : winningNumbers) {
            if (ticketNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void generateResult(int sameNumberCount, List<Integer> lottoTicket) {
        if (sameNumberCount == 5 && lottoTicket.contains(bonusNumber)) {
            result.set(3, result.get(3) + 1);
        } else if (sameNumberCount >= 3 && sameNumberCount != 6) {
            result.set(sameNumberCount - 3, result.get(sameNumberCount - 3) + 1);
        } else if (sameNumberCount == 6) {
            result.set(4, result.get(4) + 1);
        }
    }

    public List<Integer> getResult() {
        return result;
    }
}
