package lotto;

import lotto.domain.LottoPlayer;
import lotto.domain.Referee;
import lotto.util.Validator;
import lotto.domain.WinningNumber;
import lotto.view.ConsoleView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static LottoPlayer player;
    private static WinningNumber winningNumber;

    public static void main(String[] args) {
        ConsoleView.printInputPurchaseAmountMessage();
        player = new LottoPlayer(inputPurchaseAmount());
        ConsoleView.printLine();

        ConsoleView.printPurchaseConfirmationMessage(player.getCount());
        ConsoleView.printLottos(player.getLottos());
        ConsoleView.printLine();

        ConsoleView.printInputWinningNumbersMessage();
        winningNumber = new WinningNumber(inputWinningNumbers());
        ConsoleView.printLine();

        ConsoleView.printInputBonusNumberMessage();
        inputBonusNumber();
        ConsoleView.printLine();

        ConsoleView.printResult(player, new Referee(winningNumber));
    }

    private static int inputPurchaseAmount() {
        while(true) {
            try {
                String purchaseAmount = readLine();
                Validator.validPurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        while(true) {
            try {
                String winningNumbers = readLine();
                Validator.validWinningNumbers(winningNumbers);
                return Arrays.stream(winningNumbers.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void inputBonusNumber() {
        while(true) {
            try {
                String bonusNumber = readLine();
                Validator.validBonusNumber(bonusNumber);
                winningNumber.setBonusNumber(Integer.parseInt(bonusNumber));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
