package lotto.controller;

import lotto.model.Lotto;
import lotto.util.*;
import lotto.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private int lottoCount; // 구입한 로또 장 수
    private List<Lotto> lottoList = new ArrayList<>(); // 구입한 로또 리스트

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

    public void setLottoList(int lottoCount){
        this.lottoList =  GenerateLotto.generateLottoList(lottoCount);
    }

}
