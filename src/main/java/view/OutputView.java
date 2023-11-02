package view;

public class OutputView {
    private OutputView() {
    }

    public static int LottoTicketCount(int money) {
        int ticketCount = money / 1000;
        String output = String.format("%d개를 구매했습니다.", ticketCount);

        System.out.println(output);
        return ticketCount;
    }
}
