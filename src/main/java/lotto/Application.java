package lotto;

public class Application {
    public static void printConsole(String flag){
        System.out.println(flag + "을 입력해 주세요.");
    }

    public static void main(String[] args) {
        printConsole("구입금액");
        UserData userData = new UserData();

        System.out.println(userData.money);

        System.out.printf("\n%d개를 구매했습니다.\n", userData.lottoCount);
        userData.printUserLotto();

        System.out.println();
        printConsole("당첨 번호");
        WinLotto winLotto = new WinLotto();



    }
}
