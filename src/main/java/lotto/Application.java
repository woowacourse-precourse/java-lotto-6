package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ConstantMessage;

import static lotto.constant.ConstantMessage.*;
import static lotto.exception.ErrorMessage.*;

public class Application {

    public static void main(String[] args) {

        final int LOTTO_PRICE = 1000;

        String money = inputBuyMoney();

        System.out.println();

        validateEmpty(money);

        validateNumberFormat(money);

        int parseMoney = parseInteger(money);

        validateStartNumber(money);

        validateUnit(parseMoney);

        int buyLottoCount = buyLottoTicket(parseMoney, LOTTO_PRICE);

        printLottoTicketCount(buyLottoCount);

        List<Lotto> lotties = collectLotto(buyLottoCount);

        printLotto(lotties);

        System.out.println();

        String winNumber = inputWinNumber();

        System.out.println();

        validateEmpty(winNumber);

        validateWinNumberFormat(winNumber);

        int[] winNumbers = parseIntArray(winNumber);

        List<Integer> parseWinNumbers = parseIntList(winNumbers);

        validateSixNumber(parseWinNumbers);

        String bonusNumber = inputBonusNumber();

        validateEmpty(bonusNumber);

        validateNumberFormat(bonusNumber);

        int parseBounusNumber = parseInteger(bonusNumber);

        validateNumberRange(parseBounusNumber);

        validateDuplicateNumber(parseWinNumbers, parseBounusNumber);

        getWinNumberCount(lotties, parseWinNumbers, parseBounusNumber, parseMoney);
    }

    public static List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static void printConstantMessage(ConstantMessage ConstantMessage) {
        System.out.print(ConstantMessage.getMessage());
    }

    public static String inputBuyMoney() {
        printConstantMessage(INPUT_BUY_MONEY);
        return Console.readLine();
    }

    //try catch로 묶기
    public static void validateEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY.getErrorMessage());
        }
    }

    public static int parseInteger(String input) {
        return Integer.parseInt(input);
    }

    public static void validateNumberFormat(String input) {
        try {
            parseInteger(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_FORMAT.getErrorMessage());
        }
    }

    public static void validateStartNumber(String input) {
        final int START_NUMBER = 0;
        final char CHECK_CHARACTER = '0';
        if (input.charAt(START_NUMBER) == CHECK_CHARACTER) {
            throw new IllegalArgumentException(START_LETTER_ZERO.getErrorMessage());
        }
    }

    public static void validateUnit(int input) {
        final int UNIT = 1000;
        final int REST_NUMBER = 0;
        if (input % UNIT != REST_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
    }

    public static int buyLottoTicket(int money, int lottoPrice) {
        return money / lottoPrice;
    }

    public static void printLottoTicketCount(int lottoTicketCount) {
        System.out.print(lottoTicketCount);
        printConstantMessage(BUY_LOTTO_TICKET);
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
            throw new IllegalArgumentException(INCORRECT_WIN_NUMBER_FORMAT.getErrorMessage());
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
            throw new IllegalArgumentException(NOT_SIX_NUMBER.getErrorMessage());
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
            throw new IllegalArgumentException(NOT_IN_INPUT_RANGE.getErrorMessage());
        }
    }

    public static void validateDuplicateNumber(List<Integer> parseWinNumbers, int parseBounusNumber) {
        if (parseWinNumbers.contains(parseBounusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public static void getWinNumberCount(List<Lotto> lotties, List<Integer> parseWinNumbers, int parseBonusNumber,
            int parseMoney) {
        int threeCorrect = 0;
        int fourCorrect = 0;
        int fiveCorrect = 0;
        int fiveBonusCorrect = 0;
        int sixCorrect = 0;
        int earnMoney = 0;
        boolean hasBonusNumber = false;
        for (int i = 0; i < lotties.size(); i++) {
            int correctCount = 0;
            Lotto lotto = lotties.get(i);
            correctCount = checkWinNumber(lotto, correctCount, parseWinNumbers);
            hasBonusNumber = checkBonusNumber(lotto, parseBonusNumber);
            if (correctCount == 3) {
                threeCorrect++;
                earnMoney += 5000;
            }

            if (correctCount == 4) {
                fourCorrect++;
                earnMoney += 50000;
            }

            if (correctCount == 5) {
                fiveCorrect++;
                earnMoney += 1500000;
            }

            if (correctCount == 5 && hasBonusNumber) {
                fiveBonusCorrect++;
                earnMoney += 30000000;
            }

            if (correctCount == 6) {
                sixCorrect++;
                earnMoney += 2000000000;
            }
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeCorrect + "개");
        System.out.println("4개 일치 (50,000원) - " + fourCorrect + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveCorrect + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveBonusCorrect + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixCorrect + "개");

        double parseEarnMoney = (double) earnMoney;
        double rateOfReturn = parseEarnMoney / parseMoney * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");

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

    public static void getResult(int correctCount, boolean hasBonusNumber, int earnMoney, int threeCorrect,
            int fourCorrect, int fiveCorrect, int fiveBonusCorrect, int sixCorrect) {

    }

}
