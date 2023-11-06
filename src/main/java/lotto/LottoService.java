package lotto;

import lotto.controller.Calculation;
import lotto.repository.Repository;
import lotto.view.Input;
import lotto.view.Output;

public class LottoService {
    Output output;
    Input input;
    Repository repository;
    Calculation calculation;
    public LottoService(Output output, Input input, Repository repository, Calculation calculation) {
        this.output = output;
        this.input = input;
        this.repository = repository;
        this.calculation = calculation;
    }

    public void game(){
        output.printPurchaseAmount();
        input.getLottoCount();
    }
}
