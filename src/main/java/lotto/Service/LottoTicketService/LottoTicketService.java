package lotto.Service.LottoTicketService;

import java.util.ArrayList;
import java.util.List;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.PurchaseAmount.PurchaseAmount;
import lotto.Service.LottoNumberService.LottoNumberService;
import lotto.Service.PromptService.PromptService;

import static lotto.Common.LottoValue.*;

public class LottoTicketService {
    private final Integer purchaseAmount;

    public LottoTicketService( PromptService Prompt){
        this.purchaseAmount = convertAmountToCount(Prompt.getPurchaseAmount());
    }

    public LottoSet GenerateLottoSet() {

        LottoNumberService lottoService = new LottoNumberService();
        List<Lotto> lottoTicketSet = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            Lotto lottoTicket = lottoService.getUniqueLottoNumber();
            lottoTicketSet.add(lottoTicket);
        }
        return new LottoSet(lottoTicketSet);
    }


    private Integer convertAmountToCount(PurchaseAmount amount) {
        return amount.getPurchaseAmount() / LOTTO_ONE_TICKET_PRICE.getValue();
    }

}
