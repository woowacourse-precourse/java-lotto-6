package lotto.domain;

import static lotto.ApplicationContext.getDataModel;

import lotto.domain.constant.LottoConstant;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class Wallet {
    private final int wallet;

    public Wallet(int wallet) {
        validate(wallet);
        this.wallet = wallet;
        OutputMessage.printf(MessageType.INPUT_BUYER_FORMAT, this.wallet);
        OutputMessage.printf(MessageType.INPUT_BUY_END, ticketCount());
    }

    private void validate(int wallet) {
        if (isGenerate(wallet)) {
            throw new InputException(ExceptionType.ERROR_TICKETS_GENERATE);
        }
    }

    private boolean isGenerate(int wallet) {
        return wallet % LottoConstant.PRICE_PER_TICKET > 0;
    }

    public int ticketCount(){
        return this.wallet / LottoConstant.PRICE_PER_TICKET;
    }

    public double returnsPercent(double sumPrizeAmount){
        return Math.round((sumPrizeAmount / this.wallet) * 1000) / 10.0;
    }

    public void save() {
        getDataModel().saveWallet(this);
    }
}
