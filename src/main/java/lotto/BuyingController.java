package lotto;

public class BuyingController {

    LottoManager lottoManager = new LottoManager();

    public void handle(String payAmount) {
        int lottoTicketsCount = lottoManager.generateLottoTickets(Integer.parseInt(payAmount));
    }
}
