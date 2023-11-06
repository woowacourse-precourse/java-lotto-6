package lotto;

public class BuyingController {

    AppManager appManager = new AppManager();
    LottoManager lottoManager = new LottoManager();
    IOManager ioManager = new IOManager();

    public void handle() {

        ioManager.printPayAmountGuide();
        int payAmount = ioManager.readPayAmount();

        try {
            int lottoTicketsCount = lottoManager.generateLottoTickets(payAmount);
            lottoManager.setLottoTicketCount(lottoTicketsCount);
            ioManager.printLottoTicketCount(lottoManager.getLottoTicketCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            String className = this.getClass().getName();
            appManager.handleInvalidInput(className);
        }
    }
}
