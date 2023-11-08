package lotto.controller;

import lotto.model.Lotto;
import lotto.util.*;
import lotto.view.InputView;
import lotto.view.OutputLotto;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private int lottoCount; // 구입한 로또 장 수
    private List<Lotto> lottoList = new ArrayList<>(); // 구입한 로또 리스트
    private Lotto winningLotto; // 당첨 번호
    private int winningBonusNumber; // 보너스 번호

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

    public void printLottoList(List<Lotto> lottoList){
        OutputLotto.printLottoList(lottoList);
    }

    public void setWinningLotto(){

        try{
            String inputStringValue = InputView.inputWinningNumber();
            this.winningLotto =  new Lotto(ValidateWinningNumber.validateWinningNumber(inputStringValue));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setWinningLotto();
        }

    }

    public void setWinningBonusNumber(){

        try{
            String inputStringValue = InputView.inputBonusNumber();
            ValidateWinningNumber.validateBonusNumber(inputStringValue);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setWinningBonusNumber();
        }

    }

}
