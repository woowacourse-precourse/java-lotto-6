package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.WildcardType;
import lotto.Model.Lotto;
import lotto.Model.Price;
import lotto.Model.PriceValidator;
import lotto.Model.WinningLotto;
//import lotto.Model.WinningLottoValidator;

public class InputView {

    public static String inputPriceForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();

    }
}
