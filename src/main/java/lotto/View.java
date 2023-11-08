package lotto;

public class View {
    public static void printPurchaseLottoNumber(int purchaseNumber){
        System.out.println(purchaseNumber+"개를 구매했습니다.");
    }

    public static void printAllLotto(Lotto[] lottos,int purchaseNumber){
        for(int i=0; i<purchaseNumber;i++){
            System.out.println(lottos[i].getLottoNumbers());
        }
        System.out.println();
    }

    public static void printLottoResultBoard(){
        System.out.println("당첨통계");
        System.out.println("---");
    }

    public static void printNumberOfMatch(int numberOfMatch){
        System.out.print(numberOfMatch + "개 일치");
    }

    public static void printBonusNumberOfMatch(){
        System.out.print(", 보너스 볼 일치");
    }

    public static void printLottoResult(int winningMoney,int winningCount){
        System.out.println(" ("+ String.format("%,d",winningMoney)+ "원) - "+ winningCount + "개");
    }

    public static void printRateOfReturn(float rateOfReturn){
        System.out.println("총 수익률은 "+ String.format("%.1f", rateOfReturn)+"%입니다.");
    }
}
