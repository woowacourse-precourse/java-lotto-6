package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.view.InputView.inputBonusNumberView;
import static lotto.view.InputView.inputLottoNumberView;

public class Util {
    private static final int ONE = 1;
    private static final int ZERO = 0;

    private Util(){}    // 생성자 생성 방지
    public static String inputPrice(){
        String price;
        InputView.priceInputView();
        price = Console.readLine();

        return price;
    }

    public static int countLotto(int price){
        return price / 1000;
    }

    public static Lotto createRandomNumbers(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return new Lotto(numbers);
    }

    public static List<Integer> inputWinningNumbers(){
        inputLottoNumberView();
        String word = Console.readLine();
        return makeInteger(word);
    }

    public static List<Integer> makeInteger(String word){
        List<String> numbersStr = Arrays.asList(word.split(","));
        List<Integer> numbersInt = new ArrayList<>();
        for (String numberStr : numbersStr) {
            Integer numberInt = Integer.parseInt(numberStr);
            numbersInt.add(numberInt);
        }
        return numbersInt;
   }

    public static int inputBonusNumber(){
        inputBonusNumberView();
        String bn = Console.readLine();
        return Integer.parseInt(bn);
    }

    public static List<Integer> sortList(List<Integer> lotto){
        List<Integer> sortedLotto = new ArrayList<Integer>(lotto);
        Collections.sort(sortedLotto);
        return sortedLotto;
    }


}