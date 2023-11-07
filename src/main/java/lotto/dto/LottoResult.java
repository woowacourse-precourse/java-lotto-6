package lotto.dto;

import lotto.domain.Prize;

import java.util.List;

public record LottoResult(
        List<Prize> results
) {
   public static LottoResult of(List<Prize> results) {
       return new LottoResult(results);
   }


}
