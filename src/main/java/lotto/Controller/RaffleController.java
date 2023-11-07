package lotto.Controller;

import lotto.Model.Service.RaffleService;
import lotto.View.LottoInput;

public class RaffleController {

    private final RaffleService raffleService;
    private final LottoInput lottoInput;

    public RaffleController(RaffleService raffleService, LottoInput lottoInput) {
        this.raffleService = raffleService;
        this.lottoInput = lottoInput;
    }

    public void setRaffle() {
        raffleService.setRaffleNumber(lottoInput.inputWinningNumber(),
                lottoInput.inputBonusNumber());
    }
}
