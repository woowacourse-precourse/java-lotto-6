package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {
    private List<LottoNumber> winningLottoNumbers;

    private WinningLottoNumbers(String winningLottoNumbers){
        this.winningLottoNumbers = new ArrayList<>();
    }

    public static WinningLottoNumbers of(String winningLottoNumbers){
        return new WinningLottoNumbers(winningLottoNumbers);
    }
}
