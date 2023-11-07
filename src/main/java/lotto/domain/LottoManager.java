package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final List<Integer> winningLottoNumbers;
    private final int bonusLottoNumber;
    private Map<Integer, Boolean> matchingCounts;

    public LottoManager(List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
        this.matchingCounts = new HashMap<>();
    }

    public void countMatchingWinningLottoNumbers(LottoBuyer lottoBuyer) {
        List<Lotto> lottoTickets = lottoBuyer.getLottoTickets();
        Map<Integer, Boolean> lottoWinningResults = new HashMap<>();
        for (Lotto lotto : lottoTickets) {
            int count = 0;
            boolean flag = false;
            List<Integer> numbers = lotto.getNumbers();
            for (int winningLottoNumber : winningLottoNumbers) {
                if (numbers.contains(winningLottoNumber)) {
                    count += 1;
                }
                if (numbers.contains(bonusLottoNumber)) {
                    flag = true;
                }
            }
            lottoWinningResults.put(count, flag);
        }
    }

    private List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

}
