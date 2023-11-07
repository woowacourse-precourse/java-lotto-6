package lotto.Controller;

import lotto.Model.Domain.Statics;
import lotto.Model.Service.StaticsService;
import lotto.View.LottoInput;
import lotto.View.LottoOutput;

public class StaticsController {

    private final StaticsService staticsService;
    private final LottoOutput lottoOutput;

    public StaticsController(StaticsService staticsService,
            LottoOutput lottoOutput) {
        this.staticsService = staticsService;
        this.lottoOutput = lottoOutput;
    }

    public void setStatics() {
        lottoOutput.printResult(staticsService.createStatics());
    }
}
