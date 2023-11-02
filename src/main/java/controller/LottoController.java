package controller;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Rank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import view.InputView;
import view.OutputView;

public class LottoController {
    private int money;
    private int bonusNumber;

    private List<Lotto> lottoList = new ArrayList<>();
    private HashMap<Rank, Integer> rankCountsMap;
    private Lotto winningNumbers;


    public LottoController() {
        initRankCountsMap();
    }

    private void initRankCountsMap() {
        rankCountsMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCountsMap.put(rank, 0);
        }
    }

    public void start() {
        money = InputView.money();
        int ticketCount = OutputView.LottoTicketCount(money);
        makeLottoLists(ticketCount);
        getWinningNumbers();
        result();
    }

    private void makeLottoLists(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            lottoList.get(i).printNumbers();
        }
    }

    private void getWinningNumbers() {
        winningNumbers = InputView.winningNumbers();
        bonusNumber = InputView.bonusNumber();
    }

    private void result() {
        OutputView.resultStart();

        for (Lotto lotto : lottoList) {
            Rank rank = lotto.getRank(winningNumbers.getNumbers(), bonusNumber);

            int currentCount = rankCountsMap.getOrDefault(rank, 0);
            rankCountsMap.put(rank, currentCount + 1);
        }

        OutputView.printStatistics(rankCountsMap);
        OutputView.printProfitRatio(rankCountsMap, money);
    }
}
