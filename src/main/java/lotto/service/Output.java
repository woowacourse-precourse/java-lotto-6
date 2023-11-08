package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoReceipt;

public class Output {
    public static final String MESSAGE_NUMBER_OF_LOTTO_PURCHASED = "%d개를 구매했습니다.";
    public static final String MESSAGE_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";
    public static final String LOTTO_WINNING_STATICS = "당첨 통계";
    public static final String LINE = "---";

    public static void printLottoReceipt(LottoReceipt lottoReceipt) {
        List<Lotto> lottoTickets = lottoReceipt.getLottoTickets();
        System.out.println();
        System.out.printf((MESSAGE_NUMBER_OF_LOTTO_PURCHASED) + "%n", lottoTickets.size());
        lottoTickets.forEach(System.out::println);
    }

    public static void printLottoWinningResults() {

    }

    public static void printProfitRate() {

    }

    public static void printErrorMessage() {

    }
}
