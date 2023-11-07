package lotto.domain;

public class Result {
    private final Integer first;
    private final Integer second;
    private final Integer third;
    private final Integer fourth;
    private final Integer fifth;
    private final Integer totalReward;

    public Result(Integer first, Integer second, Integer third, Integer fourth, Integer fifth, Integer totalReward){
        this.fifth = fifth;
        this.fourth = fourth;
        this.third = third;
        this.second = second;
        this.first = first;
        this.totalReward=totalReward;
    }

    public Integer[] getRankNum(){
        Integer[] arr = {fifth, fourth, third, second, first};
        return arr;
    }

    public Integer getTotalReward() {
        return totalReward;
    }
}
