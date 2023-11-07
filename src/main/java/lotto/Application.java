package lotto;

public class Application {
    public static void printConsole(String flag){
        System.out.println(flag + "을 입력해 주세요.");
    }

    public static void checkAllLotto(WinLotto winLotto, UserData userData){
        for(int i = 0; i<userData.lottoCount;i++){
            userData.checkLotto(winLotto, userData.userLotto.get(i));
        }
    }

    public static void main(String[] args) {
        try{
            printConsole("구입금액");
            UserData userData = new UserData();

            System.out.println(userData.money);

            System.out.printf("\n%d개를 구매했습니다.\n", userData.lottoCount);
            userData.printUserLotto();

            System.out.println();
            printConsole("당첨 번호");
            WinLotto winLotto = new WinLotto();

            System.out.println();
            printConsole("보너스 번호");
            winLotto.setBonus();

            checkAllLotto(winLotto, userData);
            userData.printRanks();

            userData.calculateReturnRate();
            System.out.println("총 수익률은 " + String.format("%.1f", userData.returnRate) + "%입니다.");

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
