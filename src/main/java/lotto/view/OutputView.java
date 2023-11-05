package lotto.view;

import lotto.domain.Payment;
import lotto.dto.LottoNumbersDto;

public class OutputView {

    private static final String PAYMENT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_GUIDE = "%d개를 구매했습니다.";
    private static final String WINNING_LOTTO_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";

    private OutputView() {
    }

    public static void printPaymentGuide() {
        System.out.println(PAYMENT_GUIDE);
    }

    public static void printPurchasedLottoCount(Payment payment) {
        System.out.printf(addLineSeparator(PURCHASED_LOTTO_COUNT_GUIDE), payment.calculatePurchasedLottoCount());
    }

    public static void printIssuedLottosNumbers(final LottoNumbersDto lottoNumbersDto) {
        System.out.println();
        lottoNumbersDto.getLottosNumbers()
                .forEach(System.out::println);
    }

    public static void printWinningLottoNumbersGuide() {
        System.out.println(addLineSeparator(WINNING_LOTTO_NUMBERS_GUIDE));
    }

    public static void printBonusNumberGuide() {
        System.out.println(addLineSeparator(BONUS_NUMBER_GUIDE));
    }

    private static String addLineSeparator(final String guide) {
        return String.join("", System.lineSeparator(), guide);
    }

}
