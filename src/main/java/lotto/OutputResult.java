package lotto;

import java.util.List;

public class OutputResult {

    private final List<Result> result;
    private int countOnePlace;
    private int countTwoPlace;
    private int countThreePlace;
    private int countFourPlace;
    private int countFivePlace;

    public OutputResult(List<Result> result){
        this.result = result;
        count();
    }

    private void count(){
        countFivePlace = (int) result.stream()
                .filter(r -> r == Result.five)
                .count();

        countFourPlace = (int) result.stream()
                .filter(r -> r == Result.four)
                .count();

        countThreePlace = (int) result.stream()
                .filter(r -> r == Result.three)
                .count();

        countTwoPlace = (int) result.stream()
                .filter(r -> r == Result.two)
                .count();

        countOnePlace = (int) result.stream()
                .filter(r -> r == Result.one)
                .count();
    }

}