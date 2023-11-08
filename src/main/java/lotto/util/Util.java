package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Util {
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
}
