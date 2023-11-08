package lotto.controller;

import lotto.model.PrizeResultDto;
import lotto.util.*;
import lotto.view.InputView;

public class Game {

    private int lottoCount; // 구입한 로또 장 수

    public Game() {}

    public static Game create(){
        return new Game();
    }

    public void setLottoCount() {
        String inputStringValue = InputView.inputBuyValue();

        try{
            this.lottoCount = ValidateInputBuy.validateInputBuy(inputStringValue) / 1000;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setLottoCount();
        }

    }

}
