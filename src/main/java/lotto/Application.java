package lotto;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            LottoSystem lottoSystem = new LottoSystem();
            lottoSystem.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

    }
}
