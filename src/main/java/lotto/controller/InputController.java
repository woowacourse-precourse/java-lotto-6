package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    private InputView input;


    public InputController(InputView input) {
        this.input = input;
    }
    public LottoGenerator setCost(){
        try{
            new CostValidator(input.inputCost());
            return new LottoGenerator(CostValidator.lottoCount);
        }catch (IllegalArgumentException  e){
            throw new IllegalArgumentException();
        }
    }
    public Lotto setLottoNum(){
        new LottoNumValidator(input.inputLottoNum());
        return new Lotto(LottoNumValidator.lottoNums);
    }
    public int setBonusNum(){
        new BonusNumValidator(input.inputLottoBonusNum());
        return BonusNumValidator.bonusNum;
    }
}
