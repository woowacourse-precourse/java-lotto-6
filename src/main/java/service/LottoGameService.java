package service;

import static utils.PrintUtils.errorPrint;
import static utils.PrintUtils.print;
import static utils.PrintUtils.printf;

import camp.nextstep.edu.missionutils.Console;
import constants.LottoGameMessage;
import domain.Lotto;
import domain.LottoGame;
import domain.UserLotto;
import java.util.List;

public class LottoGameService {
    private UserLotto userLotto;
    private LottoGame lottoGame = new LottoGame();

    public void runLottoGame(){
        purchaseLottoGame();

        printf(LottoGameMessage.PURCHASED_COUNT.toString(), userLotto.getLottoCount());
        List<Lotto> lottoList = lottoGame.getLottoList(userLotto.getLottoCount());
        lottoList.stream()
                .forEach(lotto -> print(lotto.getNumbers().toString()));

        setInputLottoGame();

        setInputBonusLottoGame();
    }

    private void purchaseLottoGame(){
        boolean isAmount = false;

        while(!isAmount){
            print(LottoGameMessage.PURCHASE_AMOUNT.toString());
            isAmount = isGetUserLotto(readInput());
        }
    }

    public boolean isGetUserLotto(String purchasedAmount){
        try{
            userLotto = new UserLotto(purchasedAmount);
        }catch (IllegalArgumentException iae){
            errorPrint(iae.getMessage());
            return false;
        }
        return true;
    }

    private void setInputLottoGame(){
        boolean isInputLotto = false;

        while(!isInputLotto){
            print(LottoGameMessage.WINNING_NUMBER.toString());
            try{
                userLotto.setInputLotto(readInput());
                isInputLotto = true;
            }catch (IllegalArgumentException iae){
                errorPrint(iae.getMessage());
            }
        }
    }

    private void setInputBonusLottoGame(){
        boolean isInputBonusLotto = false;

        while(!isInputBonusLotto){
            print(LottoGameMessage.BONUS_NUMBER.toString());
            try{
                userLotto.setInputBonusLotto(readInput());
                isInputBonusLotto = true;
            }catch (IllegalArgumentException iae){
                errorPrint(iae.getMessage());
            }
        }
    }

    private String readInput(){
        return Console.readLine();
    }

}
