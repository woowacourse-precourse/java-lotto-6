package lotto;

import lotto.controller.Calculation;
import lotto.controller.LottoMaker;
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
    LottoMaker lottoMaker;
    public LottoService(Output output, Input input, Repository repository, Calculation calculation, LottoMaker lottoMaker) {
        this.output = output;
        this.input = input;
        this.repository = repository;
        this.calculation = calculation;
        this.lottoMaker = lottoMaker;
    }

    public void game(){
        output.printPurchaseAmount();
        getMoney();

        makeRandomLotto();
        output.printRandomLottoNum(repository.getLottoNumbers());
    }

    private void getMoney() {
        do {
            repository.setCountLotto(input.getLottoCount());
            if(repository.getCountLotto() != 0){
                isUseFulLottoCount = false;
            }
        }while(isUseFulLottoCount);
    }

    private void makeRandomLotto(){
        for(int i = 0; i<repository.getCountLotto(); i++){
            repository.saveLottoNumbers(new Lotto(lottoMaker.makeLotto()));
        }
    }
}
