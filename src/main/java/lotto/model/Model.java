package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Model {
    private final List<Lotto> listOfBuyLotto;
    private Lotto lotto;
    private Map<Money, Integer> winningScore;
    private int bonusNumber;
    private int ticketCount;

    public Model() {
        this.listOfBuyLotto = new ArrayList<>();
        this.winningScore = Arrays.stream(Money.values()).collect(Collectors.toMap(score -> score, value -> 0));
    }

    public void storeBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void storeTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void storeLottoTicket(int lottoCount){
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Integer::compareTo);
            listOfBuyLotto.add(new Lotto(numbers));
        }
    }

    public void storeLotto(List<Integer> numbers){
        this.lotto = new Lotto(numbers);
    }

    public List<Lotto> getListOfBuyLotto() {
        return listOfBuyLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Map<Money, Integer> getWinningScore() {
        return winningScore;
    }

    public Lotto getLotto() {
        return lotto;
    }
}
