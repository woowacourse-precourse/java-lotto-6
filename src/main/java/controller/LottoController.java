package controller;

import static constant.ConstantNumber.LOTTO_SIZE;
import static constant.ConstantNumber.MAX_NUMBER;
import static constant.ConstantNumber.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Rank;
import domain.BonusNumber;
import domain.Lotto;
import domain.Lottos;
import domain.Money;
import domain.RateOfReturn;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
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
            } catch (IllegalArgumentException error) {
                OutputView.errorMessage(error);
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
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), LOTTO_SIZE.getNumber());
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
            } catch (IllegalArgumentException error) {
                OutputView.errorMessage(error);
            }
        }
    }

    private void getBonusNumber() {
        while (true) {
            try {
                bonusNumber = new BonusNumber(winningNumbers, InputView.bonusNumber());
                System.out.println();
                return;
            } catch (IllegalArgumentException error) {
                OutputView.errorMessage(error);
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
        long totalIncome = getTotalIncome(rankCountsMap);
        RateOfReturn rateOfReturn = new RateOfReturn(totalIncome, money.getMoney());
        OutputView.printRateOfReturn(rateOfReturn.getRate());
    }

    private static long getTotalIncome(HashMap<Rank, Integer> rankCountsMap) {
        long totalIncome = 0;
        for (Entry<Rank, Integer> entry : rankCountsMap.entrySet()) {
            if (entry.getValue() != 0) {
                Rank rank = entry.getKey();
                totalIncome += (long) rank.getPrize() * entry.getValue();
            }
        }
        return totalIncome;
    }
}
