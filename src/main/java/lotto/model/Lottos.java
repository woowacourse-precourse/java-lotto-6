package lotto.model;

import lotto.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.model.LottoInfo.LOTTO_PRICE;
import static lotto.model.LottoInfo.NUMBER_COUNT;

public class Lottos {
    private final List<Lotto> lottos;
    private List<Integer> goal;
    private Integer bonus;

    public Lottos(){
        lottos = new ArrayList<>();
    }
    public void buyOneAllRandom(){
        lottos.add(new Lotto(RandomGenerator.getAutoNumbers(6)));
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
        this.goal = goal;
    }
    public void setBonus(int bonus){
        this.bonus = bonus;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto).append('\n'));
        return sb.toString();
    }
}
