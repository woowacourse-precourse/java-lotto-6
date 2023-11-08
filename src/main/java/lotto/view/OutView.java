package lotto.view;

public class OutView {

    private static final String WINNING_STATIC_MESSAGE = "당첨 통계";
    private static final String CONTOUR = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printTicketQuantity(int ticketQuantity) {
        System.out.println("\n" + ticketQuantity + "개를 구매했습니다.");
    }

    public void printConsumerLottos(String numbers) {
        System.out.println("[" + numbers + "]");
    }

    public void printWinningStaticInfoMessage() {
        System.out.println("\n" + WINNING_STATIC_MESSAGE);
        System.out.println(CONTOUR);
    }

    public void printRanking(String message, int numbersOfWinning) {
        System.out.println(message + numbersOfWinning + "개");
    }

    public void printRateOfReturn(float rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

}
