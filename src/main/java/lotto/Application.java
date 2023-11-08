package lotto;

import lotto.enums.MessageType;
import lotto.utils.InputUtils;
import lotto.utils.LottoUtils;
import lotto.utils.OutputUtils;

import java.util.*;

public class Application {

    private static int amount = 0;
    private static Lotto[] lottos;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    private static Result result = new Result();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        initGame();
        startGame();
        endGame();
    }

    private static void initGame(){
        OutputUtils.printBasicMessage(MessageType.INPUT_AMOUNT_MESSAGE);
        try {
            amount = InputUtils.inputAmount();
        } catch (IllegalStateException | IllegalArgumentException e) {
            initGame();
        }

        int numberOfLottos = amount / 1000;
        lottos = new Lotto[numberOfLottos];

        lottos = LottoUtils.createLottos(numberOfLottos);
        OutputUtils.printLottos(lottos, numberOfLottos);
    }

    private static void startGame(){
        inputWiningNumbers();
        inputBonusNumber();
    }

    private static void endGame(){
        OutputUtils.printBasicMessage(MessageType.END_MSG);

        for(Lotto lotto : lottos){
            int currentMatchCount = lotto.compareAndGetCountOfMatchers(winningNumbers);
            boolean bonusMatch = lotto.checkIfBonusNumberExists(bonusNumber);

            result.updateResult(currentMatchCount, bonusMatch);
        }

        OutputUtils.printResult(result);
        OutputUtils.printGain(result, amount);
    }

    private static void inputWiningNumbers(){
        try {
            OutputUtils.printBasicMessage(MessageType.INPUT_WINNING_MSG);
            winningNumbers = InputUtils.inputWinningNumbers();
        } catch (IllegalArgumentException | IllegalStateException e) {
            inputWiningNumbers();
        }
    }

    private static void inputBonusNumber(){
        try{
            OutputUtils.printBasicMessage(MessageType.INPUT_BONUS_MSG);
            bonusNumber = InputUtils.inputBonusNumber(winningNumbers);
        }catch  (IllegalStateException | IllegalArgumentException e) {
            inputBonusNumber();
        }
    }

}
