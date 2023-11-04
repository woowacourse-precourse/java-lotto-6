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
            int sameNumberCount = countSameNumbers(winningNumbers, lottoTickets.get(i));

            if (sameNumberCount >= 3 && sameNumberCount != 5) {
                result.set(sameNumberCount - 3, result.get(sameNumberCount - 3) + 1);
            }
            if (sameNumberCount == 5 && !lottoTickets.get(i).contains(bonusNumber)) {
                result.set(2, result.get(2) + 1);
            }
            if (sameNumberCount == 5 && lottoTickets.get(i).contains(bonusNumber)) {
                result.set(3, result.get(4) + 1);
            }
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

    public List<Integer> getResult() {
        return result;
    }
}
