package lotto;

public class Seller {
    private int count;
    public Seller() {}

    public void printAskPurchaseCount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printCheckPurchaseCount(int price) {
        count = price/1000;
        System.out.println("");
        System.out.println( count +"개를 구매했습니다.");
    }

    public void printAskCorrectNumber() {
        System.out.println("");
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printAskBonusNumber() {
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public int getCount(){
        return count;
    }
}
