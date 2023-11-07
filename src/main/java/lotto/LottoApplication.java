package lotto;

import lotto.entity.*;
import view.Input;
import view.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoApplication {
    void execute() {
        try {
            Buyer buyer = new Buyer(getReceivedAmount(), new Ticket(getPickedNumbers(), getBonusNumber()));
            List<Lotto> drawnLottos = drawLottos(buyer);
            List<Result> results = compareTicketAndLottos(buyer.getTicket(), drawnLottos);
            int[] rankCounter = getRankCounter(results);
            calculateWinningProfit(buyer.getReceivedAmount(), calculateTotalWinningAmount(rankCounter));
        } catch (IllegalArgumentException iae) {
            Output.printErrorMessage(iae.getMessage());
        }
    }

    private List<Lotto> drawLottos(Buyer buyer) {
        List<Lotto> drawnLottos = new ArrayList<>();
        final int NUMBER_OF_LOTTO_TO_DRAW = getNumberOfLotto(buyer.getReceivedAmount());

        for (int i = 0; i < NUMBER_OF_LOTTO_TO_DRAW; i++) {
            drawnLottos.add(drawLotto());
        }

        Output.printCreatedLottos(drawnLottos);

        return drawnLottos;
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
        if ((receivedAmount <= 0) && !(receivedAmount % Lotto.PRICE == 0)) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위입니다.");
        }
    }

    private Lotto getPickedNumbers() {
        try {
            List<Integer> pickedNumbers = Arrays.stream(
                    Input.readPickedNumbers()
                            .trim()
                            .split(","))
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
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, Lotto.NUMBERS_COUNTER));
    }

    private int getNumberOfLotto(int receivedAmount) {
        return receivedAmount / Lotto.PRICE;
    }

    private List<Result> compareTicketAndLottos(Ticket ticket, List<Lotto> lottos) {
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(new Result(ticket, lotto));
        }

        return results;
    }

    private int[] getRankCounter(List<Result> results) {
        int[] rankCounter = new int[6]; // index 0은 사용 안 함

        for (Result result : results) {
            rankCounter[result.getRank().getNumber()]++;
        }

        Output.printWinningStatistic(rankCounter);

        return rankCounter;
    }

    private long calculateTotalWinningAmount(int[] rankingCounter) {
        long totalWinningAmount = 0L;

        for (int i = 1; i < rankingCounter.length; i++) {
            totalWinningAmount += (long) rankingCounter[i] * Rank.of(i).getPrizeAmount();
        }

        return totalWinningAmount;
    }

    private void calculateWinningProfit(int receivedAmount, long totalWinningAmount) {
        double totalProfit = Math.round(totalWinningAmount / (double) receivedAmount * 1000.0) / 10.0;

        Output.printTotalProfit(String.valueOf(totalProfit));
    }

}
