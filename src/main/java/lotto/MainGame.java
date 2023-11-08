package lotto;

import lotto.domain.LottoBuy;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinCheck;
import lotto.util.InputUtil;
import lotto.util.MessageUtil;

public class MainGame {
    private final InputUtil inputUtil = new InputUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoBuy lottoBuy = new LottoBuy();
    private final LottoWinCheck lottoWinCheck = new LottoWinCheck();


    public void play(){
        messageUtil.printBuyInput();
        boolean playing = true;
        while(playing){
            try{
                String amount = inputUtil.getInput();
                LottoBuy buyInfo = lottoBuy.lottoBuyInfo(amount);
                seperatePlay(buyInfo);
                playing = false;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
    }
    private void seperatePlay(LottoBuy buyInfo){
        boolean playing = true;
        while(playing){
            try{
                String playerNums = messageUtil.printWinningInput();
                lottoWinCheck.getPlayerNumbersInfo(playerNums);
                LottoStatistics lottoStatistics = new LottoStatistics(lottoWinCheck);
                lottoStatistics.getLottoStatistics(buyInfo.getUserLottos(), buyInfo.getUserAmount());
                playing = false;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }



}
