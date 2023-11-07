package lotto.Service.LottoNumberService;

import java.util.List;
import lotto.Model.Lotto.Lotto;
import lotto.Service.LottoNumberService.RandomGenerator.GenerateRandomNumber;

public class LottoNumberService {

    public Lotto getUniqueLottoNumber(){
        GenerateRandomNumber LottoNumber = new GenerateRandomNumber();
        return LottoNumber.generateUniqueLottoNumbers();
    }

}
