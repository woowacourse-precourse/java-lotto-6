package lotto;

import lotto.controller.Calculation;
import lotto.repository.Repository;
import lotto.view.Input;
import lotto.view.Output;

public class LottoService {
    private boolean isUseFulLottoCount = true;
    private boolean isUseFulAnswerLotto = true;
    private boolean isUseFulBonusNumber = true;
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
        do {
            repository.setCountLotto(input.getLottoCount());
            if(repository.getCountLotto() != 0){
                isUseFulLottoCount = false;
            }
        }while(isUseFulLottoCount);
        
    }
}
