package lotto;

public class Application {
    public static void main(String[] args) {
    	try {
	        Lotto lotto = new Lotto(LottoInput.getPurchaseAmount(),
	        		LottoInput.getWinningNumber(),
	        		LottoInput.getBonusNumber());
	        
	        lotto.lottoPlay();
    	} catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    	}
    }
}
