package lotto;

import java.math.BigDecimal;
import java.util.List;

public class LottoController {
    private final Communicator communicator;
    private final LottoService lottoService;

    public LottoController(Communicator communicator, LottoService lottoService) {
        this.communicator = communicator;
        this.lottoService = lottoService;
    }

    public void run() {
        BigDecimal payment = settlePayment();
        List<Lotto> lotteries = lottoService.generateLotteries(payment);
        communicator.printLotteriesBought(lotteries);
    }

    private BigDecimal settlePayment() {
        BigDecimal payment = BigDecimal.ZERO;
        while(payment.equals(BigDecimal.ZERO)) {
            payment = receivePayment();
        }
        return payment;
    }

    private BigDecimal receivePayment() {
        try {
            return communicator.instructBuy();
        } catch (IllegalArgumentException exception) {
            communicator.printException(exception);
            return BigDecimal.ZERO;
        }
    }
}
