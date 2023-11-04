package lotto.model.judge;

import lotto.model.Lotto;
import java.util.List;
import java.util.stream.Stream;

public class GoalNumberJudge implements LottoJudge {

    private static final String NUMBER_SPLITTER = ",";

    private final List<Integer> goalNumbers;

    private GoalNumberJudge(final List<Integer> goalNumbers) {
        this.goalNumbers = goalNumbers;
    }

    public static GoalNumberJudge from(final String goalNumbersInput) {
        String[] splitNumbers = goalNumbersInput.split(NUMBER_SPLITTER);
        List<Integer> goalNumbers = Stream.of(splitNumbers)
                .map(GoalNumberJudge::convertToNumber)
                .toList();

        return new GoalNumberJudge(goalNumbers);
    }

    private static int convertToNumber(final String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Lotto> collectLottoWithMatchSize(final List<Lotto> lottos, final int matchSize) {
        return lottos.stream()
                .filter(lotto -> lotto.isContainsNumbersWithSize(goalNumbers, matchSize))
                .toList();
    }
}
