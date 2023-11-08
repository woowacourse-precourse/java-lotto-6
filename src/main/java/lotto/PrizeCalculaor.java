package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrizeCalculaor {
    private final static int THREE_WINNING_PRIZE = 5000;
    private final static int FOUR_WINNING_PRIZE = 50000;
    private final static int FIVE_WINNING_PRIZE = 15000000;
    private final static int FIVE_BONUS_WINNING_PRIZE = 30000000;
    private final static int SIX_WINNING_PRIZE = 2000000000;

    int countThreeMatches(List<List<Integer>> lottoNumbersCollection, List<Integer> winningNumbers){
        int count = 0;
        for(List<Integer> lottoNumbers : lottoNumbersCollection){
            List<Integer> copyOfLottoNumbers = new ArrayList<>(lottoNumbers);
            copyOfLottoNumbers.retainAll(winningNumbers);
            if(copyOfLottoNumbers.size() == 3){
                count++;
            }
        }
        return count;
    }

    int countFourMatches(List<List<Integer>> lottoNumbersCollection, List<Integer> winningNumbers){
        int count = 0;
        for(List<Integer> lottoNumbers : lottoNumbersCollection){
            List<Integer> copyOfLottoNumbers = new ArrayList<>(lottoNumbers);
            copyOfLottoNumbers.retainAll(winningNumbers);
            if(copyOfLottoNumbers.size() == 4){
                count++;
            }
        }
        return count;
    }

    int countFiveMatches(List<List<Integer>> lottoNumbersCollection, List<Integer> winningNumbers){
        int count = 0;
        for(List<Integer> lottoNumbers : lottoNumbersCollection){
            List<Integer> copyOfLottoNumbers = new ArrayList<>(lottoNumbers);
            copyOfLottoNumbers.retainAll(winningNumbers);
            if(copyOfLottoNumbers.size() == 5){
                count++;
            }
        }
        return count;
    }

    int countSixMatches(List<List<Integer>> lottoNumbersCollection, List<Integer> winningNumbersExceptBonus){
        int count = 0;
        for(List<Integer> lottoNumbers : lottoNumbersCollection){
            List<Integer> copyOfLottoNumbers = new ArrayList<>(lottoNumbers);
            copyOfLottoNumbers.retainAll(winningNumbersExceptBonus);
            if(copyOfLottoNumbers.size() == 6){
                count++;
            }
        }
        return count;
    }

    int countFiveBonusMatches(List<List<Integer>> lottoNumbersCollection, List<Integer> winningNumbersExecptBonus, int bonusNumber){
        int count = 0;
        for(List<Integer> lottoNumbers : lottoNumbersCollection){
            List<Integer> copyOfLottoNumbers = new ArrayList<>(lottoNumbers);
            copyOfLottoNumbers.retainAll(winningNumbersExecptBonus);
            if(copyOfLottoNumbers.size() == 5 && copyOfLottoNumbers.contains(bonusNumber)){
                count++;
            }
        }
        return count;
    }

    List<Integer> makeWinningCountCollection(List<List<Integer>> lottoNumbersCollection, List<Integer> winningNumbers,List<Integer> winningNumbersExecptBonus, int bonusNumber){
        List<Integer> winningCount = new ArrayList<>();
        winningCount.add(countThreeMatches(lottoNumbersCollection, winningNumbers));
        winningCount.add(countFourMatches(lottoNumbersCollection,winningNumbers));
        winningCount.add(countFiveMatches(lottoNumbersCollection,winningNumbers));
        winningCount.add(countFiveBonusMatches(lottoNumbersCollection,winningNumbersExecptBonus,bonusNumber));
        winningCount.add(countSixMatches(lottoNumbersCollection,winningNumbersExecptBonus));
        return winningCount;
    }

    List<Integer> combineWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int BonusNumber){
        List<Integer> winningNumbersWithBonus = winningNumbers;
        winningNumbersWithBonus.add(BonusNumber);
        return winningNumbersWithBonus;
    }

    List<Integer> calculatePrize(List<Integer> countsOfWonLotto){
        List<Integer> prizes = new ArrayList<>();
        prizes.add(countsOfWonLotto.get(0)*THREE_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(1)*FOUR_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(2)*FIVE_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(3)*FIVE_BONUS_WINNING_PRIZE);
        prizes.add(countsOfWonLotto.get(4)*SIX_WINNING_PRIZE);
        return prizes;
    }

    int calculateTotalPrize(List<Integer> countsOfWonLotto){
        List<Integer> prizes = calculatePrize(countsOfWonLotto);
        int totalPrize = prizes.stream().reduce(0, Integer::sum);
        return totalPrize;
    }

    float calculateProfitRate(int totalPrize, int purchasingPrice){
        return ((float) totalPrize / purchasingPrice) * 100;
    }
}
