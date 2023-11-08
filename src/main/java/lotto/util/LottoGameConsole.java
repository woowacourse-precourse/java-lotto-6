package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoGameNumber;
import lotto.game.LottoGameMessage;
import lotto.model.Lotto;

public final class LottoGameConsole {
    private static final String SPLIT_REGEX = ",";

    private LottoGameConsole() {
        // Don't let anyone instantiate this class.
    }

    public static void printError(LottoGameMessage message) {
        System.out.println(message.getMessage());
    }

    public static int readCost() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();
        int cost = Integer.parseInt(input);

        validateCost(cost);

        System.out.println();

        return cost;
    }

    public static Lotto readTargetLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String input = Console.readLine();
        List<Integer> numbers = convertToIntegerList(input);

        System.out.println();

        return new Lotto(numbers);
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input);

        validateBonusNumber(bonusNumber);

        System.out.println();

        return bonusNumber;
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        String formatterMessage = LottoGameMessage.PURCHASE_LOTTOS_FORMATTER.getMessage();

        System.out.println(formatterMessage.formatted(lottos.size()));

        lottos.forEach(System.out::println);

        System.out.println();
    }

    private static void validateCost(int cost) {
        if (cost < LottoGameNumber.COST_UNIT || cost % LottoGameNumber.COST_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(SPLIT_REGEX))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoGameNumber.MINIMUM || bonusNumber > LottoGameNumber.MAXIMUM) {
            throw new IllegalArgumentException();
        }
    }

    public static void close() {
        Console.close();
    }
}
