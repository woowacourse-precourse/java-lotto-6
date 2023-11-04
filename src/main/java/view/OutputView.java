package view;

import java.util.List;
import enums.ConstantStringManager;
public class OutputView {
    final int firstIndex = 1;
    final int secondIndex = 2;
    final int thirdIndex = 3;
    final int forthIndex = 4;
    final int fifthIndex = 5;
    public void printLottoPriceInputNotify() {
    String message = ConstantStringManager.LOTTO_PRICE_INPUT_NOTIFY.getMessage();
    System.out.println(message);
    }

    public void printLottoNumberNotify(int number) {
        String message = ConstantStringManager.LOTTO_NUMBER_NOTIFY.getMessage();
        System.out.printf(message, number);
    }

    public void printWinningNumberInputNotify() {
        String message = ConstantStringManager.WINNING_NUMBER_INPUT_NOTIFY.getMessage();
        System.out.println(message);
    }

    public void printBonusNumberInputNotify() {
        String message = ConstantStringManager.BONUS_NUMBER_INPUT_NOTIFY.getMessage();
        System.out.println(message);
    }

    public void printWinningStatics(List<Integer> staticsValue) {
        System.out.print(ConstantStringManager.WINNING_STATICS_NOTIFY);
        System.out.printf(ConstantStringManager.LOTTO_SAME_THREE.getMessage(), staticsValue.get(firstIndex));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FOUR.getMessage(), staticsValue.get(secondIndex));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FIVE.getMessage(), staticsValue.get(thirdIndex));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FIVE_BONUS.getMessage(), staticsValue.get(forthIndex));
        System.out.printf(ConstantStringManager.LOTTO_SAME_SIX.getMessage(), staticsValue.get(fifthIndex));
    }
}
