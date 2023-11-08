package lotto.handler;

import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;
import static lotto.message.SystemMessage.OUTPUT_BONUS_NUMBER;
import static lotto.message.SystemMessage.OUTPUT_WINNING_NUMBERS;
import static lotto.util.OutputUtil.formatNumsToString;
import static lotto.view.InputView.read;

import camp.nextstep.edu.missionutils.Console;
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

                //너도 마찬가지
                InputValidator.validateIsMultiplesOf1000(lottoPurchasePrice);
                return lottoPurchasePrice;
            } catch (IllegalArgumentException e) {
                OutputView.printWithBlankLine(e.getMessage());
            }
        }
    }

    public static List<Integer> setWinningNums(){
        while (true) {
            try{
                String input = inputWinningNums();

                InputValidator.validateIsNumbers(input);

                List<Integer> winningNums = InputUtil.parseNums(input);

                // 이건 input이 아니라.. 다른 검증 클래스에서 하는게 좋을지도
                // 예를 들어 로또검증 클래스나.. 이런데서 하는게 좋을듯.
                InputValidator.validateInLottoRange(winningNums);
                InputValidator.validateIsLottoSize(winningNums);
                InputValidator.validateUniqueNumbers(winningNums);

                return winningNums;
            } catch (IllegalArgumentException e){
                OutputView.printWithBlankLine(e.getMessage());
            }
        }
    }

    public static int setBonusNum(List<Integer> winningNums) {
        while (true) {
            try {
                String input = inputBonusNumber();

                InputValidator.validateIsNumber(input);
                int bonusNum = InputUtil.parseInt(input);

                // 너도 위에와 마찬가지
                InputValidator.validateInLottoRange(bonusNum);
                InputValidator.validateUniqueNumbers(winningNums, bonusNum);
                return bonusNum;
            } catch (IllegalArgumentException e){
                OutputView.printWithBlankLine(e.getMessage());
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
