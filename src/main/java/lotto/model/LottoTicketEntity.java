package lotto.model;

import java.util.List;

public class LottoTicketEntity {
    private List<Integer> LottoNumbers;
    public void setLottoNumbers(List<Integer> lottoNumbers) {
        LottoNumbers = lottoNumbers;
    }
    public List<Integer> getLottoNumbers() {
        return LottoNumbers;
    }
}
