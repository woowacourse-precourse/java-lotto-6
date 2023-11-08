package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.LottoGenerator.MIN_NUMBER_RANGE;

public enum Division {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FORTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치");


    private static final Map<Integer, String> DIVISION_TO_NAME_MAP =
            IntStream.rangeClosed(MIN_NUMBER_RANGE, values().length)
                    .boxed()
                    .collect(
                            Collectors.toMap(
                                    index -> index, index -> values()[index-1].name()
                            )
                    );
    private final int correctCount;
    private final boolean isBouns;
    private final int amount;
    private final String desc;

    Division(int correctCount, boolean isBouns, int amount, String desc) {
        this.correctCount = correctCount;
        this.isBouns = isBouns;
        this.amount = amount;
        this.desc = desc;
    }

    public static Division getEnumFromDivision(int division){
        return Division.valueOf(DIVISION_TO_NAME_MAP.get(division));
    }

    public static Division findDivisionResult(int correctCount, boolean bonusCorrect){
        for(Division division : Division.values()){
            if(division.isSame(correctCount, bonusCorrect)){
                return division;
            }
        }
        return null;
    }

    public boolean isSame(int correctCount, boolean bonusCorrect){
        return this.correctCount == correctCount && this.isBouns == bonusCorrect;
    }

    public String amountToFormatString(){
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(amount);
    }

    public int getAmount() { return amount; }

    public String getDesc() { return desc; }

    @Override
    public String toString() {
        return String.format(
                "%s (%s원)", this.desc, amountToFormatString()
        );
    }
}
