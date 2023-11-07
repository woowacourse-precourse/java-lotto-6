package service;

import model.Lottos;
import model.ResultLotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    private final Lottos lottos;
    private final Integer count;

    public LottoService(Integer count){
        lottos = new Lottos(count);
        this.count = count;
    }

    private Integer findEqualNumber(List<Integer> winningLotto,Integer index){
        return (int) lottos.getLotto(index).stream()
                .filter(winningLotto::contains)
                .count();
    }
    private Boolean findEqualBonus(Integer bonusNumber,Integer index){
        return lottos.getLotto(index).contains(bonusNumber);
    }
    public List<ResultLotto> findResults(List<Integer> winningLotto,Integer bonusNumber){
        return IntStream.range(0, count)
                .mapToObj(i -> new ResultLotto(findEqualNumber(winningLotto, i), findEqualBonus(bonusNumber, i)))
                .toList();
    }
}
