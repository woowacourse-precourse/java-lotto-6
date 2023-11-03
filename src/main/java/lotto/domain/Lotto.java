package lotto.domain;

import java.util.List;

public class Lotto {
    private static final Rank DEFAULT_RANK = Rank.NONE;

    private List<Integer> numbers;

    private Rank rank;

    public Lotto(List<Integer> numbers){
        this.numbers = numbers;
        this.rank = DEFAULT_RANK;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public Rank getRank(){
        return rank;
    }

    public void setRank(Rank rank){
        this.rank = rank;
    }
}
