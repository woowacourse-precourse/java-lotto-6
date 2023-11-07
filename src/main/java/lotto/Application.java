package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.Map;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ConstantMessage;

import static lotto.constant.ConstantMessage.*;
import static lotto.exception.ErrorMessage.*;

public class Application {

    public static void main(String[] args) {

        final int LOTTO_PRICE = 1000;
        int parseMoney = 0;

        while (true) {
            try {
                String money = inputBuyMoney();

                System.out.println();

                validateEmpty(money);

                validateStartNumber(money);

                parseMoney = validateNumberFormat(money);

                validateUnit(parseMoney);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(INCORRECT_NUMBER_FORMAT.getErrorMessage());
                continue;
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }
        }

        int buyLottoCount = buyLottoTicket(parseMoney, LOTTO_PRICE);

        printLottoTicketCount(buyLottoCount);

        List<Lotto> lotties = collectLotto(buyLottoCount);

        printLotto(lotties);

        List<Integer> parseWinNumbers;

        System.out.println();

        while (true) {
            try {
                String winNumber = inputWinNumber();

                System.out.println();

                validateEmpty(winNumber);

                validateWinNumberFormat(winNumber);

                int[] winNumbers = parseIntArray(winNumber);

                parseWinNumbers = parseIntList(winNumbers);

                validateSixNumber(parseWinNumbers);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(INCORRECT_NUMBER_FORMAT.getErrorMessage());
                continue;
            } catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }

        }

        int parseBonusNumber = 0;

        while (true) {
            String bonusNumber = inputBonusNumber();

            validateEmpty(bonusNumber);

            validateNumberFormat(bonusNumber);

            parseBonusNumber = parseInteger(bonusNumber);

            validateNumberRange(parseBonusNumber);

            validateDuplicateNumber(parseWinNumbers, parseBonusNumber);
            break;
        }

