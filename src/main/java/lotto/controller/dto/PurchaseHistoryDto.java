package lotto.controller.dto;

import java.util.List;
import lotto.model.domain.vo.Lottos;

public class PurchaseHistoryDto {

    private int count;
    private List<List<Integer>> lottoNumbers;

    private PurchaseHistoryDto(int count, List<List<Integer>> lottoNumbers) {
        this.count = count;
        this.lottoNumbers = lottoNumbers;
    }

    public static PurchaseHistoryDto toDto(Lottos lottos) {
        int ea = lottos.getEA();
        List<List<Integer>> history = lottos.getHistory();
        return new PurchaseHistoryDto(ea, history);
    }

    public int getCount() {
        return count;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
