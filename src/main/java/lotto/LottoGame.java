package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    final static int START_NUMBER = 1;
    final static int END_NUMBER = 45;
    final static int COUNT_NUMBER = 6;
    static int lottoCnt;
    public static int issuanceLotto(int money){
        lottoCnt = money/1000;
        return lottoCnt;
    }

    public static List<List<Integer>> getLottoBundle(){
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            tickets.add(getRandomNumbers());
        }
        Output.checkLottoNumberMessage(tickets);
        return tickets;
    }



    public static List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER,END_NUMBER,COUNT_NUMBER);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public static List<Integer> MakeWinningNumbers(String winningNumbers) {
        List<Integer> winningNumbersList = new ArrayList<>();
        String[] splitNumbers = winningNumbers.split(",");

        for (int i = 0; i < Input.LOTTO_WINNING_NUMBER_COUNT; i++) {
            winningNumbersList.add(Integer.parseInt(splitNumbers[i]));
        }

        return winningNumbersList;
    }

    public static int getTwoNumbers(List<Integer> winningNumbers, List<List<Integer>> userNumbersBundle, int bonus){
        int equalNumCount = 0;
        for (List<Integer> userNumbersUnit : userNumbersBundle) {
            equalNumCount = compareNumbers(winningNumbers, userNumbersUnit, bonus);
        }

        return equalNumCount;
    }

    public static void CompareNumbers(List<Integer> winningNumbers, List<Integer> userNumberUnit, int bonus){

    }
}
