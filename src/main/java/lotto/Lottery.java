package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class Lottery {
    private final int cost;
    private final int numberOfLotto;
    private final List<List<Integer>> lotto;

    public Lottery(int cost)
    {
        this.cost = cost;
        this.numberOfLotto = cost / LottoConstant.TICKET_PRICE;
        this.lotto = pickLotto(this.numberOfLotto);
    }

    public int getNumberOfLotto()
    {
        return this.numberOfLotto;
    }

    public List<List<Integer>> getLotto()
    {
        return this.lotto;
    }

    private List<List<Integer>> pickLotto(int numberOfLotto)
    {
        List<List<Integer>> pickedLotto = new ArrayList<>();
        for(int i = 0 ; i<numberOfLotto ; i++)
        {
            pickedLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return pickedLotto;
    }

}
