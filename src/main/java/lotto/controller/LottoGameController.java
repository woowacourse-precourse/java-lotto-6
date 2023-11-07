package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.StringTokenizer;
import lotto.model.Lotties;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private static final int PRICE_PER_LOTTO = 1000;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        int money = inputView.getPrice();

        Lotties purchasedLotties = new Lotties(buyLotties(money));
        outputView.printPurchasedLotties(purchasedLotties.getLotties());

        String winningNumbers = inputView.getWinningNumbers();
        Lotto winningLotto = validateLottoNumbers(winningNumbers);
        int bonusNumber = inputView.getBonusNumber();
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }

        EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        double result = 0L;
        for (int i = 0; i < purchasedLotties.size(); i++) {
            Lotto lotto = purchasedLotties.get(i);
            Rank rank = lotto.determineRank(winningLotto, bonusNumber);
            if (rank != null) {
                int count = rankCounts.getOrDefault(rank,0);
                rankCounts.put(rank, count+1);
            }
        }
        outputView.printWinningStatistics(rankCounts);

        for (Rank rank : Rank.values()) {
            int winning = rank.getPrize();
            int matchLottoCount = rankCounts.getOrDefault(rank,0);
            result += matchLottoCount * winning;
        }

        outputView.printProfitability(result, money);
    }

    private List<Lotto> buyLotties(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lotties.add(new Lotto(numbers));
        }
        return lotties;
    }

    private Lotto validateLottoNumbers(String winningNumbers) {
        StringTokenizer stringTokenizer = new StringTokenizer(winningNumbers,",");

        //그냥 list로 만들어서 lotto를 생성하는데, 이게 실패하면 그냥 exception 던지면 됨
        try {
            List<Integer> numbers = new ArrayList<>();
            while (stringTokenizer.hasMoreTokens()) {
                numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            return new Lotto(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }
}
