package lotto.view;

public class OutputView {
    public static void printQuantityOfLotto(int quantity){
        System.out.println(quantity+"개를 구매했습니다.");
    }
    public static void printRequestPurchaseAmont(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printRequestWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLotto(){}
    public static void printWinningStatics(){}

    public static void printTotalRevenue(double revenue){
        System.out.println("총 수익률은 "+revenue+"%입니다.");
    }
}
