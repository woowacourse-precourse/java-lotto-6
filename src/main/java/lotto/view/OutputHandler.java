package lotto.view;

import static lotto.constant.ExceptionMessage.REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS;
import static lotto.constant.ExceptionMessage.REQUIRE_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.constant.ExceptionMessage.REQUIRE_NONEMPTY_INPUT;
import static lotto.constant.ExceptionMessage.REQUIRE_POSITIVE_INTEGER;
import static lotto.constant.ExceptionMessage.REQUIRE_POSITIVE_LONG;
import static lotto.constant.ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER;
import static lotto.constant.ExceptionMessage.REQUIRE_SIX_NUMBERS;
import static lotto.constant.ExceptionMessage.REQUIRE_UNIQUE_NUMBERS;
import static lotto.constant.SystemMessage.REQUIRE_BONUS_NUMBER;
import static lotto.constant.SystemMessage.REQUIRE_PAYMENT_PRICE;
import static lotto.constant.SystemMessage.REQUIRE_WINNING_NUMBERS;
import static lotto.constant.SystemMessage.SAY_TICKET_COUNT_FORMAT;

import java.util.List;

// TODO : 변수명에 하드코딩된 것 바꾸기
public class OutputHandler {

    public static void requirePaymentPrice() {
        System.out.println(REQUIRE_PAYMENT_PRICE.getSystemMessage());
    }

    public static void sayTicketCount(long ticketCount) {
        System.out.println(ticketCount + SAY_TICKET_COUNT_FORMAT.getSystemMessage());
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void requireWinningNumbers() {
        System.out.println(REQUIRE_WINNING_NUMBERS.getSystemMessage());
    }

    public static void requireBonusNumber() {
        System.out.println(REQUIRE_BONUS_NUMBER.getSystemMessage());
    }

    public static void showWinningDetails(int rank1, int rank2, int rank3, int rank4, int rank5) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %s개%n", rank5);
        System.out.printf("4개 일치 (50,000원) - %s개%n", rank4);
        System.out.printf("5개 일치 (1,500,000원) - %s개%n", rank3);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개%n", rank2);
        System.out.printf("6개 일치 (2,000,000,000원) - %s개%n", rank1);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn * 100);
    }

    public static void requireNonemptyInput() {
        System.out.println(REQUIRE_NONEMPTY_INPUT.getMessage());
    }

    public static void requirePositiveLong() {
        System.out.println(REQUIRE_POSITIVE_LONG.getMessage());
    }

    public static void requirePositiveInteger() {
        System.out.println(REQUIRE_POSITIVE_INTEGER.getMessage());
    }

    public static void requireMultipleOfLottoPrice() {
        System.out.println(REQUIRE_MULTIPLE_OF_LOTTO_PRICE.getMessage());
    }

    public static void requireSixNumbers() {
        System.out.println(REQUIRE_SIX_NUMBERS.getMessage());
    }

    public static void requireRightRangeNumber() {
        System.out.println(REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
    }

    public static void requireUniqueNumbers() {
        System.out.println(REQUIRE_UNIQUE_NUMBERS.getMessage());
    }

    public static void requireDifferentNumberWithWinningNumbers() {
        System.out.println(REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS.getMessage());
    }
}