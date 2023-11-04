package lotto;


public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        int lottoAmount =gameManager.getPaymentForLottoByRead();

        gameManager.getCorrectLottoNumberByRead();
        gameManager.getBonusLottoNumberByRead();
    }
}
