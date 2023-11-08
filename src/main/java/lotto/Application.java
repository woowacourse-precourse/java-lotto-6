package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            LottoManager lottoManager = new LottoManager();
            lottoManager.run();
        }catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
