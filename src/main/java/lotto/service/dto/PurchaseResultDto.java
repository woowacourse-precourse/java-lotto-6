package lotto.service.dto;

import java.util.List;

public record PurchaseResultDto(int size, List<List<Integer>> lottoNumbers){
}
