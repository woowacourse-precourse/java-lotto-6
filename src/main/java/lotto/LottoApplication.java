package lotto;

import View.Input;
import View.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoApplication {
    private static int LOTTO_PRICE = 1000;
    private int[] matchingNumbersCounter;
    private boolean bonusMatch;
    private static final BigInteger[] WINNING_AMOUNT_BY_RANKING = {BigInteger.valueOf(0), BigInteger.valueOf(2000000000), BigInteger.valueOf(30000000), BigInteger.valueOf(1500000), BigInteger.valueOf(50000), BigInteger.valueOf(5000)};

    void execute() {
        int receivedAmount = getReceivedAmount();

        List<Lotto> createdLottos = new ArrayList<>();
        for (int i = 0; i < getNumberOfLotto(receivedAmount); i++) {
            createdLottos.add(drawLotto());
        }
        Output.printCreatedLottos(createdLottos);

        Lotto pickedNumbers = getPickedNumbers();
        Bonus bonus = getBonusNumber();

        Ticket ticket = new Ticket(pickedNumbers, bonus); // 구매자의 티켓

        matchingNumbersCounter = new int[getNumberOfLotto(receivedAmount)];
        List<Result> results = compareTicketAndLottos(ticket, createdLottos);

        int[] rankingCounter = getRankingCounter(results);
        Output.printWinningStatistic(rankingCounter);

        BigInteger totalWinningAmount = calculateWinningAmount(rankingCounter);
    }

    private int getReceivedAmount() {
        int receivedAmount;

        try {
            receivedAmount = Integer.parseInt(Input.readReceivedAmount());
            validateReceivedAmount(receivedAmount);
        } catch (NumberFormatException nfe) { // 정수값 입력하지 않았을 경우
            throw new IllegalArgumentException();
        }

        return receivedAmount;
    }

    private void validateReceivedAmount(int receivedAmount) {
        if (!(receivedAmount % LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException();
        }
    }

    private Lotto getPickedNumbers() {
        try {
            List<Integer> pickedNumbers = Arrays.stream(Input.readPickedNumbers().trim().split(","))
                    .map(Integer::valueOf)
                    .toList(); // String[]을 List<Integer>로 변환 

            return new Lotto(pickedNumbers);
        } catch (NumberFormatException nfe) { // pickedNumbers 중 정수값이 없을 경우
            throw new IllegalArgumentException();
        }

    }

    private Bonus getBonusNumber() {
        try {
            return new Bonus(Integer.parseInt(Input.readBonusNumber()));
        } catch (NumberFormatException nfe) { // 정수값 입력하지 않았을 경우
            throw new IllegalArgumentException();
        }
    }

    private Lotto drawLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, 6));
    }

    private int getNumberOfLotto(int receivedAmount) {
        return receivedAmount / LOTTO_PRICE;
    }

    private List<Result> compareTicketAndLottos(Ticket ticket, List<Lotto> lottos) {
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(new Result(ticket, lotto));
        }

        return results;
    }

    private int[] getRankingCounter(List<Result> results) {
        int[] rankingCounter = new int[6]; // index 0은 사용 안 함

        for (Result result: results) {
            rankingCounter[result.getRanking()]++;
        }

        return rankingCounter;
    }

    private BigInteger calculateWinningAmount(int[] rankingCounter) {
        BigInteger totalWinningAmount = BigInteger.ZERO;

        for (int i=1; i<rankingCounter.length; i++) {
            totalWinningAmount.add(BigInteger.valueOf(rankingCounter[i]).multiply(WINNING_AMOUNT_BY_RANKING[i]));
        }

        return totalWinningAmount;
    }
}
