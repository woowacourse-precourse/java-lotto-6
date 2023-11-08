package lotto;


import lotto.exception.UserAbortException;

public class Application {
    public static void main(String[] args) {
        try {
            LottoSystem lottoSystem = new LottoSystem();
            lottoSystem.run();
        } catch (UserAbortException e) {
            System.out.println("게임 종료");
        }
    }
}
