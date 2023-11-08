package lotto.model;

import lotto.constants.Constants;
import lotto.constants.Message;
import lotto.constants.Prize;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Result {
    private final List<Integer> equalCount;
    private Integer bonusCount;

    public Result() {
        equalCount = new ArrayList<>();
        initialEqualCount(equalCount);
        bonusCount = 0;
    }

    private void initialEqualCount(List<Integer> equalCount) {
        for (int i = 0; i <= Constants.NUMBER_COUNT; i++) {
            equalCount.add(0);
        }
    }

    public void addResult(Integer count) {
        Integer value = equalCount.get(count);

        equalCount.set(count, value + 1);
    }

    public void addBonus() {
        int index = Constants.NUMBER_COUNT - 1;
        Integer value = equalCount.get(index);

        equalCount.set(index, value - 1);
        bonusCount++;
    }

    public String generateResultMessage() {
        StringBuilder resultMessage = new StringBuilder();
        Prize[] prizes = Prize.values();

        for (Prize prize : prizes) {
            resultMessage.append(resultLine(prize));
        }
        return resultMessage.toString();
    }

    private String resultLine(Prize prize) {
        if (prize.getPayout() == 0) {
            return Message.EMPTY;
        }
        return buildLine(prize);
    }

    private String buildLine(Prize prize) {
        String line;

        line = matchMessage(prize) + payoutMessage(prize) + countMessage(prize);
        return (line + Message.LINEBREAK);
    }

    private String matchMessage(Prize prize) {
        String result;
        Integer match = prize.getMatch();

        result = match + Message.COUNT + Message.EQUAL;
        if (prize == Prize.BONUS) {
            result += Message.BONUS;
        }
        return result;
    }

    private String payoutMessage(Prize prize) {
        Integer payout = prize.getPayout();
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);

        return (Message.LEFT_PARENTHESES
                + formatter.format(payout)+ Message.WON
                + Message.RIGHT_PARENTHESES);
    }

    private String countMessage(Prize prize) {
        Integer count = findCount(prize);

        return (Message.HYPHEN + count + Message.COUNT);
    }

    private Integer findCount(Prize prize) {
        Integer match = prize.getMatch();
        Integer count = equalCount.get(match);

        if (prize == Prize.BONUS) {
            count = bonusCount;
        }
        return count;
    }

    public Double calculateReturnRate(Integer cost) {
        Prize[] prizes = Prize.values();
        Integer profit = calculateProfit(prizes);

        return ((profit.doubleValue() / cost) * 100);
    }

    private Integer calculateProfit(Prize[] prizes) {
        int profit = 0;

        for (Prize prize : prizes) {
            profit += countMoney(prize);
        }
        return profit;
    }

    private Integer countMoney(Prize prize) {
        Integer count = findCount(prize);

        return (prize.getPayout() * count);
    }
}
