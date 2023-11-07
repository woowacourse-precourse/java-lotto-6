package lotto;

import lotto.controller.calculation.Calculation;
import lotto.controller.lottomaker.LottoMaker;
import lotto.controller.lottomaker.lottoMakerByRandom;
import lotto.controller.calculation.profitMarginCalculation;
import lotto.repository.LottoRepository;
import lotto.repository.Repository;
import lotto.view.Input;
import lotto.view.InputValidate;
import lotto.view.Output;

public class AppConfig {
    private final Repository repository = new LottoRepository();
    public InputValidate getInputValidate(){
        return new InputValidate(repository);
    }
    public Input getInput(){
        return new Input(getInputValidate());
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
