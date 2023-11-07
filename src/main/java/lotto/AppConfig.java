package lotto;

import lotto.controller.calculation.Calculation;
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
    public Input getInput(){
        return new Input(repository);
    }
    public Output getOutput(){
        return new Output();
    }
    public Calculation getCalculation(){
        return new profitMarginCalculation();
    }
    public LottoMaker getLottoMaker(){
        return new lottoMakerByRandom();
    }
    public LottoService getLottoService(){
        return new LottoService(getOutput(), getInput(),repository , getCalculation(), getLottoMaker());
    }
}
