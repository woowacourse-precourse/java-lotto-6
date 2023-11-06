package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomizedException;

public class InputView {


    public static int getLottoPrice() {
        int LottoPrice;
        while (true) {
            try {
                LottoPrice = Integer.parseInt(Console.readLine());
                CustomizedException.NotDivisibleByThousandException(LottoPrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return LottoPrice;
    }
}
