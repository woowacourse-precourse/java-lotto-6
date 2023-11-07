package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.YieldRate;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_MESSAGE_TEXT = "[ERROR] %s\n";
    private static final String PURCHASE_PRICE_INPUT_TEXT = "구입금액을 입력해 주세요.\n";
    private static final String TICKET_NUMBER_TEXT = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBERS_TEXT = "[%s]\n";
    private static final String LOTTO_NUMBERS_INPUT_TEXT = "당첨 번호를 입력해 주세요.\n";
    private static final String BONUS_NUMBER_INPUT_TEXT = "보너스 번호를 입력해 주세요.\n";
    private static final String LOTTO_RESULT_START_TEXT = "당첨 통계\n";
    private static final String YIELD_RATE_TEXT = "총 수익률은 %.1f%%입니다.\n";
    private static final String BOUNDARY = "---\n";

    private OutputView() {
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach((lotto) -> {
            String lottoNumbers = lotto.getNumbers().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.printf(LOTTO_NUMBERS_TEXT, lottoNumbers);
        });
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_TEXT, errorMessage);
    }

    public static void printPurchasePriceInputText() {
        System.out.print(PURCHASE_PRICE_INPUT_TEXT);
    }

    public static void printTicketNumber(LottoTicket lottoTicket) {
        System.out.println();
        System.out.printf(TICKET_NUMBER_TEXT, lottoTicket.getTicketNumber()
        );
    }

    public static void printLottoNumbersInputText() {
        System.out.print(LOTTO_NUMBERS_INPUT_TEXT);
    }

    public static void printBonusNumberInputText() {
        System.out.println();
        System.out.print(BONUS_NUMBER_INPUT_TEXT);
    }

    public static void printLottoResultStartText() {
        System.out.println();
        System.out.print(LOTTO_RESULT_START_TEXT);
        System.out.print(BOUNDARY);
    }

    public static void printLottoResult(Rank rank) {
        System.out.printf(rank.getPrizeText(), rank.getCount());
    }

    public static void printYieldRate(YieldRate yieldRate) {
        System.out.printf(YIELD_RATE_TEXT, yieldRate.getYieldRate());
    }
}
