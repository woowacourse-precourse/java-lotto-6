package lotto;

public class BuyingController {

    private final AppManager appManager = new AppManager();
    private final LottoManager lottoManager = LottoManager.getInstance();
    private final IOManager ioManager = new IOManager();

    public void handle() {

        ioManager.printPayAmountGuide();
        int payAmount = ioManager.readPayAmount();

        try {
            int lottoTicketsCount = lottoManager.generateLottoTickets(payAmount);
            lottoManager.setLottoTicketCount(lottoTicketsCount);
            ioManager.printLottoTicketCount(lottoManager.getLottoTicketCount());
        } catch (IllegalArgumentException e) {
            ioManager.printExceptionMessage(e.getMessage());
            String className = this.getClass().getName();
            appManager.handleInvalidInput(className);
        }
    }
}
