package lotto.ServiceImp;

import lotto.Constant.RecordConstant;
import lotto.Exception.OutOfRankingException;
import lotto.Lottery;
import lotto.Lotto;
import lotto.Service.LottoService;

import java.util.*;

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
    public List<Lotto> getLotto()
    {
        return lottery.getLotto();
    }

    @Override
    public List<Integer> getResultRecordOfLotto(Lotto winningLotteryNumber, int bonusNumber)
    {
        List<Lotto> lotto = getLotto();
        List<Integer> resultRecord = new ArrayList<>(Collections.nCopies(RecordConstant.NUMBER_OF_RANKING, 0));
        for(Lotto lo : lotto)
        {
            try
            {
                resultRecord.add(getResultRecordOfEachLotto(lo, winningLotteryNumber, bonusNumber), 1);
            }
            catch (OutOfRankingException e)
            {
                // continue;
            }
        }

        return resultRecord;
    }

    private int getResultRecordOfEachLotto(Lotto lotto, Lotto winningLotteryNumber, int bonusNumber)
    {
        int overlappedSize = lotto.compare(winningLotteryNumber);

        if (overlappedSize == RecordConstant.NameOfRanking.SIX_MATCH.getMatchNumber())
        {
            return RecordConstant.NameOfRanking.SIX_MATCH.getIndex();
        }

        if (overlappedSize == RecordConstant.NameOfRanking.FIVE_MATCH.getMatchNumber())
        {
            if (lotto.contains(bonusNumber))
            {
                return RecordConstant.NameOfRanking.FIVE_BONUS_MATCH.getIndex();
            }
            return RecordConstant.NameOfRanking.FIVE_MATCH.getIndex();
        }

        if (overlappedSize == RecordConstant.NameOfRanking.FOUR_MATCH.getMatchNumber())
        {
            return RecordConstant.NameOfRanking.FOUR_MATCH.getIndex();
        }

        if (overlappedSize == RecordConstant.NameOfRanking.THREE_MATCH.getMatchNumber())
        {
            return RecordConstant.NameOfRanking.THREE_MATCH.getIndex();
        }

        throw new OutOfRankingException("랭킹 안의 범위가 아닙니다");
    }
}
