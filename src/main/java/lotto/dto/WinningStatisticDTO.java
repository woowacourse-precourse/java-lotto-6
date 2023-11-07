package lotto.dto;

public class WinningStatisticDTO {
    private final Integer matched3;
    private final Integer matched4;
    private final Integer matched5;
    private final Integer matched5AndBonusNumber;
    private final Integer matched6;

    public WinningStatisticDTO(Integer matched3, Integer matched4, Integer matched5, Integer matched5AndBonusNumber,
                                Integer matched6) {
        this.matched3 = matched3;
        this.matched4 = matched4;
        this.matched5 = matched5;
        this.matched5AndBonusNumber = matched5AndBonusNumber;
        this.matched6 = matched6;
    }

    public Integer getMatched3() {
        return matched3;
    }

    public Integer getMatched4() {
        return matched4;
    }

    public Integer getMatched5() {
        return matched5;
    }

    public Integer getMatched5AndBonusNumber() {
        return matched5AndBonusNumber;
    }

    public Integer getMatched6() {
        return matched6;
    }
}
