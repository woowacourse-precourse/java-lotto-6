package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    public Money changeStringToInt(String str) {
        try{
            return new Money(Integer.parseInt(str));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다.");
        }
    }

    public int calculateCount(int money){
        return money/1000;
    }

    public static HashMap<Integer, Lotto> makeLotto(int count){
        HashMap<Integer, Lotto> lotties = new HashMap<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(makeRandomNumber());
            lotties.put(i, lotto);
        }
        return lotties;
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45,6);
        Collections.sort(numbers);
        return numbers;
    }

    public static WinningNumber getWinningNumbers(String input){
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(input.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));
        return winningNumber;
    }

    public static BonusNumber getBonusNumber(String input) {
        try{
            return new BonusNumber(Integer.parseInt(input));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    public void isDuplicateWithWinningNumbers(BonusNumber bonusNumber, WinningNumber winningNumber) {
        if (winningNumber.getWinningNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public static List<Integer> compare(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber){
        List<Integer> result = new ArrayList<>();
        int match = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (lotto.contains(winningNumbers.get(i))){
                match++;
            }
        }
        result.add(match);
        result.add(0);
        if (lotto.contains(bonusNumber)){
            result.set(1, 1);
        }
        return result;
    }

    public static HashMap<Integer, List<Integer>> calculateCompareResult(int count, HashMap<Integer, Lotto> lotties, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < count; i++) {
            result.put(i, compare(lotties.get(i).getLotto(), winningNumbers, bonusNumber));
        }
        return result;
    }

    public static HashMap<Integer, Integer> calculateFinalResult(HashMap<Integer, List<Integer>> result, int count) {
        HashMap<Integer, Integer> finalResult = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            finalResult.put(i, 0);
        }

        for (int i = 0; i < count; i++) {
            if (result.get(i).get(0) == 3){
                finalResult.put(5, finalResult.get(5) + 1);
            }
            if (result.get(i).get(0) == 4){
                finalResult.put(4, finalResult.get(4) + 1);
            }
            if (result.get(i).get(0) == 5){
                finalResult.put(3, finalResult.get(3) + 1);
            }
            if (result.get(i).get(0) == 5 && result.get(i).get(1) == 1){
                finalResult.put(3, finalResult.get(3) - 1);
                finalResult.put(2, finalResult.get(2) + 1);
            }
            if (result.get(i).get(0) == 6){
                finalResult.put(1, finalResult.get(1) + 1);
            }
        }
        return finalResult;
    }
}
