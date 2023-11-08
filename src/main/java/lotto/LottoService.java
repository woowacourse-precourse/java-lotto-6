package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    public List<List<Integer>> numbersList = new ArrayList<>();
    public Lotto lotto;

    public void saveWinNumber(String winNumber){
        List<String> tempNumbers = Arrays.asList(winNumber.split(","));
        List<Integer> numbers = new ArrayList<>();
        for(String number: tempNumbers){
            numbers.add(Integer.parseInt(number));
        }
        lotto = new Lotto(numbers);
    }

    public List<Integer> createLottoList(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        List<Integer> sortedNumbers = randomNumbers.stream()
                                                    .sorted()
                                                    .collect(Collectors.toList());
        numbersList.add(sortedNumbers);
        return sortedNumbers;
    }

    public void compareWinNumber(List<Integer> numbers, int bonusNumber){
        for(List<Integer> randomNumbers: numbersList){
            compare(randomNumbers, numbers, bonusNumber);
        }
    }

    public void compare(List<Integer> numberList, List<Integer> numbers, int bonusNumber){
        int number = 0;
        boolean bonus = false;
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                number = compareEach(numberList, numbers, i, j, number);
            }
        }
        for(int i=0; i<6; i++){
            if(numbers.get(i) == bonusNumber){
                bonus = true;
            }
        }
        setWinStatistic(number, bonus);
    }

    public int compareEach(List<Integer> numberList, List<Integer> numbers, int i, int j, int number){
        if(numberList.get(i).equals(numbers.get(j))){
            number++;
        }
        return number;
    }

    public void setWinStatistic(int number, boolean bonus){
        if(number == 3){
            Ranking.FIFTH.setRankingNumber(1);
        } else if(number == 4){
            Ranking.FOURTH.setRankingNumber(1);
        } else if(number == 5 && !bonus){
            Ranking.THIRD.setRankingNumber(1);
        } else if(number == 5 && bonus){
            Ranking.SECOND.setRankingNumber(1);
        } else if(number ==6){
            Ranking.FIRST.setRankingNumber(1);
        }
    }

    public double calculateProfit(int price){
        int profit = Ranking.FIFTH.getRankingNumber() * 5000 +
                Ranking.FOURTH.getRankingNumber() * 50000 +
                Ranking.THIRD.getRankingNumber() * 1500000 +
                Ranking.SECOND.getRankingNumber() * 30000000 +
                Ranking.FIRST.getRankingNumber() * 2000000000;
        double percentage = (double) profit /price * 100;
        return percentage;
    }

}
