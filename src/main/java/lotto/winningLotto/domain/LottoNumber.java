package lotto.winningLotto.domain;

import static java.util.Collections.sort;

import java.util.List;
import lotto.Positive;
import lotto.userLotto.domain.Lotto;
import lotto.util.LottoConstant;

public class LottoNumber {
    private List<Positive> lottoNumbers;

    public LottoNumber(List<Positive> lottoNumbers){
        validateBlank(lottoNumbers);
        validateSize(lottoNumbers);
        validateDuplicated(lottoNumbers);
        validateOutOfRangeOneToFortyFive(lottoNumbers);
        sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }
    public List<Positive> getLottoNumbers(){
        return lottoNumbers;
    }

    public boolean contains(LottoBonusNumber lottoBonusNumber){
        for(Positive lottoNumbers : lottoNumbers){
            if(lottoNumbers.getNumber() == lottoBonusNumber.getNumber()){
                return true;
            }
        }
        return false;
    }
    public int match(Lotto userLotto){
        int matchCount =0;
        for(int i =0; i<6; i++){
            for(int j = 0; j<6;j++){
                if(lottoNumbers.get(j).getNumber()==userLotto.getLotto().get(i)){
                    matchCount++;
                }
            }
        }
        return matchCount;
    }
    private void validateBlank(List<Positive> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Positive> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicated(List<Positive> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Positive> numbers) {
        return numbers.size() != duplicatedSize(numbers);
    }

    private Long duplicatedSize(List<Positive> numbers) {
        return numbers.stream().distinct().count();
    }


    private void validateOutOfRangeOneToFortyFive(List<Positive> numbers) {
        for (Positive number : numbers) {
            checkOutOfRangeRangeOneToFortyFive(number.getNumber());
        }
    }

    private void checkOutOfRangeRangeOneToFortyFive(int number) {
        if (number < LottoConstant.BEGIN_NUMBER || number > LottoConstant.LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }


}
