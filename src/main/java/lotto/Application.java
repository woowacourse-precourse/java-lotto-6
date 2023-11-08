package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine LM = new LottoMachine();

        LM.getMoney();
        LM.makeLotto();
        LM.printLotto();
        LM.getWin();
        LM.addBonus();
    }
}
