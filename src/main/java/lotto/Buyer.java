package lotto;

import java.util.List;

public class Buyer {
    private int amount;
    private List<Lotto> lottoTickets;

    public Buyer() {
        String amountInput = BuyerInfoInput.inputPurchaseAmount();
        validateAmount(amountInput);
        this.amount = Integer.parseInt(amountInput);
    }

    public int getAmount() {
        return amount;
    }

    public void validateAmount(String amount) {
        Validator.isValidAmount(amount);
        Validator.isAmountDivisibleBy1000(amount);
    }

    // 구매한 금액만큼 로또 발행
    public void purchaseLottoTicket(int amount){

        int lottoTicketCount = amount / 1000;
        for (int i=0; i<amount; i++){
            Lotto lotto = new Lotto(LottoGenerator.generateLottoNumber());
            lottoTickets.add(lotto);
        }
    }


}
