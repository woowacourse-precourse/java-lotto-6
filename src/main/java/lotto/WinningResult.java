package lotto;

public class WinningResult {
    int resultLottoTree = 0;
    int resultLottoFour = 0;
    int resultLottoFive = 0;
    int resultLottoBouns = 0;
    int resultLottoSix = 0;
    private final long moneyTree = 5000;
    private final long moneyFour = 50000;
    private final long moneyFive = 1500000;
    private final long moneyBonus = 30000000;
    private final long moneySix = 2000000000;
    private final long resultsum = (resultLottoTree*moneyTree) + (resultLottoFour*moneyFour)+(resultLottoFive*moneyFive)+
            (resultLottoBouns*moneyBonus)+(resultLottoSix*moneySix);


    private void resultCheck(WinningCalcuation resultCalculation){
        if (resultCalculation.checking == 3)resultLottoTree+=1;
        if(resultCalculation.checking ==4) resultLottoFour+=1;
        if(resultCalculation.checking ==5) resultLottoFive+=1;
        if(resultCalculation.checking==5 && resultCalculation.bonuschk) resultLottoBouns+=1;
        if(resultCalculation.checking==6) resultLottoSix+=1;
    }
    private void resultPrint(){
        System.out.println("당첨 통계\n");
        System.out.println("---\n");
        System.out.println("3개 일치(5,000원) - "+resultLottoTree+"개\n");
        System.out.println("4개 일치(50,000원) - "+resultLottoFour+"개\n");
        System.out.println("5개 일치(1,500,000원) - "+resultLottoFive+"개\n");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+resultLottoBouns+"개\n");
        System.out.println("6개 일치(2,000,000,000원) - "+resultLottoSix+"개\n");
    }
    private void resultAvg(BuyLotto buyMoney){
        long rateReturn = (resultsum/buyMoney.buyMoney)*100;
        System.out.println("총 수익률은 "+rateReturn+"%입니다.");
    }
}
