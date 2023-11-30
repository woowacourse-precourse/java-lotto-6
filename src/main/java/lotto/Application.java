package lotto;

public class Application {
    public static void main(String[] args) {
    	DrawLotto drawLotto = new DrawLotto();
    	Person person = new Person();
    	LottoMachine lottoMachine = new LottoMachine();
    	
    	try {
            person.buyLotto(lottoMachine);
            person.displayTicket();
            int[] result = person.checkWinningNumber(drawLotto);
            person.displayResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
