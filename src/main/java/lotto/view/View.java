package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import lotto.model.LottoGame;
import lotto.model.Validator;

public class View {

    public enum ErrorMessage {
        INVALID_NUMBER("유효한 숫자를 입력해주세요."),
        NOT_POSITIVE("양의 정수를 입력해주세요."),
        BELOW_MINIMUM_AMOUNT("로또 가격보다 큰 값을 입력해주세요."),
        INCORRECT_NUMBER_COUNT("6개의 수를 입력해주세요."),
        INVALID_RANGE("1~45 사이의 숫자만 입력해주세요."),
        DUPLICATE_NUMBER("중복된 숫자는 입력할 수 없습니다.");


        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("로또를 구매할 금액을 입력하세요.");
                String input = Console.readLine().trim();
                Validator.validatePurchaseInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }


    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 쉼표로 구분하여 입력하세요.");
                String input = Console.readLine().trim();
                Validator.validateWinningNumbers(input);
                return LottoGame.convertInputToIntegerList(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage() + " 다시 입력해주세요.");
            }
        }
    }



    public static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력하세요.");
                String input = Console.readLine().trim();
                Validator.isPositiveInteger(input);
                int bonusNumber = Integer.parseInt(input);
                Validator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }



    private static void validateWinningNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_PREFIX + ErrorMessage.INVALID_RANGE.name());
        }
    }


    public static void printWinningStatistics(Map<Integer, Integer> statistics, double earningRate) {
        Map<Integer, Integer> prizeMoneyMap = LottoGame.getPrizeMoneyMap();

        System.out.println("당첨 통계");
        System.out.println("---");
        for (int rank = 5; rank >= 1; rank--) {
            int count = statistics.getOrDefault(rank, 0);
            int prizeMoney = prizeMoneyMap.getOrDefault(rank, 0); // 상금 정보 가져오기
            String description = getDescriptionForRank(rank); // 등수에 따른 설명 가져오기
            System.out.println(description + " - " + count + "개");
        }
        printEarningsRate(earningRate);
    }
    private static String getDescriptionForRank(int rank) {
        Map<Integer, String> rankDescriptionMap = Map.of(
                1, "6개 일치 (2,000,000,000원)",
                2, "5개 일치, 보너스 볼 일치 (30,000,000원)",
                3, "5개 일치 (1,500,000원)",
                4, "4개 일치 (50,000원)",
                5, "3개 일치 (5,000원)"
        );
        return rankDescriptionMap.get(rank);
    }

    public static void printEarningsRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }

    public static void printMyLotto(int purchasedLottosAmount, List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottosAmount + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }


}
