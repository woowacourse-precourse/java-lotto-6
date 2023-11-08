package lotto.service;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;


import java.util.HashMap;

public class GameService {

    private final LottoService lottoService = new LottoService();

    private  HashMap<Rank, Integer> lottoResult = new HashMap<>();

    private static final int ZERO = 0;
    private static final int ONE = 1;

    public void checkUserLotteries(User user, Game game){
        HashMap<Rank, Integer> result = user.getLottoResult();
        for(Lotto lotto : user.getPurchasedLotteries()){
            Rank rank = classifyLottoRank(game,lotto);
            result.put(rank, result.getOrDefault(rank, ZERO) + ONE);
        }

    }
    private int countMatchLottoNumber(Game game, Lotto lotto){
        return lottoService.countMatchNumber(game.getWinningNumbers(), lotto.getNumbers());
    }

    private boolean isContainBonusNumber(Game game, Lotto lotto){
        return lotto.getNumbers().contains(game.getBonusNumber());
    }

    private Rank classifyLottoRank(Game game, Lotto lotto){
        int matchCount = countMatchLottoNumber(game,lotto);
        boolean matchBonusNumber = isContainBonusNumber(game,lotto);
        Rank rank = Rank.values()[matchCount];
        if(rank == Rank.THIRD && matchBonusNumber){
            return Rank.SECOND;
        }
        return rank;
    }

}
