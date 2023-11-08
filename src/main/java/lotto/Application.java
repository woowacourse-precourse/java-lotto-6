package lotto;

public class Application {
    public static void main(String[] args) {
        UserCase userCase = new UserCase(new LottoDrawMachine(), new LottoSalesMachine());
        userCase.run();
    }
}
