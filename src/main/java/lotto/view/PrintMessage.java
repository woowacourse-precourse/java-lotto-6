package lotto.view;

import lotto.domain.LottoPrize;

public class PrintMessage {
    private static String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
    }

    public static void printWinnigLotto() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
    }

    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printPrizes(LottoPrize lottoPrize, int count) {
        String result = lottoPrize.getMatches() + "개 일치";
        if (lottoPrize.isBonus()) {
            result += ", 보너스 볼 일치 ";
        }
        result += "(" + lottoPrize.getPrize() + "원) - " + count + "개";
        System.out.println(result);
    }
}
