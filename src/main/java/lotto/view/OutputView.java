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

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoRankManager;
import lotto.model.UserLotto;
import lotto.model.UserMoney;
import lotto.model.WinningNumbers;

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

    public void printLottoRanks(UserLotto userLotto, WinningNumbers winningNumbers) {
        List<LottoRank> result = LottoRankManager.findLottoRanks(userLotto.getLottos(), winningNumbers);
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .forEach(lottoRank -> println(printLottoRank(lottoRank) + printLottoCount(result, lottoRank)));
    }

    private void printLottoNumbers(Lotto lotto) {
        printf(OUTPUT_LOTTO_NUMBERS + "\n", lotto.getNumbers().toArray());
    }

    private String printLottoRank(LottoRank lottoRank) {
        StringBuilder output = new StringBuilder();
        output.append(String.format(OUTPUT_LOTTO_RANK_COUNT, lottoRank.getCount()));
        if (lottoRank.getBonus()) {
            output.append(OUTPUT_LOTTO_RANK_BONUS);
        }
        output.append(String.format(OUTPUT_LOTTO_RANK_PRIZE, lottoRank.getPrize()));
        return output.toString();
    }

    private String printLottoCount(List<LottoRank> result, LottoRank lottoRank) {
        return String.format(OUTPUT_LOTTO_RANK_RESULT, countLottoResult(result, lottoRank));
    }

    private int countLottoResult(List<LottoRank> result, LottoRank lottoRank) {
        return (int) result.stream()
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
