package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto dummy;
        Judgment judge = new Judgment();
        Player test = new Player();

        test.inputAmount();
        test.buyLotto();
        test.printLotto();

        judge.getLotto();
        judge.printAll();
    }
}
