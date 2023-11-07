package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;



public class InputController {
    private InputView input;


    public InputController(InputView input) {
        this.input = input;
    }
    public LottoGenerator setCost(){
        try{
            new CostValidator(input.inputCost());
            return new LottoGenerator(CostValidator.lottoCount);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public Lotto setLottoNum(){
        //new LottoNumValidator(input.inputLottoNum());
        //return new Lotto(LottoNumValidator.lottoNums);
        new LottoNumValidator(input.inputLottoNum());
        Lotto lists = new Lotto(LottoNumValidator.lottoNums);
        return lists;
    }
    public int setBonusNum(){
        new BonusNumValidator(input.inputLottoBonusNum());
        return BonusNumValidator.bonusNum;
    }
}
