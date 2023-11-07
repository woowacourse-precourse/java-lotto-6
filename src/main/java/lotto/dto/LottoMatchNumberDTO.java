package lotto.dto;

import java.util.List;

public record LottoMatchNumberDTO(Integer countOf3, Integer countOf4, Integer countOf5, Integer countOf5AndBonus,Integer countOf6) {
    public List<Integer> getCountList(){
        return List.of(countOf3, countOf4, countOf5, countOf5AndBonus, countOf6);
    }
}
