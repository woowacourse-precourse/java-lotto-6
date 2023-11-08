package lotto.domain.dto;

import java.util.List;

public class BuyLottoInfo {
    private List<List<Integer>> userLottoNumbers;
    private int lottoTicketCount;

    public BuyLottoInfo(List<List<Integer>> userLottoNumbers, int lottoTicketCount){
        this.lottoTicketCount = lottoTicketCount;
        this.userLottoNumbers = userLottoNumbers;
    }

    public List<List<Integer>> getUserLottoNumbers() {
        return userLottoNumbers;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }
}
