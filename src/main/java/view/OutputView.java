package view;

import java.util.List;
import enums.ConstantStringManager;
import java.util.stream.Collectors;
public class OutputView {
    static final int FIRST_INDEX = 1;
    static final int SECOND_INDEX = 2;
    static final int THIRD_INDEX = 3;
    static final int FORTH_INDEX = 4;
    static final int FIFTH_INDEX = 5;
    static final String LIST_START_MARK = "[";
    static final String LIST_END_MARK = "]\n";
    static final String LIST_SPLIT_MARK = ", ";

    public void printLottoPriceInputNotify() {
    String message = ConstantStringManager.LOTTO_PRICE_INPUT_NOTIFY.getMessage();
    System.out.println(message);
    }

    public void printLottoNumberNotify(int number) {
        String message = ConstantStringManager.LOTTO_NUMBER_NOTIFY.getMessage();
        System.out.printf(message, number);
    }

    public void printRandomNumber(List<Integer> randomNumber) {
        System.out.print(LIST_START_MARK);
        String result = randomNumber.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LIST_SPLIT_MARK));
        System.out.print(result);
        System.out.print(LIST_END_MARK);
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
        System.out.printf(ConstantStringManager.LOTTO_SAME_THREE.getMessage(), staticsValue.get(FIRST_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FOUR.getMessage(), staticsValue.get(SECOND_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FIVE.getMessage(), staticsValue.get(THIRD_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FIVE_BONUS.getMessage(), staticsValue.get(FORTH_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_SIX.getMessage(), staticsValue.get(FIFTH_INDEX));
    }

    public void printTotalReturn(int totalReturn) {
        String message = ConstantStringManager.TOTAL_RETURN.getMessage();
        System.out.printf(message, totalReturn);
    }
}

