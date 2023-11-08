package lotto.controller.dto;

import java.util.List;

public class PurchaseHistoryDto {

    private int count;
    private List<List<Integer>> lottoNumbers;

    private PurchaseHistoryDto(int count, List<List<Integer>> lottoNumbers) {
        this.count = count;
        this.lottoNumbers = lottoNumbers;
    }

    public static PurchaseHistoryDto toDto(MoneyLottosDto moneyLottosDto) {
        int ea = moneyLottosDto.getLottos().getEA();
        List<List<Integer>> history = moneyLottosDto.getLottos().getHistory();
        return new PurchaseHistoryDto(ea, history);
    }

    public int getCount() {
        return count;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
