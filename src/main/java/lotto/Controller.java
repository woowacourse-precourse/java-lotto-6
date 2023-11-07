package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    private static final String TEXT_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TEXT_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String TEXT_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String TEXT_OUTPUT_COUNT = "%d개를 구매했습니다.\n";
    private static final String TEXT_OUTPUT_RESULT_HEADER = "당첨 통계\n---";

    public static int inputPurchaseCount() throws IllegalArgumentException {
        System.out.println(TEXT_INPUT_AMOUNT);
        String input = Console.readLine();
        int amount = InputValidator.validatePurchaseCount(input);
        System.out.println();
        return amount;
    }

    public static List<Integer> inputWinningNumbers() throws IllegalArgumentException {
        System.out.println(TEXT_INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        List<Integer> winningNumbers = InputValidator.validateWinningNumbers(input);
        System.out.println();
        return winningNumbers;
    }

    public static int inputBonusNumber() throws IllegalArgumentException {
        System.out.println(TEXT_INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        int bonusNumber = InputValidator.validateBonusNumber(input);
        System.out.println();
        return bonusNumber;
    }


    public static void printGeneratedLotto(List<Lotto> generatedLotto) {
        System.out.printf(TEXT_OUTPUT_COUNT, generatedLotto.size());
        for (Lotto lotto : generatedLotto) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printSimulationResult(LottoSimulationResult simulationResult) {
        System.out.println(TEXT_OUTPUT_RESULT_HEADER);
        System.out.println(simulationResult);
    }
}
