package constValue;

public enum LottoPrize {
    FIRST_PRIZE(1, 2000000000),
    SECOND_PRIZE(2, 30000000),
    THIRD_PRIZE(3, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(5, 5000);

    final private int grade;
    final private int value;


    public int getValue() {
        return value;
    }

    public int getGrade() {
        return grade;
    }

    private LottoPrize(int grade, int value) {
        this.grade = grade;
        this.value = value;
    }
}
