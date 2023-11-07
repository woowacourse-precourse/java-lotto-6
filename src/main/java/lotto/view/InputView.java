package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.util.Message.*;

public class InputView {


    public static String inputPrice() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static String inputPrizeNumber() {
        System.out.println(INPUT_LOTTO_PRIZE);
        return Console.readLine();
    }

    public static String inputBonus() {
        System.out.println(INPUT_LOTTO_BONNER);
        return Console.readLine();
    }


}