        Map<String, Integer> result = getResultWinCount(lotties, parseWinNumbers, parseBonusNumber, parseMoney);
        int earnMoney = getEarnMoney(result);
        double rateOfReturn = getRateOfReturn(earnMoney, parseMoney);
        printResult(result, rateOfReturn);
    }

    public static void printConstantMessage(ConstantMessage ConstantMessage) {
        System.out.print(ConstantMessage.getMessage());
    }

    public static String inputBuyMoney() {
        printConstantMessage(INPUT_BUY_MONEY);
        return Console.readLine();
    }

    public static void validateEmpty(String input) {
        if (input.isBlank()) {
            System.out.println(EMPTY.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static int validateNumberFormat(String input) {
        return parseInteger(input);
    }

    public static int parseInteger(String input) {
        return Integer.parseInt(input);
    }

    public static void validateStartNumber(String input) {
        final int START_NUMBER = 0;
        final char CHECK_CHARACTER = '0';
        if (input.charAt(START_NUMBER) == CHECK_CHARACTER) {
            System.out.println(START_LETTER_ZERO.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateUnit(int input) {
        final int UNIT = 1000;
        final int REST_NUMBER = 0;
        if (input % UNIT != REST_NUMBER) {
            System.out.println(INCORRECT_THOUSAND_UNIT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static int buyLottoTicket(int money, int lottoPrice) {
        return money / lottoPrice;
    }

    public static void printLottoTicketCount(int lottoTicketCount) {
        System.out.print(lottoTicketCount);
        printConstantMessage(BUY_LOTTO_TICKET);
    }

    public static List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static List<Lotto> collectLotto(int lottoTicketCount) {
        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = new Lotto(makeLotto());
            lotties.add(lotto);
        }
        return lotties;
    }

    public static void printLotto(List<Lotto> lotties) {
        for (Lotto lotto : lotties) {
            System.out.println(lotto.getLotto().toString());
        }
    }

    public static String inputWinNumber() {
        printConstantMessage(INPUT_WIN_NUMBER);
        return Console.readLine();
    }

    public static void validateWinNumberFormat(String winNumber) {
        final int START_NUMBER = 0;
        final int LAST_NUMBER = winNumber.length() - 1;
        final char CHECK_CHARACTER = ',';
        if (winNumber.charAt(START_NUMBER) == CHECK_CHARACTER || winNumber.charAt(LAST_NUMBER) == CHECK_CHARACTER) {
            System.out.println(INCORRECT_WIN_NUMBER_FORMAT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static String[] splitString(String winNumber) {
        return winNumber.split(",");
    }

    public static int[] parseIntArray(String winNumber) {
        return Stream.of(splitString(winNumber)).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> parseIntList(int[] winNumbers) {
        return Arrays.stream(winNumbers).boxed().collect(Collectors.toList());
    }

    public static void validateSixNumber(List<Integer> parseWinNumbers) {
        final int TARGET_NUMBER_COUNT = 6;
        if (parseWinNumbers.size() != TARGET_NUMBER_COUNT) {
            System.out.println(NOT_SIX_NUMBER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static String inputBonusNumber() {
        printConstantMessage(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public static void validateNumberRange(int parseBounusNumber) {
        final int MIN_RAGNE = 1;
        final int MAX_RANGE = 45;
        if (parseBounusNumber < MIN_RAGNE || parseBounusNumber > MAX_RANGE) {
            System.out.println(NOT_IN_INPUT_RANGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicateNumber(List<Integer> parseWinNumbers, int parseBounusNumber) {
        if (parseWinNumbers.contains(parseBounusNumber)) {
            System.out.println(DUPLICATE_NUMBER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static Map<String, Integer> getResultWinCount(List<Lotto> lotties, List<Integer> parseWinNumbers,
            int parseBonusNumber,
            int parseMoney) {

        boolean hasBonusNumber = false;
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < lotties.size(); i++) {
            int correctCount = 0;
            Lotto lotto = lotties.get(i);
            correctCount = checkWinNumber(lotto, correctCount, parseWinNumbers);
            hasBonusNumber = checkBonusNumber(lotto, parseBonusNumber);
            result = saveCount(result, correctCount, hasBonusNumber);
        }
        return result;

    }

    public static int checkWinNumber(Lotto lotto, int correctCount, List<Integer> parseWinNumbers) {
        final int INCORRECT_NUMBER = -1;
        for (int j = 0; j < lotto.getLotto().size(); j++) {
            if (lotto.getLotto().indexOf(parseWinNumbers.get(j)) != INCORRECT_NUMBER) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public static boolean checkBonusNumber(Lotto lotto, int parseBounusNumber) {
        if (lotto.getLotto().contains(parseBounusNumber)) {
            return true;
        }
        return false;
    }

    public static Map<String, Integer> saveCount(Map<String, Integer> result, int correctCount,
            boolean hasBonusNumber) {

        if (correctCount == 3) {
            result.put("three", result.getOrDefault(result.get("three"), 0) + 1);
        }

        if (correctCount == 4) {
            result.put("four", result.getOrDefault(result.get("four"), 0) + 1);
        }

        if (correctCount == 5) {
            result.put("five", result.getOrDefault(result.get("five"), 0) + 1);
        }

        if (correctCount == 5 && hasBonusNumber) {
            result.put("fiveBonus", result.getOrDefault(result.get("fiveBonus"), 0) + 1);
        }

        if (correctCount == 6) {
            result.put("six", result.getOrDefault(result.get("six"), 0) + 1);
        }
        return result;
    }

    public static int getEarnMoney(Map<String, Integer> result) {
        final int THREE_MONEY = 5000;
        final int FOUR_MONEY = 5000;
        final int FIVE_MONEY = 1500000;
        final int FIVE_BONUS_MONEY = 30000000;
        final int SIX_MONEY = 2000000000;
        int earnMoney = 0;
        for (String key : result.keySet()) {
            if (key.equals("three")) {
                earnMoney += (result.get(key) * THREE_MONEY);
            }
            if (key.equals("four")) {
                earnMoney += (result.get(key) * FOUR_MONEY);
            }
            if (key.equals("five")) {
                earnMoney += (result.get(key) * FIVE_MONEY);
            }
            if (key.equals("fiveBonus")) {
                earnMoney += (result.get(key) * FIVE_BONUS_MONEY);
            }
            if (key.equals("six")) {
                earnMoney += (result.get(key) * SIX_MONEY);
            }
        }

        return earnMoney;
    }

    public static void printWinCount(Map<String, Integer> result, String key) {
        if (result.containsKey(key)) {
            System.out.print(result.get(key));
        }
        if (!result.containsKey(key)) {
            System.out.print(0);
        }
    }

    public static double getRateOfReturn(int earnMoney, int parseMoney) {
        double parseEarnMoney = (double) earnMoney;
        double rateOfReturn = parseEarnMoney / parseMoney * 100;
        return rateOfReturn;
    }

    public static void printResult(Map<String, Integer> result, double rateOfReturn) {
        printConstantMessage(WINNING_STAT);
        printConstantMessage(THREE_CORRECT);
        printWinCount(result, "three");
        printConstantMessage(COUNT);

        printConstantMessage(FOUR_CORRECT);
        printWinCount(result, "four");
        printConstantMessage(COUNT);

        printConstantMessage(FIVE_CORRECT);
        printWinCount(result, "five");
        printConstantMessage(COUNT);

        printConstantMessage(FIVE_BONUS_CORRECT);
        printWinCount(result, "fiveBonus");
        printConstantMessage(COUNT);

        printConstantMessage(SIX_CORRECT);
        printWinCount(result, "six");
        printConstantMessage(COUNT);
        printRateOfReturn(rateOfReturn);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        final String ROUND_POSITION = "%.1f";
        System.out.println("총 수익률은 " + String.format(ROUND_POSITION, rateOfReturn) + "%입니다.");
    }

}
