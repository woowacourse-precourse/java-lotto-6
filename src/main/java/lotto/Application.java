package lotto;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(LottoInput.getPurchaseAmount(),
        		LottoInput.getWinningNumber(),
        		LottoInput.getBonusNumber());
    }
}
