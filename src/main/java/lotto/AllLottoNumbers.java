package lotto;

import java.util.List;

public class AllLottoNumbers {

    private List<Lotto> allLottoNumbers;
    public LottoNumberGenerator lottoNumberGenerator;


    public AllLottoNumbers(int ticketCount) {
        this.lottoNumberGenerator = new LottoNumberGenerator(ticketCount);
        this.allLottoNumbers = lottoNumberGenerator.createAllLotto();
    }

    public List<Lotto> getAllLottoNumbers() {
        return allLottoNumbers;
    }

}
