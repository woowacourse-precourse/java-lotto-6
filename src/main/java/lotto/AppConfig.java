package lotto;

import lotto.controller.calculation.Calculation;
import lotto.controller.lottery.Lottery;
import lotto.controller.lottery.lotteryCheckUsingSet;
import lotto.controller.lottomainservice.LottoService;
import lotto.controller.lottomaker.LottoMaker;
import lotto.controller.lottomaker.lottoMakerByRandom;
import lotto.controller.calculation.profitMarginCalculation;
import lotto.repository.LottoRepository;
import lotto.repository.Repository;
import lotto.view.Input;
import lotto.view.Output;

public class AppConfig {
    private final Repository repository = new LottoRepository();
    private Input getInput(){
        return new Input(repository);
    }
    private Output getOutput(){
        return new Output();
    }
    private Calculation getCalculation(){
        return new profitMarginCalculation();
    }
    private LottoMaker getLottoMaker(){
        return new lottoMakerByRandom();
    }
    private Lottery getLottery(){return new lotteryCheckUsingSet(); }
    public LottoService getLottoService(){
        return new LottoService(getOutput(), getInput(),repository , getCalculation(), getLottoMaker(), getLottery());
    }
}
