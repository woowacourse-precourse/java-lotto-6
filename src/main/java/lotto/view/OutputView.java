package lotto.view;

public class OutputView {

    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void howPurchase(int amountLotto){
        System.out.println(amountLotto + "개를 구매했습니다.");
    }

    public void inputNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void resultLotto(){
        System.out.println("3개 일치 (5,000원) - " + "개");
        System.out.println("4개 일치 (50,000원) - " + "개");
        System.out.println("5개 일치 (1,500,000원) - " + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + "개");
    }

    public void resultGet(float get){
        System.out.println("총 수익률은 " + get +" %입니다.");
    }
}
