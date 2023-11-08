package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private InputUser inputUser;
    private OutputUser outputUser;
    private List<Lotto> numberTickets;
    private WinningLotto winningLotto;
    private Integer lottoMoney;
    private Integer totalLottoCount;

    public Game(){
        this.inputUser = new InputUser();
        this.outputUser = new OutputUser();
        this.numberTickets = new ArrayList<>();
    }
    public void play(){
        this.lottoMoney = inputUser.inputLottoMoney();
        makeNumberTicket(lottoMoney);
        outputUser.outputBuyLotto(this.totalLottoCount);
        outputUser.outputBuyLottoNumbers(this.numberTickets);

        List<Integer> winningNumbers = inputUser.inputWinningNumber();
        Integer bonusNumber = inputUser.inputBonusNumber();
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        resultLottoGame(this.numberTickets, this.winningLotto);
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
    private void resultLottoGame(List<Lotto> numberTickets, WinningLotto winningLotto){
        for (Lotto lotto : numberTickets){
            System.out.println(calculateLottoGame(lotto, winningLotto.getLotto()));
        }
    }
    private int calculateLottoGame(Lotto lotto, Lotto winningLotto){
        List<Integer> resultLotto = new ArrayList<>(lotto.getNumbers());
        resultLotto.retainAll(winningLotto.getNumbers());
        return resultLotto.size();
    }
}
