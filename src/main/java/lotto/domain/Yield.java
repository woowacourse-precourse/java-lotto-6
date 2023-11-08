package lotto.domain;

import java.util.List;

public class Yield {
    private final List<Grade> grades;
    private final int totalInvestment;

    public Yield(List<Grade> grades, int totalInvestment) {
        this.grades = grades;
        this.totalInvestment = totalInvestment;
    }

}
