package lotto.view;

import static lotto.util.message.ViewMessages.INPUT_BONUS_NUMBER;
import static lotto.util.message.ViewMessages.INPUT_USER_MONEY;
import static lotto.util.message.ViewMessages.INPUT_WINNING_NUMBERS;
import static lotto.util.message.ViewMessages.OUTPUT_HORIZONTAL_LINE;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_AMOUNT_MESSAGE;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_NUMBERS;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_RANK_BONUS;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_RANK_COUNT;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_RANK_PRIZE;
import static lotto.util.message.ViewMessages.OUTPUT_LOTTO_RANK_RESULT;
import static lotto.util.message.ViewMessages.OUTPUT_RESULT_GUIDE;
import static lotto.util.message.ViewMessages.OUTPUT_USER_MONEY_REVENUE_RATE;

import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.UserLotto;
import lotto.model.UserMoney;
import lotto.model.UserLottoRank;

public class OutputView {
    public void printUserMoneyInputGuide() {
        println(INPUT_USER_MONEY);
    }

    public void printWinningNumbersGuide() {
        println(INPUT_WINNING_NUMBERS);
    }

    public void printBonusNumberGuide() {
        println(INPUT_BONUS_NUMBER);
    }

    public void printLottoAmount(UserMoney userMoney) {
        printf(OUTPUT_LOTTO_AMOUNT_MESSAGE + "\n", userMoney.getLottoAmount());
    }

    public void printUserLotto(UserLotto userLotto) {
        userLotto.getLottos().forEach(this::printLottoNumbers);
    }

    public void printResultGuide() {
        println(OUTPUT_RESULT_GUIDE);
    }

    public void printHorizontalLine() {
        println(OUTPUT_HORIZONTAL_LINE);
    }

    public void printUserLottoRank(UserLottoRank userLottoRank) {
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .forEach(lottoRank -> printLottoRank(userLottoRank, lottoRank));
    }

    public void printRevenueRate(UserMoney userMoney, UserLottoRank userLottoRank) {
        long revenue = userLottoRank.getRevenue();
        float revenueRate = userMoney.getRevenueRate(revenue);
        printf(OUTPUT_USER_MONEY_REVENUE_RATE, revenueRate);
    }

    private void printLottoNumbers(Lotto lotto) {
        printf(OUTPUT_LOTTO_NUMBERS + "\n", lotto.getNumbers().toArray());
    }

    private void printLottoRank(UserLottoRank userLottoRank, LottoRank lottoRank) {
        println(findLottoRank(lottoRank) + findUserLottoRankCount(userLottoRank, lottoRank));
    }

    private String findLottoRank(LottoRank lottoRank) {
        StringBuilder output = new StringBuilder();
        output.append(String.format(OUTPUT_LOTTO_RANK_COUNT, lottoRank.getCount()));
        if (lottoRank.getBonus()) {
            output.append(OUTPUT_LOTTO_RANK_BONUS);
        }
        output.append(String.format(OUTPUT_LOTTO_RANK_PRIZE, lottoRank.getPrize()));
        return output.toString();
    }

    private String findUserLottoRankCount(UserLottoRank userLottoRank, LottoRank lottoRank) {
        return String.format(OUTPUT_LOTTO_RANK_RESULT, countUserLottoRank(userLottoRank, lottoRank));
    }

    private int countUserLottoRank(UserLottoRank userLottoRank, LottoRank lottoRank) {
        return (int) userLottoRank.getLottoRanks().stream()
                .filter(rank -> rank.equals(lottoRank))
                .count();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
