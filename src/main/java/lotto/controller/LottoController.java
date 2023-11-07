package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.*;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Constant.MINIMUM_SAME_NUMBER;
import static lotto.domain.Constant.MONEY_UNIT;

public class LottoController {
    private final InputCoin inputCoin;
    private final InputLottoNumber inputLottoNumber;
    private final InputBonusLottoNumber inputBonusLottoNumber;
    private final OutputResultState outputResultState;
    private final List<Lotto> lottos;
    private WonLotto wonLotto;

    public LottoController() {
        this.inputCoin = new InputCoin();
        this.inputLottoNumber = new InputLottoNumber();
        this.inputBonusLottoNumber = new InputBonusLottoNumber();
        this.outputResultState = new OutputResultState();
        this.lottos = new ArrayList<>();
    }

    public void startLottoRoulette() {
        purchaseLotto();
        makeWonNumber();
        checkWinningLotto();
    }

    public void purchaseLotto() {
        int money = inputCoin.insertCoin();
        int lottoCount = money / 1000;
        makeUserLottos(lottoCount);
        outputResultState.printLottoCount(lottoCount, lottos);
    }

    public void makeUserLottos(int lottoPaperCount) {
        for (int i = 0; i < lottoPaperCount; i++) {
            List<Integer> randomLottoNumbers = makeRandomLottoNumbers();
            Lotto newLotto = new Lotto(randomLottoNumbers);
            lottos.add(newLotto);
        }
    }

    private List<Integer> makeRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange
                (Constant.MIN_RANGE,
                        Constant.MAX_RANGE,
                        Constant.LOTTO_NUMBER_COUNT);
        return sortLottoNumbers(randomNumbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void makeWonNumber() {
        List<Integer> wonLottoNumbers = inputLottoNumber.getValue();
        int bonusNumber = inputBonusLottoNumber.buyBonusLotto();
        wonLotto = new WonLotto(wonLottoNumbers, bonusNumber);
    }

    public void checkWinningLotto() {
        Map<Rank, Integer> rankResult = initializeRankResult();
        for (Lotto userLotto : lottos) {
            int sameNumberCount = wonLotto.countSameNumber(userLotto);
            if (isWinningLotto(sameNumberCount)) {
                Rank rank = wonLotto.calculateRank(userLotto);
                rankResult.put(rank, rankResult.get(rank) + 1);
            }
        }
        double profitPercentage = calculateProfitPercentage(rankResult);
        outputResultState.printWonStatistic(rankResult, profitPercentage);
    }

    public Map<Rank, Integer> initializeRankResult() {
        Map<Rank, Integer> rankResult = new HashMap<>();
        for (Rank rank: Rank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }

    public boolean isWinningLotto(int sameNumberCount) {
        if (sameNumberCount >= MINIMUM_SAME_NUMBER) {
            return true;
        }
        return false;
    }

    public double calculateProfitPercentage(Map<Rank, Integer> rankResult) {
        int purchaseAmount = lottos.size() * MONEY_UNIT;
        int profit = 0;
        for (Rank rank : rankResult.keySet()) {
            int rankingCount = rankResult.get(rank);
            int prizeMoney = rank.getReward();
            profit += (rankingCount * prizeMoney);
        }
        double profitPercentage = (double) profit / purchaseAmount;
        return profitPercentage;
    }
}

