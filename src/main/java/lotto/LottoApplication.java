package lotto;

import View.Input;
import View.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoApplication {
    private static int LOTTO_PRICE = 1000;
    private int[] matchingNumbersCounter;
    private boolean bonusMatch;
//    private static final BigDecimal[] WINNING_AMOUNT_BY_RANKING = {BigDecimal.valueOf(0), BigDecimal.valueOf(2000000000), BigDecimal.valueOf(30000000), BigDecimal.valueOf(1500000), BigDecimal.valueOf(50000), BigDecimal.valueOf(5000)};
    private static final long[] WINNING_AMOUNT_BY_RANKING = {0L, 2000000000L, 30000000L, 1500000L, 50000L, 5000L};

    void execute() {
        try {
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

            double totalProfit = calculateWinningProfit(receivedAmount, calculateTotalWinningAmount(rankingCounter));
            Output.printTotalProfit(String.valueOf(totalProfit));
        } catch (IllegalArgumentException iae) {
            Output.printErrorMessage(iae.getMessage());
        }

    }

    private int getReceivedAmount() {
        int receivedAmount;

        try {
            receivedAmount = Integer.parseInt(Input.readReceivedAmount().trim());
            validateReceivedAmount(receivedAmount);
        } catch (NumberFormatException nfe) { // 정수값 입력하지 않았을 경우
            throw new IllegalArgumentException("구입 금액은 1,000원 단위입니다.");
        }

        return receivedAmount;
    }

    private void validateReceivedAmount(int receivedAmount) {
        if ((receivedAmount <= 0) && !(receivedAmount % LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위입니다.");
        }
    }

    private Lotto getPickedNumbers() {
        try {
            List<Integer> pickedNumbers = Arrays.stream(Input.readPickedNumbers().trim().split(","))
                    .map(Integer::valueOf)
                    .toList(); // String[]을 List<Integer>로 변환 

            return new Lotto(pickedNumbers);
        } catch (NumberFormatException nfe) { // pickedNumbers 중 정수값이 없을 경우
            throw new IllegalArgumentException("1부터 45까지의 정수 값만 입력할 수 있습니다.");
        }

    }

    private Bonus getBonusNumber() {
        try {
            return new Bonus(Integer.parseInt(Input.readBonusNumber()));
        } catch (NumberFormatException nfe) { // 정수값 입력하지 않았을 경우
            throw new IllegalArgumentException("1부터 45까지의 정수 값만 입력할 수 있습니다.");
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

        for (Result result : results) {
            rankingCounter[result.getRanking()]++;
        }

        return rankingCounter;
    }

    private long calculateTotalWinningAmount(int[] rankingCounter) {
        long totalWinningAmount = 0L;

        for (int i = 1; i < rankingCounter.length; i++) {
            totalWinningAmount += (long) rankingCounter[i] * WINNING_AMOUNT_BY_RANKING[i];
        }

        return totalWinningAmount;
    }

    private double calculateWinningProfit(int receivedAmount, long totalWinningAmount) {
        double percent = 0.0;
        percent = Math.round(totalWinningAmount / (double) receivedAmount * 1000.0) / 10.0;
        return percent;
    }

//    private BigDecimal calculateTotalWinningAmount(int[] rankingCounter) {
//        BigDecimal totalWinningAmount = BigDecimal.ZERO;
//
//        for (int i = 1; i < rankingCounter.length; i++) {
//            totalWinningAmount = totalWinningAmount.add(BigDecimal.valueOf(rankingCounter[i]).multiply(WINNING_AMOUNT_BY_RANKING[i]));
//        }
//
//        return totalWinningAmount;
//    }
//
//    private BigDecimal calculateWinningProfit(BigDecimal receivedAmount, BigDecimal totalWinningAmount) {
//        BigDecimal percent = new BigDecimal(0);
//        percent = totalWinningAmount.divide(receivedAmount, 3, RoundingMode.HALF_UP);
//        percent = percent.multiply(BigDecimal.valueOf(100), new MathContext(3, RoundingMode.HALF_UP));
//        return percent;
//    }
}
