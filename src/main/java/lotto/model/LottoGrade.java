package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoGrade {
    FIRST("6", 2_000_000_000),
    SECOND("5+", 30_000_000),
    THIRD("5", 1_500_000),
    FOURTH("4", 50_000),
    FIFTH("3", 5_000);

    private static final Map<String, String> GRADE = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(LottoGrade::getCorrect, LottoGrade::name)));

    private final String correct;
    private final int amount;

    LottoGrade(final String correct, final int amount) {
        this.correct = correct;
        this.amount = amount;
    }

    public static LottoGrade from(final String correct) {
        return LottoGrade.valueOf(GRADE.get(correct));
    }

    public String getCorrect() {
        return correct;
    }

    public int getAmount() {
        return amount;
    }
}
