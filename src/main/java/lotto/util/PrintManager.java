package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class PrintManager {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printInputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS);
    }

    public static void printBonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printIllegalArgumentExceptionWinLotto(){
        System.out.println(ErrorMessage.ILLEGAL_ARGUMENT_WIN_LOTTO.getMessage());
    }

    public static void printPickedLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for(int i = 0 ; i < numbers.size()-1 ; i++)
            System.out.print(numbers.get(i) + ", ");
        System.out.print(numbers.get(numbers.size()-1));
        System.out.println("]");
    }
}
