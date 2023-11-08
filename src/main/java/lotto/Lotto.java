package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final static int LOTTO_UNIT_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다.");
        }
    }

    int countPurchasedLotto(int totalPrice){
        int count = totalPrice/LOTTO_UNIT_PRICE;
        return count;
    }

    List<Integer> generateSixRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    List<Integer> sortRandomNumber(List<Integer> notSortedNumbers){
        Collections.sort(notSortedNumbers);
        return notSortedNumbers;
    }

    List<List<Integer>> makeLottoNumbersCollection(int count){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for(int i=0; i < count; i++){
            List<Integer> randomNumbers = generateSixRandomNumber();
            lottoNumbers.add(randomNumbers);
        }
        for(List<Integer> notSortedNumbers: lottoNumbers){
            notSortedNumbers = sortRandomNumber(notSortedNumbers);
        }
        return lottoNumbers;
    }

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
}
