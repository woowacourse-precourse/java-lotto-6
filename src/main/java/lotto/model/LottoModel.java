package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoModel {
    private List<List<Integer>> lottoTickets;
    private List<Integer> LottoNumbers;
    private int bonusNumber;
    private List<Integer> lucky;

    public LottoModel(List<List<Integer>> lottoTickets, List<Integer> LottoNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.LottoNumbers = LottoNumbers;
        this.bonusNumber = bonusNumber;
        this.lucky = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void lottoPlaying() {
        for (int i = 0; i < lottoTickets.size(); i++) {
            int sameNumberCount = countSameNumbers(LottoNumbers, lottoTickets.get(i));

            if (sameNumberCount >= 3 && sameNumberCount != 5) {
                lucky.set(sameNumberCount - 3, lucky.get(sameNumberCount - 3) + 1);
            }
            if (sameNumberCount == 5 && !lottoTickets.get(i).contains(bonusNumber)) {
                lucky.set(2, lucky.get(2) + 1);
            }
            if (sameNumberCount == 5 && lottoTickets.get(i).contains(bonusNumber)) {
                lucky.set(3, lucky.get(4) + 1);
            }
        }
    }

    private int countSameNumbers(List<Integer> userNumbers, List<Integer> ticketNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (ticketNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getLucky() {
        return lucky;
    }
}
