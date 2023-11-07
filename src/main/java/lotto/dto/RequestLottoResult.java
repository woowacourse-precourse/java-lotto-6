package lotto.dto;

import lotto.domain.Prize;

import java.util.List;

public record RequestLottoResult(
        List<Prize> results
) {
   public static RequestLottoResult of(List<Prize> results) {
       return new RequestLottoResult(results);
   }


}
