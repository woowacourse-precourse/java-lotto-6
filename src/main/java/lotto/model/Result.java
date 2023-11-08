package lotto.model;

import lotto.constants.Prize;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Result {
    private final String EMPTY = "";
    private final String COUNT = "개";
    private final String EQUAL = " 일치";
    private final String BONUS = ", 보너스 볼 일치";
    private final String LEFT_PARENTHESES = " (";
    private final String RIGHT_PARENTHESES = ") ";
    private final String HYPHEN = "- ";
    private final String WON = "원";
    private final String LINEBREAK = "\n";

    private final List<Integer> equalCount;
    private Integer bonusCount;

    public Result(Integer numberCount) {
        equalCount = new ArrayList<>();
        initialEqualCount(equalCount, numberCount);
        bonusCount = 0;
    }

    private void initialEqualCount(List<Integer> equalCount, Integer numberCount) {
        for (int i = 0; i <= numberCount; i++) {
            equalCount.add(0);
        }
    }

    public void addResult(Integer count) {
        Integer value = equalCount.get(count);

        equalCount.set(count, value + 1);
    }

    public void addBonus(Integer numberCount) {
        int index = numberCount - 1;
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
            return EMPTY;
        }
        return buildLine(prize);
    }

    private String buildLine(Prize prize) {
        String line;

        line = matchMessage(prize) + payoutMessage(prize) + countMessage(prize);
        return (line + LINEBREAK);
    }

    private String matchMessage(Prize prize) {
        String result;
        Integer match = prize.getMatch();

        result = match + COUNT + EQUAL;
        if (prize == Prize.BONUS) {
            result += BONUS;
        }
        return result;
    }

    private String payoutMessage(Prize prize) {
        Integer payout = prize.getPayout();
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);

        return (LEFT_PARENTHESES + formatter.format(payout) + WON + RIGHT_PARENTHESES);
    }

    private String countMessage(Prize prize) {
        Integer match = prize.getMatch();
        Integer result = equalCount.get(match);

        if (prize == Prize.BONUS) {
            result = bonusCount;
        }
        return (HYPHEN + result + COUNT);
    }
}
