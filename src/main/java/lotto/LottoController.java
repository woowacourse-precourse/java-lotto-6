package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.view.InputMaker;
import lotto.view.OutputMaker;


public class LottoController {
    private TicketMaster ticketMaster;
    private InputMaker inputMaker;
    private OutputMaker outputMaker;
    private Customer cs;
    private Analyst analyst;

    LottoController() {
        this.ticketMaster = new TicketMaster();
        this.inputMaker = new InputMaker();
        this.outputMaker = new OutputMaker();
    }

    public void insertCoin() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String inputText = Console.readLine();
            int coin = inputMaker.inputNum(inputText);
            inputMaker.inputCoinValidate(coin);
            this.cs = new Customer(coin);
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] 유효한 숫자를 입력해주세요.");
        }
    }

    public void buyLotto() {
        int lottoSize = cs.getWallet();
        System.out.println(lottoSize/1000+"개를 구매했습니다.");
        while(cs.getWallet()!=0) {
            Lotto newLotto = ticketMaster.makeTicket();
            System.out.println(outputMaker.printLotto(newLotto));
            cs.pay(LottoRole.LOTTO_PRICE.getNumber());
            cs.addCustomerLotto(newLotto);
        }
    }

    public void setWinner() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winner = new Lotto(inputMaker.inputWinningNumber(Console.readLine()));
        ticketMaster.setWinningNum(winner);
    }

    public void setBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        ticketMaster.setBonusNum(inputMaker.inputNum(Console.readLine()));
    }

    public void resultLotto() {
        int ticketSize = cs.getHasTicket();
        this.analyst = new Analyst(ticketSize);
        for (int i = 0; i < ticketSize; i++) {
            Lotto thisLotto = cs.getCustomerLotto(i);
            int winningCount = ticketMaster.checkLotto(thisLotto);
            boolean bonusCount = ticketMaster.checkLottoBonus(thisLotto);
            analyst.addLottoResult(winningCount,bonusCount);
        }
        System.out.println(outputMaker.printResult(analyst.revenueLotto()));
    }
}
