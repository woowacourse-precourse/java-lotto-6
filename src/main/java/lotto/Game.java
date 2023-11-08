package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private InputUser inputUser;
    private List<Lotto> numberTickets;
    private Integer lottoMoney;
    private Integer totalLottoCount;

    public Game(){
        this.inputUser = new InputUser();
        this.numberTickets = new ArrayList<>();
    }
    public void play(){
        this.lottoMoney = inputUser.inputLottoMoney();
        makeNumberTicket(lottoMoney);
        for (Lotto l : numberTickets){
            System.out.println(l.getNumbers());
        }
        String WinningNumber = inputUser.inputWinningNumber();
    }
    private void makeNumberTicket(Integer lottoMoney){
        this.totalLottoCount = lottoMoney/1000;
        for (int i = 0; totalLottoCount > i; i++){
            this.numberTickets.add(makeNumber());
        }
    }
    private Lotto makeNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortAscNumber(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private void sortAscNumber(List<Integer> numbers){
        Collections.sort(numbers);
    }

    private void makeWinningLotto(String inputWinningNumber){

    }
}
