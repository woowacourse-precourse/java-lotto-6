package lotto.domain;

public enum Grade {

    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_AND_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private Integer answer;
    private Integer price;

    Grade(Integer answer, Integer price) {
        this.answer = answer;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAnswer() {
        return answer;
    }

    public static Grade from(Integer answer, Integer bonus) {
        if (answer == FIVE_AND_BONUS.answer && bonus == 1) {
            return FIVE_AND_BONUS;
        }
        for (Grade grade : Grade.values()) {
            if (grade.answer.equals(answer) && bonus == 0) {
                return grade;
            }
        }
        return NONE;
    }
}
