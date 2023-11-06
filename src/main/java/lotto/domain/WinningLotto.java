package lotto.domain;

import java.util.List;
import lotto.vo.WinningLottoNumbers;

public class WinningLotto {
    private WinningLottoNumbers lottoNumbers;
    private final static int DELETE_INDEX = 6;

    public WinningLotto(List<Integer> lottoNumbers){
        this.lottoNumbers = new WinningLottoNumbers(lottoNumbers);
    }

    public List<Integer> getWinning_number(){
        return this.lottoNumbers.value();
    }

    public void addBonusNumber(String bonus_number){
        this.lottoNumbers.add(bonus_number);
    }
    public void removeBonusNumber(){
        this.lottoNumbers.value().remove(DELETE_INDEX);
    }
}
