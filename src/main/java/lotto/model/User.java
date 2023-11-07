package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.LottoCheck;
import lotto.view.ErrorMessage;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class User {

    private int money;
    private int ticketCount;
    private List<Lotto> lottos;
    private Lotto winLotto;
    private int bonusNumber;
    private LottoCheck winLottoCheck;

    public void getMoney() {
        System.out.println(InputMessage.INPUT_MONEY.getMsg());
        this.money = isMoneyInteger(Console.readLine());
    }

    public int isMoneyInteger(String input) throws IllegalArgumentException{
        try{
            return Integer.parseInt(input);
        } catch (Exception e){
            throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getMsg());
        }
    }

    /**
     * 천원단위로 나눠 떨어지지 않을 때 예외처리
     * */
    public void getTicketCount(){
        if(this.money % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.VALUE_ERROR.getMsg());
        }
        ticketCount = this.money / 1000;
    }

    public void getLottosThroughTicketCount(){
        System.out.println("\n" + ticketCount + OutputMessage.BOUGHT_OUTPUT.getMsg());
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.printNumbers();
            this.lottos.add(lotto);
        }
    }

    public void getWinLotto() {
        System.out.println("\n" + InputMessage.REQUEST_WIN_LOTTO.getMsg());
        String winLotto = Console.readLine();

        winLottoCheck = new LottoCheck();
        this.winLotto = new Lotto(winLottoCheck.winLottoErrorCheck(winLotto));
    }


    public void getBonusNumber() {
        System.out.println("\n" + InputMessage.REQUEST_BONUS_LOTTO.getMsg());
        String bonusLotto = Console.readLine();

        winLottoCheck = new LottoCheck();
        this.bonusNumber = winLottoCheck.bonusLottoErrorCheck(bonusLotto);
    }

    public void countResult() {
        for(Lotto lotto: lottos){
            compareToLotto(winLotto, lotto);
        }
    }

    private void compareToLotto(Lotto winLotto, Lotto lotto) {

    }
}
