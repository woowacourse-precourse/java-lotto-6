package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.GameData;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.verifier.LottoNumberVerifier;
import lotto.verifier.LottoPurchaseVerifier;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGameController {
    private static final int LOTTO_PRICE = 1000;
    public void play() {
        String purchaseAmout = InputView.receiveInputWinningNumberMsg();

        new LottoPurchaseVerifier(purchaseAmout);
        int purchaseCount = Integer.parseInt(purchaseAmout);
        List<Lotto> lottos = purchaseLottos(purchaseCount);
        String winningnumbers = InputView.receiveInputWinningNumberMsg();
        new LottoNumberVerifier(winningnumbers);
        Lotto winningLotto = new Lotto(parseWinningNumbers(winningnumbers));
        int bonusNumber = Integer.parseInt(InputView.receiveInputBonusNumberMsg());
        GameData gameData = new GameData(winningLotto, bonusNumber, lottos);

        calculateResults(gameData);
        printResults(gameData);
    }
    public List<Integer> parseWinningNumbers(String winningnumbers){
        return Arrays.stream(winningnumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        OutputView.printPurchaseMsg(lottoCount);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)))
                .collect(Collectors.toList());
    }


    private void calculateResults(GameData gameData) {
        // 당첨 결과를 저장할 Map 초기화
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }

        // 각 로또에 대한 당첨 결과 계산
        for (Lotto lotto : gameData.getLottos()) {
            int matchedCount = lotto.countMatchedNumbers(gameData.getWinningNumbers().getNumbers());
            boolean matchBonus = lotto.isContainedBonus(gameData.getBonusNumber());
            Rank rank = Rank.calculateRank(matchedCount, matchBonus);
            results.put(rank, results.get(rank) + 1);
        }

        // 결과를 GameData 객체에 설정
        gameData.setResults(results);
    }

    private void printResults(GameData gameData) {
        OutputView.printWinningStatistics();
        Map<Rank, Integer> results = gameData.getResults();

        // 정렬된 순서로 결과 출력
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue; // MISS 등급은 출력하지 않음
            }
            int count = results.getOrDefault(rank, 0);
            OutputView.printWinningResult(rank.getMatchCount(), rank.getPrizeMoney(), count);
        }

        double totalPrize = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        double purchaseAmount = gameData.getLottos().size() * LOTTO_PRICE;
        double profitRate = totalPrize / purchaseAmount * 100;

        OutputView.printTotalProfitRate(profitRate);
    }


}
