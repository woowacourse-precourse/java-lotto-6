package lotto.dto;

import java.util.List;

public record LottoInfoResponse(Integer lottoCount, List<List<Integer>> lottoNumbers) {

}
