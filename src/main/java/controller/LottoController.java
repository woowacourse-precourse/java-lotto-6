package controller;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Rank;
import domain.BonusNumber;
import domain.Lotto;
import domain.Lottos;
import domain.Money;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import view.InputView;
import view.OutputView;

public class LottoController {
    private Money money;
    private BonusNumber bonusNumber;

    private Lottos lottos;
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
        getLottoMoney();
        long ticketCount = OutputView.LottoTicketCount(money.getMoney());
        makeLottoLists(ticketCount);
        getWinningNumbersAndBonusNumber();
        result();
    }

    private void getLottoMoney() {
        while (true) {
            try {
                money = new Money(InputView.money());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void makeLottoLists(long ticketCount) {
        List<Lotto> lottoList = LongStream.range(0, ticketCount)
                .mapToObj(lotto -> new Lotto(chooseRandomLottoNumbers()))
                .peek(Lotto::printNumbers)
                .collect(Collectors.toList());

        lottos = new Lottos(lottoList);
        System.out.println();
    }

    private List<Integer> chooseRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void getWinningNumbersAndBonusNumber() {
        getWinningNumbers();
        getBonusNumber();
    }

    private void getWinningNumbers() {
        while (true) {
            try {
                winningNumbers = InputView.winningNumbers();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getBonusNumber() {
        while (true) {
            try {
                bonusNumber = new BonusNumber(winningNumbers, InputView.bonusNumber());
                System.out.println();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void result() {
        OutputView.resultStart();

        for (Lotto lotto : lottos.getLottoLists()) {
            Rank rank = lotto.getRank(winningNumbers.getNumbers(), bonusNumber.getBonusNumber());

            int currentCount = rankCountsMap.getOrDefault(rank, 0);
            rankCountsMap.put(rank, currentCount + 1);
        }

        OutputView.printStatistics(rankCountsMap);
        OutputView.printEarningtRatio(rankCountsMap, money.getMoney());
    }
}
