package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.service.TicketMaster;
import lotto.view.InputMaker;
import lotto.view.OutputMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    static TicketMaster ticketMaster;
    static InputMaker inputMaker;
    static OutputMaker outputMaker;
    static Customer cs;

    LottoController() {
        this.ticketMaster = new TicketMaster();
        this.inputMaker = new InputMaker();
        this.outputMaker = new OutputMaker();
    }

    public void insertCoin() {
        System.out.println("구입금액을 입력해 주세요.");
        int coin = inputMaker.inputNum(Console.readLine());
        this.cs = new Customer(coin);
    }

    public void buyLotto(){
        int buget = this.cs.getWallet();
        int ticketSize = buget/1000;
        for (int i = 0; i<ticketSize; i++) {
            Lotto newLotto = ticketMaster.makeTicket();
            System.out.println(outputMaker.printLotto(newLotto));
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
        System.out.println("당첨 통계");
        System.out.println("---");
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i<cs.getWallet()/1000; i++) {
            result.add(ticketMaster.checkLotto(cs.getCustomerLotto(i)));
        }
        for (int i = 0; i<cs.getWallet()/1000; i++) {
            System.out.println(result.get(i));
        }

    }
}
