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
    private boolean isvalid;

    LottoController() {
        this.ticketMaster = new TicketMaster();
        this.inputMaker = new InputMaker();
        this.outputMaker = new OutputMaker();
        this.isvalid = false;
    }
    public void run() {
        insertCoin();
        buyLotto();
        setWinner();
        setBonus();
        resultLotto();
    }

    public void insertCoin() {
        System.out.println("구입금액을 입력해 주세요.");
        isvalid = false;
        while (!isvalid) {
            try {
                String userInput = Console.readLine();
                int coin = inputMaker.inputNum(userInput);
                inputMaker.inputCoinValidate(coin);
                isvalid = true;
                this.cs = new Customer(coin);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void buyLotto() {
        int lottoSize = cs.getWallet();
        System.out.println(lottoSize / 1000 + "개를 구매했습니다.");
        while (cs.getWallet() != 0) {
            Lotto newLotto = ticketMaster.makeTicket();
            System.out.println(outputMaker.printLotto(newLotto));
            cs.pay(LottoRole.LOTTO_PRICE.getNumber());
            cs.addCustomerLotto(newLotto);
        }
    }

    public void setWinner() {
        System.out.println("당첨 번호를 입력해 주세요.");
        isvalid = false;
        while (!isvalid) {
            try {
                String userInput = Console.readLine();
                Lotto winner = new Lotto(inputMaker.inputWinningNumber(userInput));
                ticketMaster.setWinningNum(winner);
                isvalid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        isvalid = false;
        while (!isvalid) {
            try {
                String userInput = Console.readLine();
                int bonusNum = inputMaker.inputNum(userInput);
                inputMaker.lottoNumRangeValidate(bonusNum);
                isvalid = true;
                ticketMaster.setBonusNum(bonusNum);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                Console.close();
            }
        }
    }

    public void resultLotto() {
        int ticketSize = cs.getHasTicket();
        this.analyst = new Analyst(ticketSize);
        for (int i = 0; i < ticketSize; i++) {
            Lotto thisLotto = cs.getCustomerLotto(i);
            int winningCount = ticketMaster.checkLotto(thisLotto);
            boolean bonusCount = ticketMaster.checkLottoBonus(thisLotto);
            analyst.addLottoResult(winningCount, bonusCount);
        }
        System.out.println(outputMaker.printResult(analyst.revenueLotto()));
    }
}
