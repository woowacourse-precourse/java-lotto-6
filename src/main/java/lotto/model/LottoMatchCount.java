package lotto.model;

import java.util.List;

public record LottoMatchCount(Integer countOf3, Integer countOf4, Integer countOf5, Integer countOf5AndBonus, Integer countOf6) {
    public List<Integer> getCountList(){
        return List.of(countOf3, countOf4, countOf5, countOf5AndBonus, countOf6);
    }
}
