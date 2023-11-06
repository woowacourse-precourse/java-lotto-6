package lotto.controller;

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

    private List<Integer> matchesCounts;

    public Map<String, Integer> generateMatchesCount(Lottos lottos, WinningCombination winningCombination) {
        generateMatchesCounts(lottos, winningCombination);

        Map<String, Integer> statisticsMatchesCounts = new HashMap<>();
        for (int i = 0; i < STATISTICS_KEY_NAME.size(); i++) {
            statisticsMatchesCounts.put(STATISTICS_KEY_NAME.get(i), matchesCounts.get(i));
        }
        return statisticsMatchesCounts;
    }

    private void generateMatchesCounts(Lottos lottos, WinningCombination winningCombination){
        matchesCounts = new ArrayList<>(Collections.nCopies(5, 0));

        for(Lotto lotto : lottos.getLottos()){
            int plusIndex=indexOfMatchCounts(lotto,winningCombination);
            if(plusIndex>=0){
                matchesCounts.set(plusIndex,matchesCounts.get(plusIndex)+1);
            }
        }
    }

    private int indexOfMatchCounts(Lotto lotto, WinningCombination winningCombination){
        int matchesCount=0;
        int inputStatisticsIndex =-1;
        for(int lottoNumber : lotto.getNumbers()){
            if(isMatchWinningNumber(lottoNumber,winningCombination)){
                matchesCount++;
            }
        }

        switch (matchesCount) {
            case 0,1,2:
                inputStatisticsIndex= -1; //no match
                break;
            case 3:
                inputStatisticsIndex= 0; //matchesThree
                break;
            case 4:
                inputStatisticsIndex= 1; //matchesFour
                break;
            case 5:
                if(isMatchBonusNumber(lotto,winningCombination.getBonusNumeber())){
                    inputStatisticsIndex= 3; //matchesFiveAndBonus
                    break;
                }
                inputStatisticsIndex=  2; //matchesFive
                break;
            case 6:
                inputStatisticsIndex=  4; //matchesSix
                break;
        }
        return inputStatisticsIndex;
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }

    private boolean isMatchWinningNumber(int lottoNumber, WinningCombination WinningCombination){
        return WinningCombination.getWinningNumbers().contains(lottoNumber);
    }
}
