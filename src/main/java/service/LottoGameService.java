package service;

import static utils.PrintUtils.errorPrint;
import static utils.PrintUtils.println;
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

        printGetLottoList();

        setInputLottoGame();

        setInputBonusLottoGame();

        println(LottoGameMessage.WINNING_STATISTICS.toString());

    }

    private void purchaseLottoGame(){
        boolean isAmount = false;

        while(!isAmount){
            println(LottoGameMessage.PURCHASE_AMOUNT.toString());
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


    private void printGetLottoList(){
        int lottoCount = userLotto.getLottoCount();

        printf(LottoGameMessage.PURCHASED_COUNT.toString(), lottoCount);
        List<Lotto> lottoList = lottoGame.getLottoList(lottoCount);
        lottoList.stream()
                .forEach(lotto -> println(lotto.getNumbers().toString()));
    }


    private void setInputLottoGame(){
        boolean isInputLotto = false;

        while(!isInputLotto){
            println(LottoGameMessage.WINNING_NUMBER.toString());
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
            println(LottoGameMessage.BONUS_NUMBER.toString());
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
