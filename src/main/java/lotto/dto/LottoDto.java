package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottery.LottoNumber;

public class LottoDto {
    private final List<Integer> lotto;

    public LottoDto(List<LottoNumber> lotto) {
        this.lotto = create(lotto);
    }

    private List<Integer> create(List<LottoNumber> lottoNumbers) {
        List<Integer> lotto = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            lotto.add(lottoNumber.getNumber());
        }
        return lotto;
    }

    @Override
    public String toString() {
        return String.valueOf(lotto);
    }
}
