package lotto;

public enum LottoGrade {
    FIRST(1,2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4,50000),
    FIFTH(5, 5000);

    private final int grade;
    private final int price;
    LottoGrade(int grade, int price) {
        this.grade = grade;
        this.price = price;
    }

    int getGrade(){
        return this.grade;
    }

    int getPrice(){
        return this.price;
    }
}
