package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.Player;
import view.View;

import java.util.List;

public class LottoGame {

    public View view;
    public LottoGenerator lottoGenerator;
    private Player player;
    private List<Integer> winNumber;
    private int bonusNumber;

    public LottoGame(View view){
        this.view = view;
        this.lottoGenerator = LottoGenerator.getInstance();
    }

    public void execute(){
        inputMoney();
        getWinnerNumber();
        getBonusNumber();
        player.checkMyLottoResults(winNumber, bonusNumber);
        view.showUserLottoResultsView(player.toStringMyLottoResults(), player.getRatioOfReturn());
        exit();
    }

    public void inputMoney(){
        try {
            int money = view.showUserMoneyViewAndGetMoney();
            int issueCount = lottoGenerator.getMaxPurchasableCount(money);
            List<Lotto> lottos = lottoGenerator.issueLottos(issueCount);
            view.printBlank();
            view.showUserPurchasedLottoView(lottos);
            player = new Player(money, lottos);
            view.printBlank();
        }catch (IllegalArgumentException e){
            view.printErrorMsg(e.getMessage());
            inputMoney();
        }
    }

    public void getWinnerNumber(){
        try{
            winNumber = view.showUserWinnerNumberViewAndGetNumbers();
            view.printBlank();
        }catch (IllegalArgumentException e){
            view.printErrorMsg(e.getMessage());
            getWinnerNumber();
        }
    }

    public void getBonusNumber(){
        try{
            bonusNumber = view.showUserBonusNumberViewAndGetNumber(winNumber);
            view.printBlank();
        }catch (IllegalArgumentException e){
            view.printErrorMsg(e.getMessage());
            getBonusNumber();
        }
    }

    public void exit(){
        Console.close();
    }

}
