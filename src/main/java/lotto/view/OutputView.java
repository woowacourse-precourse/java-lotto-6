package lotto.view;

import static lotto.view.OutputMessage.*;
import static lotto.domain.LottoRank.*;
import static lotto.constant.LottoResultIndex.*;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");

    public static void askPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public static void askLottoWinningNumber() {
        printNewLine();
        System.out.println(ENTER_LOTTO_NUMBERS.getMessage());
    }

    public static void askBonusNumber() {
        printNewLine();
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }

    public static void printPurchasedResult(List<Lotto> purchasedLotto, int purchasedGameCount) {
        printNewLine();
        printPurchasedGameCount(purchasedGameCount);
        printPurchasedLottoNumbers(purchasedLotto);
    }

    private static void printPurchasedGameCount(int purchasedGameCount) {
        System.out.printf(SHOW_LOTTO_GAME_COUNT.getMessage(), purchasedGameCount);
        printNewLine();
    }

    private static void printPurchasedLottoNumbers(List<Lotto> purchasedLotto) {
        for (Lotto eachLotto : purchasedLotto) {
            System.out.println(eachLotto.getNumbers());
        }
    }

    public static void printLottoResult(int[] rankResult, String lottoYield) {
        printNewLine();
        printLottoResultIntroduction();
        printLottoPrize(rankResult);
        printYieldOfLottoResult(lottoYield);
    }

    private static void printLottoResultIntroduction() {
        System.out.println(SHOW_LOTTO_STATISTIC_INTRODUCTION.getMessage());
        System.out.println(SHOW_LOTTO_SEPARATOR_LINE.getMessage());
    }

    private static void printLottoPrize(int[] rankResult) {
        for (int matchedNumber = FIFTH_RANK_MATCH_INDEX.getIndex();
             matchedNumber <= FIRST_RANK_MATCH_INDEX.getIndex(); matchedNumber++) {
            printMatchedLotto(rankResult, matchedNumber);
        }
    }

    private static void printMatchedLotto(int[] rankResult, int matchedNumber) {
        System.out.printf(SHOW_LOTTO_PRIZE.getMessage(),
                matchedNumber,
                formatter.format(getLottoRank(matchedNumber).getWinningAmount()),
                rankResult[matchedNumber]);
        printNewLine();

        if (matchedNumber == THIRD_RANK.getMatchNumbers()) {
            printMatchedLottoWithBonus(rankResult, matchedNumber);
        }
    }

    private static void printMatchedLottoWithBonus(int[] rankResult, int matchedNumber) {
        System.out.printf(SHOW_LOTTO_PRIZE_WITH_BONUS.getMessage(),
                matchedNumber,
                formatter.format(SECOND_RANK.getWinningAmount()),
                rankResult[SECOND_RANK_INDEX.getIndex()]);
        printNewLine();
    }

    private static void printYieldOfLottoResult(String lottoYield) {
        System.out.printf(SHOW_LOTTO_RESULT_YIELD.getMessage(), lottoYield);
        printNewLine();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}