package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameSetting;
import lotto.exception.LottoException;
import lotto.utils.Checker;
import lotto.utils.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class View {

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public static void printMessageWithArgs(Message message, Object... args) {
        System.out.println(message.getMessage(args));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static <T> T inputHandler(Message message, Function<String, T> func) {
        while (true) {
            try {
                printMessage(message);
                final String input = Console.readLine();
                return func.apply(input);
            } catch (LottoException ignored) {
            }
        }
    }

    public static Integer requestMoney() {
        return inputHandler(Message.REQUEST_MONEY, input -> {
            Integer result = Parser.parseStringToInt(input);
            if (!Checker.isPositive(result)) {
                throw LottoException.of(lotto.exception.Message.MONEY_RANGE);
            }
            if (!Checker.is1k(result)) {
                throw LottoException.of(lotto.exception.Message.MONEY_REMAINDER);
            }
            return result;
        });
    }

    public static List<Integer> requestNumbers() {
        return inputHandler(Message.REQUEST_NUMBERS, input -> {
            List<Integer> result = Parser.parseStringToIntList(input);
            Checker.validateUnique(result);
            Checker.validateSize(result, GameSetting.TICKET_SIZE.getValue());
            Checker.validateRange(result, GameSetting.START_NUMBER.getValue(), GameSetting.END_NUMBER.getValue());
            return result;
        });
    }

    public static Integer requestNumberBonus(List<Integer> ticketNumbers) {
        return inputHandler(Message.REQUEST_NUMBER_BONUS, input -> {
            Integer result = Parser.parseStringToInt(input);

            if (!Checker.isValidateRange(
                    result, GameSetting.START_NUMBER.getValue(), GameSetting.END_NUMBER.getValue())) {
                throw LottoException.of(lotto.exception.Message.MONEY_RANGE);
            }

            List<Integer> copiedList = new ArrayList<>(ticketNumbers);
            copiedList.add(result);
            Checker.validateUnique(copiedList);
            return result;
        });
    }
}
