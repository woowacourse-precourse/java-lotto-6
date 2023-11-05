package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import lotto.utils.Message;

public class LottoManager {
    private ArrayList<Lotto> lottos;
    private Map<Integer, Integer> winningNumbers;
    private WinningStatistics winningStatistics;

    public LottoManager() {
        lottos = new ArrayList<>();
    }

    public void issueLottos(int lottoCount) {
        
    }

    public void setWinningNumbers(Map<Integer, Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Iterator<Lotto> getLottoListIterator() {
        return lottos.iterator();
    }

    public void isDuplicatedBonusNumber(int bonusNumber) {
        if (winningNumbers.containsKey(bonusNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}
