package lotto.view;

import static lotto.view.constants.MessageType.COST_REQUEST_MESSAGE;
import static lotto.view.constants.MessageType.LOTTO_COUNT_MESSAGE;
import static lotto.view.constants.MessageType.WINNING_NUMBERS_REQUEST_MESSAGE;
import static lotto.view.constants.SymbolType.POSTFIX;
import static lotto.view.constants.SymbolType.PREFIX;
import static lotto.view.constants.SymbolType.SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.constants.MessageType;

public final class View {
    public static String requestCost() {
        printlnMessage(COST_REQUEST_MESSAGE);
        return Validator.validateCost(enterMessage());
    }

    public static void printLottos(Lottos lottos) {
        printLottosCount(lottos.getSize());
        printLottosInfo(lottos.getLottos());
    }

    private static void printLottosCount(int count) {
        printlnFormat(LOTTO_COUNT_MESSAGE, count);
    }

    private static void printLottosInfo(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoInfo(lotto);
        }
    }

    private static void printLottoInfo(Lotto lotto) {
        String result = String.join(SEPARATOR.getSymbol(), convertNumbers(lotto.getNumbers()));
        printlnResult(PREFIX + result + POSTFIX);
    }

    private static String[] convertNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }

    /* Output View */
    private static void printlnResult(String result) {
        System.out.println(result);
    }

    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    private static void printlnFormat(MessageType message, Object... args) {
        System.out.println(String.format(message.getMessage(), args));
    }

    /* Input View */
    private static String enterMessage() {
        return Validator.validate(Console.readLine());
    }

    public static void requestWinningNumbers() {
        printlnMessage(WINNING_NUMBERS_REQUEST_MESSAGE);
    }

    private static class Validator {
        private static String validate(String message) {
            if (isBlank(message)) {
                throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
            }
            return message;
        }

        private static boolean isBlank(String message) {
            return message.isBlank();
        }

        private static String validateCost(String cost) {
            validateNumber(cost);
            validateUnit(cost);
            return cost;
        }

        private static void validateNumber(String cost) {
            if (isNotNumber(cost)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }

        private static boolean isNotNumber(String message) {
            return !message.matches("\\d+");
        }

        private static void validateUnit(String cost) {
            if (isNotDivisible(cost)) {
                throw new IllegalArgumentException(String.format("%s원 단위의 구입 금액을 입력해주세요."));
            }
        }

        private static boolean isNotDivisible(String cost) {
            return Integer.parseInt(cost) % 1000 != 0;
        }
    }
}
