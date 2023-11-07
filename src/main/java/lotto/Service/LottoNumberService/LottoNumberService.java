package lotto.Service.LottoNumberService;

import java.util.List;
import lotto.util.RandomGenerator.GenerateRandomNumber;
import lotto.util.RandomGenerator.LottoGeneratorValidator;

public class LottoNumberService {

    public List<Integer> getUniqueLottoNumber(){
        LottoGeneratorValidator LottoNumber = new GenerateRandomNumber();
        return LottoNumber.generateUniqueLottoNumbers();
    }

}
