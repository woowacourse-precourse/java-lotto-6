package view;

public class Mainview {

    private final static String[] MONEY_OF_WINNING = {"5,000원", "50,000원", "1,500,000원",
            "30,000,000원", "2,000,000,000원"};

    public void askForHowMany() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void requestNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printresult(int[] result) {
        System.out.println("당첨통\n---");
        for (int i = 0; i < result.length; i++) {
            System.out.println(3 + i + "개 일치 ("+MONEY_OF_WINNING[i]+" -"+result[i]+"개");
        }
    }
}
