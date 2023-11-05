package lotto.service;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class GameService {
    private final LottoRepository lottoRepository = new LottoRepository();

    private final LottoService lottoService = new LottoService();

    private User user;
    private  HashMap<Rank, Integer> lottoResult = new HashMap<>();

    private HashMap<Rank, Integer> userResult = getLottoResult();


    private static final int ZERO = 0;
    private static final int ONE = 1;


    //전체 로또 조회
    public ArrayList<Lotto> getLotteries(){
        return lottoRepository.getLotteries();
    }

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }





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
    public void initLottoResult() {
        lottoResult.put(Rank.FIRST, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.NO_RANK_TWO, 0);
        lottoResult.put(Rank.NO_RANK_ONE, 0);
        lottoResult.put(Rank.NO_RANK_ZERO, 0);
    }

}
