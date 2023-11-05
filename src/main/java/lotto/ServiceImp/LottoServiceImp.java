package lotto.ServiceImp;

import lotto.Lottery;
import lotto.Service.LottoService;

import java.util.List;

public class LottoServiceImp implements LottoService {
    private Lottery lottery;

    @Override
    public void initializeLottery(int cost)
    {
        this.lottery = new Lottery(cost);
    }

    @Override
    public int getNumberOfLotto()
    {
        return lottery.getNumberOfLotto();
    }

    @Override
    public List<List<Integer>> getLotto()
    {
        return lottery.getLotto();
    }
}
