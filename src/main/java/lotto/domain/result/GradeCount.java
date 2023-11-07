package lotto.domain.result;

public class GradeCount {

    private Grade grade;
    private int count;

    public GradeCount(Grade grade) {
        this.grade = grade;
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }

    public Grade getGrade() {
        return grade;
    }

    public int getCount() {
        return count;
    }
}
