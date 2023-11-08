package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.SplitLottoNumber;

public class InputView {

    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static List<String> inputWiningLottoNumbers(){
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
        return SplitLottoNumber.splitLottoNumber(Console.readLine());
    }

    public static String inputWiningBonusLottoNumber(){
        System.out.println();
        System.out.println(INPUT_WINNING_BONUS_LOTTO_NUMBER);
        return Console.readLine();
    }
}
