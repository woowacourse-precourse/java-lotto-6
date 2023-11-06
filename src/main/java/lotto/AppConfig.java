package lotto;

import lotto.controller.Calculation;
import lotto.controller.profitMarginCalculation;
import lotto.repository.LottoRepository;
import lotto.repository.Repository;
import lotto.view.Input;
import lotto.view.InputValidate;
import lotto.view.Output;

public class AppConfig {
    public Repository getRepository(){
        return new LottoRepository();
    }
    public InputValidate getInputValidate(){
        return new InputValidate(getRepository());
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
    public LottoService getLottoService(){
        return new LottoService(getOutput(), getInput(), getRepository(), getCalculation());
    }
}
