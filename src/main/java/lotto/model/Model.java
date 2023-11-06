package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<List<Integer>> listOfBuyLotto;
    private int bonusNumber;

    public Model() {
        this.bonusNumber = 0;
        this.listOfBuyLotto = new ArrayList<>();
    }

    public void storeBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public void storeLottoTicket(int lottoCount){
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Integer::compareTo);
            listOfBuyLotto.add(numbers);
        }
    }

    public List<List<Integer>> getListOfBuyLotto() {
        return listOfBuyLotto;
    }
}
