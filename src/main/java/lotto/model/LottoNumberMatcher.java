package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static lotto.model.Utilities.inputNumberSet;

public class LottoNumberMatcher {
    private void WinningNumbersSet(String input) {
        inputNumberSet(input);
    }
    private final int SUM_WINNING_NUMBER_SIZE_LOTTO_NUMBER_SIZE = 12;

    public LottoNumberMatcher() {
        LotteryPrize firstPrize = LotteryPrize.FIRST;
        LotteryPrize secondPrize = LotteryPrize.SECOND;
        LotteryPrize thirdPrize = LotteryPrize.THIRD;
        LotteryPrize fourthPrize = LotteryPrize.FOURTH;
        LotteryPrize fifthPrize = LotteryPrize.FIFTH;
    }

    public void checkWinning(ArrayList<Lotto> myLottoNumbers, String winningNumber, String bonusNumber) {
        for (Lotto myLottoNumber : myLottoNumbers) {
            System.out.println(myLottoNumber);
        }
    }

    public static Set<Integer> stringToIntegerSet(String inputNumber) {
        Set<Integer> numbersSet = new HashSet<>();
        String[] numbersArray = inputNumber.split(",");
        for (String number : numbersArray) {
            numbersSet.add(Integer.parseInt(number.trim()));
        }
        return numbersSet;
    }
}
