package lotto.model;

import lotto.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static lotto.global.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.model.LottoInfo.*;

public class Lottos {
    private final List<Lotto> lottos;
    private List<Integer> goal;
    private Integer bonus;

    public Lottos(){
        lottos = new ArrayList<>();
    }
    public void buyMultipleAllRandom(int payment){
        int count = payment / LOTTO_PRICE;
        IntStream.range(0,count)
                .mapToObj(lotto->new Lotto(RandomGenerator.getAutoNumbers(NUMBER_COUNT)))
                .forEach(lottos::add);
    }
    public int getSize(){
        return lottos.size();
    }
    public List<Lotto> getLottos(){
        return lottos;
    }

    public void setGoal(List<Integer> goal){
        validGoal(goal);
        this.goal = goal;
    }
    private void validGoal(List<Integer> goal){
        Set<Integer> set = new HashSet<>(goal);
        if(set.size()!=NUMBER_COUNT)
            throw new IllegalArgumentException(DUPLICATE_NUMBER.toString());
    }
    public void setBonus(int bonus){
        validBonus(bonus);
        this.bonus = bonus;
    }
    private void validBonus(int bonus){
        if(goal.contains(bonus))
            throw new IllegalArgumentException(DUPLICATE_NUMBER.toString());
    }
    public Result match() {
        int[] matchCount = new int[RANK_COUNT];
        lottos.forEach(lotto -> matchCount[lotto.match(goal,bonus)]++ );
        return new Result(matchCount);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto).append('\n'));
        return sb.toString();
    }
}
