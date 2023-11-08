package lotto.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.EnumMap;
import java.util.stream.Collectors;

public enum LottoWinnerTable {
    FIFTH(3, false, "5,000", "3개 일치"),
    FORTH(4, false, "50,000", "4개 일치"),
    THRID(5, false, "1,500,000", "5개 일치"),
    SECOND(6, true, "30,000,000", "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, "2,000,000,000", "6개 일치"),
    DEFAULT(0, false, "0", "2개 이하 일치");

    private int grade;
    private boolean isBonusRequired;
    private String winningMoney;
    private String winningCondition;

    private LottoWinnerTable(int grade, boolean isBonusRequired, String winningMoney, String winningCondition) {
        this.grade = grade;
        this.isBonusRequired = isBonusRequired;
        this.winningMoney = winningMoney;
        this.winningCondition = winningCondition;
    }

    public BigDecimal getWinningMoney() {
        return new BigDecimal(winningMoney.replace(",", ""));
    }

    public String getWinningStringMoney() {
        return winningMoney;
    }

    public String getWinningCondition(){
        return winningCondition;
    }

    public static LottoWinnerTable findByGrade(int grade, boolean bonusRequired) {
        return Arrays.stream(LottoWinnerTable.values())
                .filter(lotto -> lotto.grade == grade && lotto.isBonusRequired == bonusRequired)
                .findFirst()
                .orElse(DEFAULT);
    }

    public static EnumMap<LottoWinnerTable, Integer> generateEnumMap() {
        return Stream.of(LottoWinnerTable.values())
                .filter(lotto -> lotto != LottoWinnerTable.DEFAULT)
                .collect(Collectors.toMap(
                        lotto -> lotto,
                        lotto -> 0,
                        (existing, replacement) -> existing,
                        () -> new EnumMap<>(LottoWinnerTable.class)));
    }
}
