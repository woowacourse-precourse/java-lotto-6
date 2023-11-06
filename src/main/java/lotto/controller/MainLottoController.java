package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainLottoController {
    Input input = new Input();

    public void startLotto() {
        Money money = inPutMoney();
        RandomLotto randomLotto = makeRandomLotto(money);
        sendRandomLottoDataToView(randomLotto.getRandomLottoNumbers());
        UserLotto userLotto = makeUserLotto();

        List<Rank> matchedRankings = getLottoRanking(randomLotto, userLotto);
        LottoResultManager lottoResultManager = updateLottoResult(matchedRankings);

        sendResultLottoDataToView(lottoResultManager, money);
    }

    private void sendResultLottoDataToView(LottoResultManager lottoResultManager, Money money) {
        int totalPrize = lottoResultManager.getTotalPrize();
        double earningRate = money.getEarningRate(totalPrize);

        Map<Rank, Integer> resultRanking = lottoResultManager.getLottoResult();
        List<Map.Entry<Rank, Integer>> sortedResultRanking = new ArrayList<>(resultRanking.entrySet());
        sortedResultRanking.sort((e1, e2)
                -> e2.getKey().ordinal() - e1.getKey().ordinal());

        sendResultRankingToView(sortedResultRanking);
        sendEarningRateToView(earningRate);
    }

    private void sendEarningRateToView(double earningRate) {
        Output.printResultRanking(earningRate);

    }

    private void sendResultRankingToView(List<Map.Entry<Rank, Integer>> rankings) {
        for (Map.Entry<Rank, Integer> ranking : rankings) {
            int  matchCount = ranking.getKey().getMatchCount();
            int prizeMoney = ranking.getKey().getPrizeMoney();
            int matchedResult = ranking.getValue();

            Output.printEarningRate(matchCount,prizeMoney,matchedResult);
        }
    }


    private LottoResultManager updateLottoResult(List<Rank> resultRanks) {
        return new LottoResultManager(resultRanks);
    }

    //region 램덤로또
    private Money inPutMoney() {
        try {
            return new Money(input.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inPutMoney();
        }
    }

    private RandomLotto makeRandomLotto(Money money) {
        int purchasedLottoCount = money.getPurchaseAmount();
        RandomLottoMachine randomLottoMachine = //얘가 정적이 되어야하네...
                new RandomLottoMachine(purchasedLottoCount);
        try {
            return new RandomLotto(randomLottoMachine.getRandomLottoList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[Error] 잘못된 랜덤 생성입니다.");
        }
    }

    private void sendRandomLottoDataToView(List<Lotto> lottos) { //RandomLotto lottos?
        Output.printPurchasedLottoCount(lottos.size());
        for (Lotto lotto : lottos) {
            Output.printPurchasedLottoList(lotto.getNumbers());
        }
    }
    //endregion

    //region 로또번호 입력받기
    private UserLotto makeUserLotto() {
        Lotto mainNumber = inputMainLottoNumber();
        BonusLotto bonusNumber = inputBonusLottoNumber();
        try {
            return new UserLotto(mainNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return makeUserLotto();
        }
    }

    private Lotto inputMainLottoNumber() {
        try {
            return new Lotto(input.getMainLottoNumber());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputMainLottoNumber();
        }
    }

    private BonusLotto inputBonusLottoNumber() {
        try {
            return new BonusLotto(input.getBonusNumber());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputBonusLottoNumber();
        }
    }
    //endregion

    private List<Rank> getLottoRanking(RandomLotto randomLotto, UserLotto userLotto) {
        LottoNumberMatcher lottoNumberMatcher =
                new LottoNumberMatcher(randomLotto, userLotto);
        return lottoNumberMatcher.getMatchedLottoRank();
    }


}
