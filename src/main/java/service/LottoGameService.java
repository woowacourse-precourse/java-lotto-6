package service;

import static utils.PrintUtils.errorPrint;
import static utils.PrintUtils.println;
import static utils.PrintUtils.printf;

import camp.nextstep.edu.missionutils.Console;
import constants.LottoGameMessage;
import constants.LottoGameResultMessage;
import domain.Lotto;
import domain.LottoGame;
import domain.LottoResult;
import domain.UserLotto;
import java.util.List;

public class LottoGameService {
    private UserLotto userLotto;
    private List<Lotto> lottoList;
    private LottoGame lottoGame = new LottoGame();
    private LottoResultService lottoResultService = new LottoResultService();

    public void runLottoGame(){
        purchaseLottoGame();

        printGetLottoList();

        setInputLottoGame();

        setInputBonusLottoGame();

        printLottoResultStatistic();
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
        lottoList = lottoGame.getLottoList(lottoCount);
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

    private void printLottoResultStatistic(){
        println(LottoGameMessage.WINNING_STATISTICS.toString());

        Object[] statistic = getLottoResultStatistic();
        int i = 0;

        for(LottoGameResultMessage lottoGameResultMessage : LottoGameResultMessage.values()){
            String resultMessage = lottoGameResultMessage
                    .replaceEnumToString(statistic[i]+"");
            println(resultMessage);
            i++;
        }
    }

    private Object[] getLottoResultStatistic(){
        LottoResult resultStatistic = lottoResultService.getLottoResultStatistic(lottoList, userLotto);

        Object[] statistic = {resultStatistic.getThreeLottoWinning()
                , resultStatistic.getFourLottoWinning()
                ,resultStatistic.getFiveLottoWinning()
                ,resultStatistic.getFiveBonusLottoWinning()
                ,resultStatistic.getSixLottoWinning()
                ,resultStatistic.getProfitRate()};
        return statistic;
    }

    private String readInput(){
        return Console.readLine();
    }

}
