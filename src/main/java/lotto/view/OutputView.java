package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.domain.LottoIndexEnum.*;
import static lotto.domain.OutputEnum.*;

public class OutputView {

    public void printLottoAmount() {
        System.out.println(LOTTO_AMOUNT.getOutput());
    }

    public void printLottoCount(Integer price) {
        System.out.printf(String.valueOf(LOTTO_COUNT.getOutput()), price);
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningNum() {
        System.out.println(WINNING_NUM.getOutput());
    }

    public void printBonusNum() {
        System.out.println(BONUS_NUM.getOutput());
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS.getOutput());
    }

    public void printMatchNum(List<Integer> matchCountFrequency, List<String> reward) {
        for (int i = 3; i < 8; i++) {
            if (i <= IS_UNDER_3RD.getLottoNum()) {
                System.out.printf(String.valueOf(MATCH_COUNT_FREQUENCY.getOutput()), i, reward.get(i), matchCountFrequency.get(i));
            }
            if (i == IS_2ND.getLottoNum()) {
                System.out.printf(String.valueOf(MATCH_COUNT_FREQUENCY_2ND.getOutput()), i - 1, reward.get(i), matchCountFrequency.get(i));
            }
            if (i == IS_1ST.getLottoNum()) {
                System.out.printf(String.valueOf(MATCH_COUNT_FREQUENCY.getOutput()), i - 1, reward.get(i), matchCountFrequency.get(i));
            }
        }
    }

    public void printReturnRate(float returnRate) {
        System.out.printf(String.valueOf(RETURN_RATE.getOutput()), returnRate);
    }
}
