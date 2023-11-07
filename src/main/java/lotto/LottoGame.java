package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    
    private LottoBudget lottobudget;
    private int lottoCount;
    private List<Lotto> lottoTicket;
    
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
    
    
    
    

    
}
