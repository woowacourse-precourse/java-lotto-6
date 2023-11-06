package lotto;

public class View {

    void printAskMoneyInput(){

        String askInputMoney= "구입금액을 입력해 주세요.";
        System.out.println(askInputMoney);
    }

    void printPurchasedLottoAmount(int number){

        String askInputMoney= "개를 구매했습니다.";

        System.out.println("\n"+number+askInputMoney);
    }

    void printPurchasedLottoNumbers(Lotto lotto){

        System.out.println(lotto.getNumbers());
    }
    
    void printAskWinningNumber(){
        
        String askWinningNumber = "\n당첨 번호를 입력해 주세요.";

        System.out.println(askWinningNumber);
    }

    void printAskBonusNumber(){

        String asKBonusNumber = "\n보너스 번호를 입력해 주세요.";

        System.out.println(asKBonusNumber);
    }

    void printWinStat(LottoGame lottoGame, User user){

        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - "+lottoGame.getRank(WinningConditionPrize.FIFTH)+"개");
        System.out.println("4개 일치 (50,000원) - "+lottoGame.getRank(WinningConditionPrize.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+lottoGame.getRank(WinningConditionPrize.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+lottoGame.getRank(WinningConditionPrize.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+lottoGame.getRank(WinningConditionPrize.FIRST)+"개");
        double earn = (Math.round(user.getTotalWinningAmount()/user.getAmountLotto())*10)/100.0;
        System.out.println("총 수익률은 "+earn+"%입니다.");
    }
}
