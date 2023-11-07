package lotto.Controller;

import lotto.Model.Service.RaffleService;
import lotto.View.LottoInput;
import lotto.View.LottoOutput;

public class RaffleController {

    private final RaffleService raffleService;
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public RaffleController(RaffleService raffleService, LottoInput lottoInput,
            LottoOutput lottoOutput) {
        this.raffleService = raffleService;
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void setRaffle() {
        raffleService.setRaffleNumber(lottoInput.inputWinningNumber(),
                lottoInput.inputBonusNumber());
    }
}
