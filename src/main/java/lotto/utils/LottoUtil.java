package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoUtil {
    final String NUM_REG = "[0-9]+";

    public String getUserInput() {
        return Console.readLine();
    }

    public List<List<Integer>> getLottos(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(numbers);
        }
        return lottos;
    }

    public boolean validateNumberCheck(String number) {
        String deleteCommaNumber = number.replaceAll(",", "").replaceAll(" ", "");
        if(!deleteCommaNumber.matches(NUM_REG)) {
            ExceptionMessage.WINNING_NUMBER.printValue();
            return false;
        }
        return true;
    }

    public List<Integer> convertNumbers(String number) {
        List<String> numbers = new ArrayList<>(Arrays.asList(number.replaceAll(" ","").split(",")));
        numbers.removeIf(String::isEmpty);
        return  numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> deleteDupliNumber = new HashSet<>(numbers);
        if(numbers.size() != deleteDupliNumber.size()) {
            ExceptionMessage.WINNING_NUMBER_DUPLICATE.printValue();
            return false;
        }
        return true;
    }

    public List<Integer> calculateVariance(List<Integer> winningLotto, List<Integer> myLotto, int bonusNumber) {
        int sameNumber = 0;
        int sameBonusNumber = 0;
        for (Integer myNum : myLotto) {
            if(isSameBonusNumber(myNum, bonusNumber)) {
                sameBonusNumber++;
                continue;
            }
            if(isSameNumber(winningLotto, myNum)) {
                sameNumber++;
                continue;
            }
        }
        return List.of(sameNumber, sameBonusNumber);
    }

    public boolean isSameBonusNumber(int myNum, int bonusNumber) {
        return myNum == bonusNumber;
    }

    public boolean isSameNumber(List<Integer> winningLotto, int myNum) {
        for (Integer winNum : winningLotto) {
            if(myNum == winNum) {
                return true;
            }
        }
        return false;
    }

    public String getStatisticsMessage(String num) {
        if("3".equals(num)){
            return StatisticsMessage.THREE.getMessage();
        }
        if("4".equals(num)){
            return StatisticsMessage.FOUR.getMessage();
        }
        if("5".equals(num)){
            return StatisticsMessage.FIVE.getMessage();
        }
        if("6".equals(num)){
            return StatisticsMessage.SIX.getMessage();
        }
        return StatisticsMessage.FIVE_AND_BONUS.getMessage();
    }

    public int getStatisticsValue(String num) {
        if("3".equals(num)){
            return StatisticsMessage.THREE.getValue();
        }
        if("4".equals(num)){
            return StatisticsMessage.FOUR.getValue();
        }
        if("5".equals(num)){
            return StatisticsMessage.FIVE.getValue();
        }
        if("6".equals(num)){
            return StatisticsMessage.SIX.getValue();
        }
        return StatisticsMessage.FIVE_AND_BONUS.getValue();
    }
}
