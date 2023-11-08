package lotto;

public class Application {
    public static void main(String[] args) {
        
        LottoGame lottoGame = new LottoGame();
        
        boolean setLottoBudgetAgain;
        do {
            setLottoBudgetAgain = false;
            try {
                lottoGame.setLottoBudget();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                setLottoBudgetAgain = true;
            }
        }while(setLottoBudgetAgain);
        System.out.println();
        
        lottoGame.setLottos();
        lottoGame.printLottoTicket();
        System.out.println();
        
        boolean setWinningNumbersAgain;
        do {
            try {
                setWinningNumbersAgain = false;
                lottoGame.setWinningNumbers();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                setWinningNumbersAgain = true;
            }
        }while(setWinningNumbersAgain);
        System.out.println();
        
        boolean setBonusNumbersAgain;
        do {
            try {
                setBonusNumbersAgain = false;
                lottoGame.setBonusNumbers();
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                setBonusNumbersAgain = true;
            }
        }while(setBonusNumbersAgain);
        System.out.println();
        
        lottoGame.setLottoTicketPrize();
        lottoGame.printLottoTicketPrize();
        
        lottoGame.printProfitPercentage();
        
    }
}
