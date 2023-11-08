package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.Util.Paser.createWinningLotto;
import static lotto.Util.Validate.validateTypeInt;

public class InputView {
    private static final String INPUT_LOTTO_BUY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void inputPlayerPayMessage(){
        System.out.println(INPUT_LOTTO_BUY);
    }
    public static String inputPlayerPay() {
        return Console.readLine();
    }

    public static void inputLottoWinningNumMessage() {
        System.out.println(INPUT_LOTTO_WINNING);
    }

    public static List<Integer> inputLottoWinningNum() {
        return createWinningLotto(Console.readLine());
    }

    public static void inputBonusNumberMessage(){
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static int inputBonusNumber() {
        return validateTypeInt(Console.readLine());
    }
}