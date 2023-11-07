package lotto.model;

import lotto.exception.*;

import java.util.List;
import java.util.Objects;
import static lotto.validator.InputLottoValidator.validateBonus;
import static lotto.view.LottoView.requestInputBonusNumber;

public class LottoResult {
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final Integer bonusNumber;
    private Integer countOf3;
    private Integer countOf4;
    private Integer countOf5;
    private Integer countOf5AndBonus;
    private Integer countOf6;
    public LottoResult(Lottos lottos, Lotto winningLotto, String bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = Integer.parseInt(validateBonusNumber(winningLotto,bonusNumber));
        this.countOf3 = 0;
        this.countOf4 = 0;
        this.countOf5 = 0;
        this.countOf5AndBonus = 0;
        this.countOf6 = 0;
    }
    private static String validateBonusNumber(Lotto winningLotto,String bonusNumber) {
        try{
            validateBonus(winningLotto,bonusNumber);
        }catch(EmptyException |
               InvalidLottoFormatException |
               InvalidLottoNumberRangeException |
               DuplicatedNumberException e){
            return validateBonusNumber(winningLotto,requestInputBonusNumber());
        }
        return bonusNumber;
    }
    public void countingMatchCount() {
        for(LottoInfo lottoInfo : this.lottos.getLottos()) {
            lottoInfo.countMatch(this.winningLotto);
            lottoInfo.isMatchBonus(this.bonusNumber);
        }
    }
    public void matchingCount(Integer number) {
        for(LottoInfo lottoInfo : lottos.getLottos()) {
            if(Objects.equals(lottoInfo.getMatchCount(), number)) {
                if(number == 3) {
                    this.countOf3 = this.countOf3 + 1;
                }
                else if(number == 4) {
                    this.countOf4 = this.countOf4 + 1;
                }
                else if(number == 5) {
                    if (lottoInfo.isMatchBonus(this.bonusNumber)) {
                        this.countOf5AndBonus = this.countOf5AndBonus + 1;
                    }
                    else {
                        this.countOf5 = this.countOf5 + 1;
                    }
                }
                else if(number == 6) {
                    this.countOf6 = this.countOf6 + 1;
                }
            }
        }
    }
    public List<Integer> getCountList(){
        return List.of(this.countOf3,this.countOf4,this.countOf5,this.countOf5AndBonus,this.countOf6);
    }
}
