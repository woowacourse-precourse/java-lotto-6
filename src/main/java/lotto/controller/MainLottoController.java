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
        //랜덤 로또 번호(금액 입력받기) + 사용자 로또 번호(6자리+보너스 입력받기)
        Money money = inPutMoney();
        RandomLotto randomLotto = makeRandomLotto(money);
        sendRandomLottoDataToView(randomLotto.getRandomLottoNumbers());
        UserLotto userLotto = makeUserLotto();
        //로또 결과 데이터 업데이트
        LottoResultManager lottoResultManager = updateLottoResult(randomLotto, userLotto);
        //결과 출력
        sendResultRankingToView(lottoResultManager);
        sendEarningRateToView(lottoResultManager, money);
    }

    //region 램덤 로또 번호
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
        RandomLottoMachine randomLottoMachine =
                new RandomLottoMachine(purchasedLottoCount);
        try {
            return new RandomLotto(randomLottoMachine.getRandomLottoList());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(Output.ERROR_RANDOM_MACHINE);
            throw new IllegalArgumentException();
        }
    }

    private void sendRandomLottoDataToView(List<Lotto> lottos) {
        Output.printPurchasedLottoCount(lottos.size());
        for (Lotto lotto : lottos) {
            Output.printPurchasedLottoList(lotto.getNumbers());
        }
    }
    //endregion

    //region 사용자 로또 번호
    private UserLotto makeUserLotto() { //6자리_보너스 로또 번호
        Lotto mainNumber = inputMainLottoNumber();
        BonusLotto bonusNumber = inputBonusLottoNumber();
        try {
            return new UserLotto(mainNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return makeUserLotto();
        }
    }

    private Lotto inputMainLottoNumber() { //6자리 로또 번호
        try {
            return new Lotto(input.getMainLottoNumber());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputMainLottoNumber();
        }
    }

    private BonusLotto inputBonusLottoNumber() { //보너스 로또 번호
        try {
            return new BonusLotto(input.getBonusNumber());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputBonusLottoNumber();
        }
    }
    //endregion

    private LottoResultManager updateLottoResult(RandomLotto randomLotto, UserLotto userLotto) {
        LottoNumberMatcher lottoNumberMatcher =
                new LottoNumberMatcher(randomLotto, userLotto);
        List<Rank> matchedRankings = lottoNumberMatcher.getMatchedLottoRank();
        return new LottoResultManager(matchedRankings);
    }

    private void sendEarningRateToView(LottoResultManager lottoResultManager, Money money) {
        int totalPrize = lottoResultManager.getTotalPrize();
        double earningRate = money.getEarningRate(totalPrize);

        Output.printEarningRate(earningRate);
    }

    private void sendResultRankingToView(LottoResultManager lottoResultManager) {
        Output.printWinningDivider();
        Map<Rank, Integer> resultRanking = lottoResultManager.getLottoResult();
        List<Map.Entry<Rank, Integer>> reversedResultRanking = reverseRankOrder(resultRanking);

        for (Map.Entry<Rank, Integer> ranking : reversedResultRanking) {
            int matchCount = ranking.getKey().getMatchCount();
            int prizeMoney = ranking.getKey().getPrizeMoney();
            int matchedResult = ranking.getValue();

            Output.printResultRanking(matchCount, prizeMoney, matchedResult);
        }
    }

    private List<Map.Entry<Rank, Integer>> reverseRankOrder(Map<Rank, Integer> resultRanking) {
        List<Map.Entry<Rank, Integer>> sortedResultRanking = new ArrayList<>(resultRanking.entrySet());
        sortedResultRanking.sort((e1, e2)
                -> e2.getKey().ordinal() - e1.getKey().ordinal());

        return sortedResultRanking;
    }

}
