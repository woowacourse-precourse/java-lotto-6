package lotto;

public class Output {
    private static final String NUMBER_OF_PURCHAGE = "개를 구매했습니다.";

    public void printNumberOfPurchase(int lottoTicket) {
        System.out.println("\n" + lottoTicket + NUMBER_OF_PURCHAGE);
    }
}
