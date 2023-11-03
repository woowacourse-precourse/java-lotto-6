package lotto;

public class ResultService {
    public static int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / InputService.AMOUNT_UNIT;
    }

    public static void printNumberOfLottoTickets(int purchaseAmount) {
        System.out.printf("%d개를 구매했습니다.", purchaseAmount);
    }


}
