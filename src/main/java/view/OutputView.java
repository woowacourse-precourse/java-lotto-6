package view;

import static constants.ConstantNumbersManager.FIFTH_INDEX;
import static constants.ConstantNumbersManager.FIRST_INDEX;
import static constants.ConstantNumbersManager.FORTH_INDEX;
import static constants.ConstantNumbersManager.SECOND_INDEX;
import static constants.ConstantNumbersManager.THIRD_INDEX;

import constants.ConstantStringManager;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottoPriceInputNotify() {
        String message = ConstantStringManager.LOTTO_PRICE_INPUT_NOTIFY.getMessage();
        System.out.println(message);
    }

    public void printLottoNumberNotify(int lottoCount) {
        String message = ConstantStringManager.LOTTO_NUMBER_NOTIFY.getMessage();
        System.out.printf(message, lottoCount);
    }

    public void printRandomNumber(List<Integer> randomNumber) {
        System.out.print(ConstantStringManager.LIST_START_MARK.getMessage());
        String result = randomNumber.stream()
                .map(Object::toString)
                .collect(Collectors.joining(ConstantStringManager.LIST_SPLIT_MARK.getMessage()));
        System.out.print(result);
        System.out.print(ConstantStringManager.LIST_END_MARK.getMessage());
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
        System.out.print(ConstantStringManager.WINNING_STATICS_NOTIFY.getMessage());
        System.out.printf(ConstantStringManager.LOTTO_SAME_THREE.getMessage(), staticsValue.get(FIRST_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FOUR.getMessage(), staticsValue.get(SECOND_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FIVE.getMessage(), staticsValue.get(THIRD_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_FIVE_BONUS.getMessage(), staticsValue.get(FORTH_INDEX));
        System.out.printf(ConstantStringManager.LOTTO_SAME_SIX.getMessage(), staticsValue.get(FIFTH_INDEX));
    }

    public void printTotalReturn(double totalReturn) {
        String message = ConstantStringManager.TOTAL_RETURN.getMessage();
        System.out.printf(message, totalReturn);
    }
}

