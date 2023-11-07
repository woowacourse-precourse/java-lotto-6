package lotto.application;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.domain.WinningNumber;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class IOService {
    private static final String BEFORE_PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_CNT_MESSAGE = "개를 구매했습니다.";
    private static final String PRIZE_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_AMOUNT_INTEGER = "[ERROR] 구입 금액은 정수여야 합니다.";
    private static final String ERROR_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야합니다.";
    private static final String ERROR_PRIZE_NUMBER_CNT = "[ERROR] 6개를 입력해야합니다.";
    private static final String ERROR_PRIZE_NUMBER_INTEGER = "[ERROR] 당첨 번호는 정수여야 합니다.";
    private static final String ERROR_PRIZE_NUMBER_RANGE = "[ERROR] 당첨 번호는 1이상 45이하입니다.";
    private static final String ERROR_PRIZE_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String ERROR_AMOUNT_MINIMUM = "[ERROR] 구입 금액이 1000원보다 작을 수는 없습니다.";
    private final static String ERROR_BONUS_NUMBER_CNT = "[ERROR] 1개를 입력해야합니다.";
    private final static String ERROR_BONUS_NUMBER_INTEGER = "[ERROR] 보너스 번호는 정수여야합니다.";
    private final static String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1이상 45이하입니다.";

    private final static String ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 보너스 번호는 기존 번호와 중복될 수 없습니다.";

    public static void printBeforePurchaseLottoMessage() {
        System.out.println(BEFORE_PURCHASE_LOTTO_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printLottoCount(int cnt) {
        System.out.println(cnt + LOTTO_CNT_MESSAGE);
    }

    public static void printPrizeNumberMessage() {
        System.out.println(PRIZE_NUMBER_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printResult(User user) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printStatistics(user);
        printProfit(user);
    }

    private static void printStatistics(User user) {
        List<Rank> ranks = List.of(Rank.FifthRank, Rank.ForthRank, Rank.ThirdRank, Rank.SecondRank, Rank.FirstRank);
        List<Integer> cntMatches = List.of(3, 4, 5, 5, 6);
        String message;
        for(int i = 0; i < 5; ++i){
            Rank rank = ranks.get(i);
            message = makeStaticsMessage(cntMatches.get(i), rank, user.getCntRank().get(rank));
            System.out.println(message);
        }
    }

    private static String makeStaticsMessage(int cntMath, Rank rank, int cntRank){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        final String cntMathInfo = Integer.toString(cntMath) + "개 일치";
        final String bonusInfo = ", 보너스 볼 일치";
        final String prizeInfo = " (" + numberFormat.format(rank.getPrize()) + "원) ";
        final String cntRankInfo = "- " + Integer.toString(cntRank) + "개";

        if(rank.equals(Rank.SecondRank))
            return cntMathInfo + bonusInfo + prizeInfo + cntRankInfo;
        return cntMathInfo + prizeInfo + cntRankInfo;
    }

    private static void printProfit(User user) {
        double profit =  (double)user.getTotalPrize() / 1000.0 / (double) (user.getLottoCnt());
        profit = Math.round(profit * 1000) / 10.0;
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public static int scanPurchaseAmount() {
        boolean success = true;
        String purchaseAmount;
        do {
            purchaseAmount = Console.readLine();

            success = LottoService.validatePurchaseAmount(purchaseAmount);
        } while (!success);

        return Integer.parseInt(purchaseAmount);
    }

    public static WinningNumber scanWinningNumber(){
        WinningNumber winningNumber;
        List<Integer> prizeNumbers;
        printPrizeNumberMessage();

        prizeNumbers = scanPrizeNumbers();
        prizeNumbers = prizeNumbers.stream().sorted().toList();

        winningNumber = new WinningNumber(prizeNumbers);

        printBonusNumberMessage();
        int bonusNumber = scanBonusNumber(prizeNumbers);
        winningNumber.setBonusNumber(bonusNumber);

        return winningNumber;
    }

    private static List<Integer> scanPrizeNumbers() {
        boolean success = true;

        String prizeNumbers;
        do {
            prizeNumbers = Console.readLine();

            success = WinningNumber.validatePrizeNumber(prizeNumbers);
        } while (!success);

        return Arrays.stream(prizeNumbers.split(",")).map(s -> Integer.parseInt(s)).toList();
    }

    private static int scanBonusNumber(List<Integer> prizeNumbers){
        boolean success = true;

        String bonusNumber;
        do {
            bonusNumber = Console.readLine();

            success = WinningNumber.validateBonusNumber(prizeNumbers, bonusNumber);
        } while (!success);

        return Integer.parseInt(bonusNumber);
    }

    public static void printErrorAmountInteger() {
        System.out.println(ERROR_AMOUNT_INTEGER);
    }
    public static void printErrorAmountMinimum() {
        System.out.println(ERROR_AMOUNT_MINIMUM);
    }

    public static void printErrorAmountUnit() {
        System.out.println(ERROR_AMOUNT_UNIT);
    }



    public static void printErrorPrizeNumberCnt() {
        System.out.println(ERROR_PRIZE_NUMBER_CNT);
    }

    public static void printPrizeNumberInteger() {
        System.out.println(ERROR_PRIZE_NUMBER_INTEGER);
    }

    public static void printErrorPrizeNumberRange() {
        System.out.println(ERROR_PRIZE_NUMBER_RANGE);
    }

    public static void printErrorPrizeNumberDuplicate() {
        System.out.println(ERROR_PRIZE_NUMBER_DUPLICATE);
    }



    public static void printErrorBonusNumberCnt() {
        System.out.println(ERROR_BONUS_NUMBER_CNT);
    }
    public static void printBonusNumberInteger() {
        System.out.println(ERROR_BONUS_NUMBER_INTEGER);
    }
    public static void printErrorBonusNumberDuplicate() {
        System.out.println(ERROR_BONUS_NUMBER_DUPLICATED);
    }
    public static void printBonusNumberRange() {
        System.out.println(ERROR_BONUS_NUMBER_RANGE);
    }
}
