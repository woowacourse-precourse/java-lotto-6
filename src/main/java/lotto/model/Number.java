package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Number {
    private List<Integer> numberList;
    private WinningGrade grade;

    public Number() {
        numberList = createNumbers();
    }

    public List<Integer> createNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public WinningGrade getGrade() {
        return grade;
    }

    public void setGrade(WinningGrade grade) {
        this.grade = grade;
    }
}
