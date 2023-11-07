package lotto.domain;

public class Result {
    private Integer first;
    private Integer second;
    private Integer third;
    private Integer fourth;
    private Integer fifth;
    private Integer totalReward;

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
}
