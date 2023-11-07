package lotto.service;

import static lotto.view.IO.showResults;
import static lotto.view.constants.Front.SHOW_THE_WINNING_STATISTICS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.view.constants.Front;

public class Checker {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final BonusNumber bonusNumber;
    private final WinningNumbers winningNumbers;
    private final List<Lotto>lottoTickets;

    private final Integer[]matchs;

    public Checker(BonusNumber bonusNumber, WinningNumbers winningNumbers, List<Lotto>lottoTickets) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
        this.lottoTickets = lottoTickets;
        matchs = new Integer[LOTTO_NUMBERS_SIZE+2];
    }

    public void checkLottoTickets(){
        Arrays.fill(matchs, 0);
        for(int i = 0; i< lottoTickets.size();i++){
            if(isMatch(lottoTickets.get(i)) == 5)
                isBonusMatch(lottoTickets.get(i));
        }
        showResults(SHOW_THE_WINNING_STATISTICS, matchs);
    }
    private int isMatch(Lotto lotto){
        Set<Integer> win = new HashSet<>(winningNumbers.getWinningNumbers());
        win.addAll(lotto.getNumbers());
        int match = 2* LOTTO_NUMBERS_SIZE - win.size();
        matchs[match]++;
        return match;
    }
    private void isBonusMatch(Lotto lotto){
        List<Integer>temp = lotto.getNumbers();
        for(int i=0;i<LOTTO_NUMBERS_SIZE;i++){
            if(temp.get(i) == bonusNumber.getBonusNumber()) {
                matchs[5]--;
                matchs[7]++;
                break;
            }
        }
    }
}
