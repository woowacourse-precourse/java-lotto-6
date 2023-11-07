
package lotto.model.lottoGenerator;

public class LottoTicketCalculator {
    public int calculateNumberOfTickets(int purchaseAmount) {
        return purchaseAmount /  1000;
    }
}