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
import validator.LottoValidator;
import view.InputView;
import view.OutputView;

public class LottoController {
    private Money money;
    private BonusNumber bonusNumber;
    private Lotto winningNumbers;
    private Lottos lottos;
    private HashMap<Rank, Integer> rankCountsMap;
    private RateOfReturn rateOfReturn;


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
        // 1.로또 구입 금액 입력
        inputLottoMoney();

        // 2. 로또 개수 출력
        OutputView.LottoTicketCount(money.getLottoCount());

        // 3. 로또 생성
        makeLottoLists(money.getLottoCount());

        // 4. 로또 당첨 번호 및 보너스 번호 입력, 수익률 계산
        runLottoGame();

        // 5. 결과 출력
        result();
    }

    private void inputLottoMoney() {
        while (true) {
            try {
                money = new Money(InputView.money());
                return;
            } catch (NumberFormatException error) {
                OutputView.errorMessage(error);
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

    private void runLottoGame() {
        getWinningNumbersAndBonusNumber();
        calculateRankCount();
        calculateRateOfReturn();
    }

    private void result() {
        OutputView.resultStart();
        OutputView.printStatistics(rankCountsMap);
        OutputView.printRateOfReturn(rateOfReturn.getRate());
    }


    private List<Integer> chooseRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), LOTTO_SIZE.getNumber());
    }

    private void getWinningNumbersAndBonusNumber() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputWinningNumbers() {
        while (true) {
            try {
                String numbers = InputView.winningNumbers();
                winningNumbers = new Lotto(LottoValidator.isNumeric(numbers));
                return;
            } catch (NumberFormatException error) {
                OutputView.errorMessage(error);
            } catch (IllegalArgumentException error) {
                OutputView.errorMessage(error);
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                bonusNumber = new BonusNumber(winningNumbers, InputView.bonusNumber());
                System.out.println();
                return;
            } catch (NumberFormatException error) {
                OutputView.errorMessage(error);
            } catch (IllegalArgumentException error) {
                OutputView.errorMessage(error);
            }
        }
    }

    private void calculateRankCount() {
        for (Lotto lotto : lottos.getLottoLists()) {
            Rank rank = lotto.getRank(winningNumbers.getNumbers(), bonusNumber.getBonusNumber());

            int currentCount = rankCountsMap.getOrDefault(rank, 0);
            rankCountsMap.put(rank, currentCount + 1);
        }
    }

    private void calculateRateOfReturn() {
        long totalIncome = getTotalIncome(rankCountsMap);
        rateOfReturn = new RateOfReturn(totalIncome, money.getMoney());
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
