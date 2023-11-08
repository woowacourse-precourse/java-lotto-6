package lotto.service;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoGame;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.Percent;
import lotto.domain.entity.Purchase;
import lotto.domain.entity.Ranking;
import lotto.domain.entity.Rankings;
import lotto.domain.entity.ThousandUnitMoney;
import lotto.domain.entity.WinningResult;
import lotto.domain.entity.WinningTicket;
import lotto.repository.Repository;

public class LottoGameServiceImpl implements LottoGameService {


    private final Repository lottoGameRepository;

    public LottoGameServiceImpl(Repository lottoGameRepository) {
        this.lottoGameRepository = lottoGameRepository;
    }


    @Override
    public WinningResult calcWinningResult(Purchase purchase, WinningTicket winningTicket) {

        ThousandUnitMoney totalPrice = ThousandUnitMoney.createEmpty();
        Rankings rankings = Rankings.create();

        Lotto winningNumbers = winningTicket.getWinningNumbers();
        LottoNumber bonusNumber =  winningTicket.getBonusNumber();

        for (Lotto lotto : purchase.getLottosByLottoList()) {
            Ranking ranking = Ranking.calcWinningMoney(
                    lotto.calcSameCount(winningNumbers),
                    lotto.isContaining(bonusNumber));

            rankings.addRankings(ranking);
            totalPrice = ThousandUnitMoney.create(totalPrice.plus(ranking.getPrizeAmount()));
        }


        return WinningResult.create(
                totalPrice,
                Percent.create(totalPrice.divide(purchase.getPurchaseAmount())),
                rankings);
    }

    @Override
    public Long saveLottoGame(LottoGame lottoGame) {
        return lottoGameRepository.save(lottoGame);
    }
}
