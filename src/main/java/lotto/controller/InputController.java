package lotto.controller;

import lotto.domain.*;
import lotto.util.Constants;
import lotto.view.InputView;



public class InputController {
    private InputView input;


    public InputController(InputView input) {
        this.input = input;
    }
    public LottoGenerator setCost() {
        while (true) {
            String costInput = input.inputCost();
            try {
                CostValidator costValidator = new CostValidator(costInput);
                return new LottoGenerator(costValidator.getLottoCount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public Lotto setLottoNum(){
        new LottoNumValidator(input.inputLottoNum());
        Lotto lists = new Lotto(LottoNumValidator.lottoNums);
        return lists;
    }
    public int setBonusNum(){
        new BonusNumValidator(input.inputLottoBonusNum());
        return BonusNumValidator.bonusNum;
    }
}
