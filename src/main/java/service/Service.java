package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.Rank;
import domain.WinningNumber;
import utility.Utility;
import validator.Validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Service {
    final static int THOUSAND = 1000;
    final static int PERCENT = 100;
    Validator validator = new Validator();

    public int getMoneyByUserInput(String input) {
        validator.checkIsNumber(input);
        int money = Integer.parseInt(input);
        validator.checkMinMoney(money);
        validator.checkMaxMoney(money);
        validator.checkDividedByThousand(money);
        return money;
    }

    public List<Lotto> generateLotto(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(Utility.sortAscending(generateRandomNumbers()));
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public int calculateNumberOfLottoTicket(int money) {
        return money / THOUSAND;
    }

    public List<Integer> getWinNumbersByUserInput(String input) {
        validator.checkStartOrEndWithComma(input);
        List<String> splitNumbers = Utility.splitByComma(input);
        validator.checkCount(splitNumbers);
        return generateWinNumbers(splitNumbers);
    }

    private List<Integer> generateWinNumbers(List<String> splitNumbers) {
        List<Integer> winNumbers = new ArrayList<Integer>();
        for (String splitNumber : splitNumbers) {
            validator.checkIsNumber(splitNumber);
            int number = Integer.parseInt(splitNumber);
            validator.checkNumberRange(number);
            validator.checkDuplicateNumber(winNumbers,number);
            winNumbers.add(number);
        }
        return winNumbers;
    }

    public int getBonusNumberByUserInput(String input, List<Integer> winNumbers) {
        validator.checkIsNumber(input);
        int number = Integer.parseInt(input);
        validator.checkNumberRange(number);
        validator.checkDuplicateNumber(winNumbers, number);
        return number;
    }

    public LinkedHashMap getLottoResult(List<Lotto> lottos, WinningNumber winningNumber){
        LinkedHashMap<Rank,Integer> result = new LinkedHashMap<Rank,Integer>();
        for(Rank rank : Rank.values()){
            result.put(rank,0);
        }
        for(Lotto lotto : lottos){
            Rank rank = getTicketRank(lotto, winningNumber);
            result.put(rank,result.get(rank)+1);
        }
        return result;
    }

    private Rank getTicketRank(Lotto lotto , WinningNumber winningNumber){
        int countMatch = winningNumber.countMatch(lotto);
        boolean isMatchBonusNumber = winningNumber.isMatchBonusNumber(lotto);
        return Rank.checkTicketRank(countMatch,isMatchBonusNumber);
    }

    public float calculateRateOfReturn(LinkedHashMap<Rank,Integer>  lottoResult, int money) {
        return (float)calculateSumOfPrizeMoney(lottoResult) / money * PERCENT;
    }
    private long calculateSumOfPrizeMoney(LinkedHashMap<Rank,Integer> lottoResult){
        long sum = 0;
        for(Map.Entry<Rank,Integer> set : lottoResult.entrySet()){
            sum += set.getKey().getPrizeMoney() * set.getValue();
        }
        return sum;
    }

}
