package Controller;

import Model.MoneyCalculateModel;
import Model.PurchaseLottoModel;
import Model.RankCalculateModel;
import View.UserInput;
import lotto.Lotto;
import lotto.Rank;

import javax.management.relation.RelationNotification;
import java.util.List;

public class LottoGame {
    public LottoGame(){

    }
    private static UserInput userInput=new UserInput();
    private static List<Lotto> lottoList;
    private static Integer winningBonusNum;
    private static List<Rank> rankList;
    public void gameStart(){
        //1. User에게 구매 가격 입력을 받는다.
        Integer purchaseAmount= userInput.getPurchaseAmount();
        // User가 구입한 장수, 로또 보여준다.
        PurchaseLottoModel userPurchaseLottos=new PurchaseLottoModel(purchaseAmount);
        lottoList=userPurchaseLottos.getLottoList();

        //당첨 번호 6개를 입력받는다.
        Lotto winningLotto =userInput.getWinningNum();
        //보너스 번호 1개를 입력받는다.
        winningBonusNum= userInput.getBonusNum();

        //2. 통계 계산 시작
        System.out.println("당첨 통계");
        System.out.println("---");
        // 당첨 수 확인
        RankCalculateModel rankCalculateModel=new RankCalculateModel(lottoList,winningLotto,winningBonusNum);
        rankCalculateModel.printRank();
        // 당첨 금액, 수익률 확인
        MoneyCalculateModel moneyCalculateModel=new MoneyCalculateModel(purchaseAmount,rankCalculateModel);
        moneyCalculateModel.printNiceMoneyPercentage();


    }
}
