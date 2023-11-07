package lotto;

public class PrintWinningResult {

    static int[] lottoResult;

    public PrintWinningResult(int[] lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void printLottoResult(){

        int[] result = lottoResult;

        System.out.println("3개 일치 (5,000원) - "+result[1]+"개");
        System.out.println("4개 일치 (50,000원) - "+ result[2]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ result[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ result[4]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ result[5]+"개");

    }

    public void printProfitResult(double profitPercentage){
        //브랜치 변경하기
        System.out.println("총 수익률은 "+ profitPercentage +"%입니다.");
    }
}
