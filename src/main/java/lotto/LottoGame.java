package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    
    private LottoBudget lottobudget;
    private int lottoCount;
    private List<Lotto> lottoTicket;
    private WinningNumbers winningNumbers;
    public Map<LottoPrize, Integer> lottoTicketPrize;
    private WinningPrizeCalculator winningPrizeCalculator = new WinningPrizeCalculator();
    
    public void setLottoBudget() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String inputBudgetText = Console.readLine();
        lottobudget = new LottoBudget(inputBudgetText);
        this.lottoCount = lottobudget.getLottoCount();
    }
    
    public void setLottos() {
        lottoTicket = LottoNumberGenerator.generateLottoTicket(lottoCount);
    }
    
    public void printLottoTicket( ) {
        System.out.print(lottoCount);
        System.out.println("개를 구매했습니다.");
        for (Lotto lotto : lottoTicket) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
    
    public void setWinningNumbers() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningText = Console.readLine();
        winningNumbers = new WinningNumbers(inputWinningText);
    }
    
    public void setBonusNumbers() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        winningNumbers.setBonusNumber(inputBonusNumber);
    }
    
    public void setLottoTicketPrize() {
        winningPrizeCalculator.calculateWinningPrize(lottoTicket, winningNumbers);
        lottoTicketPrize = winningPrizeCalculator.getTicketPrize();
    }
    
    public void printLottoTicketPrize() {
        System.out.println("당첨 통계");
        System.out.println("---");
        
        LottoPrize[] lottoPrizeValues = LottoPrize.values();
        
        for (LottoPrize lottoPrize : lottoPrizeValues) {
            if (lottoPrize.name().equals("LESS_THAN_THREE_MATCH")) {
                continue;
            }
            lottoPrize.print(lottoTicketPrize.get(lottoPrize));
        }
    }

    private int getTotalPrize() {
        int totalPrize = 0;
        LottoPrize[] lottoPrizeValues = LottoPrize.values();
        for (LottoPrize lottoPrize : lottoPrizeValues) {
            if (lottoPrize.name().equals("LESS_THAN_THREE_MATCH")) {
                continue;
            }
            totalPrize += (lottoTicketPrize.get(lottoPrize) * lottoPrize.getPrize());
        }
        return totalPrize;
    }
    
    public void printProfitPercentage() {
        double profitPercentage = (double)getTotalPrize() / lottobudget.getLottoBudget() * 100;
        BigDecimal roundedProfitPercentage = new BigDecimal(profitPercentage).setScale(1);
        System.out.print("총 수익률은 ");
        System.out.print(roundedProfitPercentage);
        System.out.print("%입니다.");
    }
}
