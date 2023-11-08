package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.type.WinningRanking;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;
import static lotto.type.ErrorCode.*;

public class UserConsole {
    private static final long STANDARD_PRICE_OF_ONE_LOTTO = 1000;
    private static final String MONEY_INSERT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_BUY_Count = "{lottoCount}개를 구매했습니다.";
    private static final String TYPE_IN_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String TYPE_IN_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT = "당첨 통계" + "\n---";
    private static final String FIFTH_PLACE = "3개 일치 (5,000원) - {matchCount}개";
    private static final String FOURTH_PLACE = "4개 일치 (50,000원) - {matchCount}개";
    private static final String THIRD_PLACE = "5개 일치 (1,500,000원) - {matchCount}개";
    private static final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - {matchCount}개";
    private static final String FIRST_PLACE = "6개 일치 (2,000,000,000원) - {matchCount}개";
    private static final String INVESTMENT_RESULT = "총 수익률은 {investmentResult}%입니다.";

    public static long getMoney() {
        System.out.println(MONEY_INSERT);

        while (true) {
            try {
                long money = Long.parseLong(Console.readLine());

                if (money % STANDARD_PRICE_OF_ONE_LOTTO != 0) {
                    throw new IllegalArgumentException();
                }
                return money;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_MONEY_TYPE.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_MONEY_TO_BUY.getMessage());
            }
        }
    }

    public static void showPurchasedLottoCount(Machine machine) {
        String lottoCount = String.valueOf(machine.getPurchasedLottoCount());
        System.out.println(LOTTO_BUY_Count.replace("{lottoCount}", lottoCount));
    }

    public static void showLottos(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }

    public static List<Integer> inputFirstWinningNumber() {
        System.out.println(TYPE_IN_WINNING_NUMBER);
        while (true) {
            try {
                List<Integer> numbers = stream(Console.readLine().split(","))
                        .map((num -> Integer.parseInt(num)))
                        .toList();
                if (numbers.size() != 6) {
                    throw new IllegalArgumentException();
                }
                if (numbers.size() != numbers.stream().distinct().count()) {
                    throw new IllegalArgumentException();
                }
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_WINNING_NUMBERS.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        System.out.println(TYPE_IN_BONUS_NUMBER);
        while (true) {
            try {
                return Integer.parseInt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_BONUS_NUMBER.getMessage());
            }
        }
    }

    public static void showWinningResult(Map<Double, Integer> matchResult) {
        System.out.println(WINNING_RESULT);
        getFifthPlace(String.valueOf(matchResult.get(WinningRanking.FIFTH_PLACE.getPrize())));
        getFourthPlace(String.valueOf(matchResult.get(WinningRanking.FOURTH_PLACE.getPrize())));
        getThirdPlace(String.valueOf(matchResult.get(WinningRanking.THIRD_PLACE.getPrize())));
        getSecondPlace(String.valueOf(matchResult.get(WinningRanking.SECOND_PLACE.getPrize())));
        getFirstPlace(String.valueOf(matchResult.get(WinningRanking.FIRST_PLACE.getPrize())));
    }

    public static void getFifthPlace(String count) {
        System.out.println(FIFTH_PLACE.replace("{matchCount}", count));
    }

    public static void getFourthPlace(String count) {
        System.out.println(FOURTH_PLACE.replace("{matchCount}", count));
    }

    public static void getThirdPlace(String count) {
        System.out.println(THIRD_PLACE.replace("{matchCount}", count));
    }

    public static void getSecondPlace(String count) {
        System.out.println(SECOND_PLACE.replace("{matchCount}", count));
    }

    public static void getFirstPlace(String count) {
        System.out.println(FIRST_PLACE.replace("{matchCount}", count));
    }

    public static void getInvestmentResult(double rate) {
        System.out.println(INVESTMENT_RESULT.replace("{investmentResult}", String.valueOf(rate)));
    }

}


