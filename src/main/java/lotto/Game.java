package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private InputUser inputUser;
    private List<Lotto> numberTickets;
    private Integer lottoMoney;

    public Game(){
        this.inputUser = new InputUser();
        this.numberTickets = new ArrayList<>();
    }
    public void play(){
        this.lottoMoney = inputUser.inputLottoMoney();
        makeNumberTicket(lottoMoney);
    }
    private void makeNumberTicket(Integer lottoMoney){
        int totalLottoCount = lottoMoney/1000;
        for (int i = 0; totalLottoCount > i; i++){
            this.numberTickets.add(makeNumber());
        }
    }
    private Lotto makeNumber(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }
}
