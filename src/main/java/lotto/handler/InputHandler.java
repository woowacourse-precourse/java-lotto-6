package lotto.handler;

import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;
import static lotto.message.SystemMessage.OUTPUT_BONUS_NUMBER;
import static lotto.message.SystemMessage.OUTPUT_WINNING_NUMBERS;
import static lotto.view.InputView.read;

import java.util.List;
import lotto.util.InputUtil;
import lotto.validator.InputValidator;
import lotto.view.OutputView;

public class InputHandler {

    private InputHandler() {
    }

    public static int setLottoPurchasePrice() {
        while (true) {
            try {
                String input = inputLottoPurchasePrice();

                InputValidator.validateIsNumber(input);
                int lottoPurchasePrice = InputUtil.parseInt(input);

                InputValidator.validateIsMultiplesOfSingleLottoPrice(lottoPurchasePrice);
                return lottoPurchasePrice;
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    public static List<Integer> setWinningNums(){
        while (true) {
            try{
                String input = inputWinningNums();

                List<String> splitInput = InputUtil.splitInput(input);
                InputValidator.validateIsNumbers(splitInput);

                List<Integer> winningNums = InputUtil.parseNums(splitInput);

                InputValidator.validateInLottoRange(winningNums);
                InputValidator.validateIsLottoSize(winningNums);
                InputValidator.validateUniqueNumbers(winningNums);

                return winningNums;
            } catch (IllegalArgumentException e){
                OutputView.print(e.getMessage());
            }
        }
    }

    public static int setBonusNum(List<Integer> winningNums) {
        while (true) {
            try {
                String input = inputBonusNumber();

                InputValidator.validateIsNumber(input);
                int bonusNum = InputUtil.parseInt(input);

                InputValidator.validateInLottoRange(bonusNum);
                InputValidator.validateUniqueNumbers(winningNums, bonusNum);
                return bonusNum;
            } catch (IllegalArgumentException e){
                OutputView.print(e.getMessage());
            }
        }
    }

    private static String inputLottoPurchasePrice() {
        OutputView.printMessage(INPUT_PURCHASE_PRICE);
        return read();
    }


    private static String inputWinningNums(){
        OutputView.printMessage(OUTPUT_WINNING_NUMBERS);
        return read();
    }
    private static String inputBonusNumber(){
        OutputView.printMessage(OUTPUT_BONUS_NUMBER);
        return read();
    }
}
