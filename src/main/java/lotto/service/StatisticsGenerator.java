package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningCombination;

import java.util.*;

public class StatisticsGenerator {
    private static final List<String> STATISTICS_KEY_NAME= List.of(
            "matchesThree",
            "matchesFour",
            "matchesFive",
            "matchesFiveAndBonus",
            "matchesSix"
    );

    private final Lottos lottos;
    private final WinningCombination winningCombination;

    private List<Integer> matchesCounts;

    public StatisticsGenerator(Lottos lottos, WinningCombination winningCombination){
        this.lottos = lottos;
        this.winningCombination = winningCombination;
    }

    public Map<String, Integer> generateMatchesCount() {
        generateMatchesCounts();

        Map<String, Integer> statisticsMatchesCounts = new HashMap<>();
        for (int i = 0; i < STATISTICS_KEY_NAME.size(); i++) {
            statisticsMatchesCounts.put(STATISTICS_KEY_NAME.get(i), matchesCounts.get(i));
        }
        return statisticsMatchesCounts;
    }

    private void generateMatchesCounts(){
        matchesCounts = new ArrayList<>(Collections.nCopies(5, 0));

        for(Lotto lotto : lottos.getLottos()){
            int plusIndex=indexOfMatchCounts(lotto);
            if(plusIndex>=0){
                matchesCounts.set(plusIndex,matchesCounts.get(plusIndex)+1);
            }
        }
    }

    private int indexOfMatchCounts(Lotto lotto){
        int matchesCount=0;
        for(int lottoNumber : lotto.getNumbers()){
            if(isMatchWinningNumber(lottoNumber,winningCombination)){
                matchesCount++;
            }
        }
        return statisticsIndex(lotto,matchesCount);
    }

    private int statisticsIndex(Lotto lotto, int matchesCount){
        if(matchesCount==3) return 0; //matchesThree
        if(matchesCount==4) return 1; //matchesFour
        if(matchesCount==5) {
            if(isMatchBonusNumber(lotto)) return 3; //matchesFiveAndBonus
            return 2; //matchesFive
        }
        if(matchesCount==6) return 4; //matchesSix
        return -1; // no matches
    }

    private boolean isMatchBonusNumber(Lotto lotto){
        return lotto.getNumbers().contains(winningCombination.getBonusNumber());
    }

    private boolean isMatchWinningNumber(int lottoNumber, WinningCombination WinningCombination){
        return WinningCombination.getWinningNumbers().contains(lottoNumber);
    }
}
