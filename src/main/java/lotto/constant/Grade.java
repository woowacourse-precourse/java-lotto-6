package lotto.constant;

public enum Grade {

    FIRST_GRADE(1, 2000000000),
    SECCOND_GRADE(2, 30000000),
    THIRD_GRADE(3, 1500000),
    FORTH_GRADE(4, 50000),
    FIFTH_GRADE(5, 5000),
    NONE (0, 0);

    int grade, price;

    Grade(int grade, int price) {
        this.grade = grade;
        this.price = price;
    };

    public int getGrade() {
        return grade;
    }

    public int getPrice() {
        return price;
    }
}
