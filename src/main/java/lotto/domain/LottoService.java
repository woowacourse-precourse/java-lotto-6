package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static lotto.domain.constants.LottoNumber.MAX_NUMBER;
import static lotto.domain.constants.LottoNumber.MIN_NUMBER;
import static lotto.domain.constants.LottoNumber.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {

    private final LottoRepository lottoRepository;
    private PurchaseCount purchaseCount;
    private WinningLotto winningLotto;

    public LottoService(LottoRepository lottoRepository){
        this.lottoRepository = lottoRepository;
    }

    public Lottos findAllLottos(){
        return lottoRepository.findAll();
    }

    public void savePurchaseCount(int purchaseAmount) {
        this.purchaseCount = new PurchaseCount(purchaseAmount);
    }

    public int findPurchaseCount() {
        return purchaseCount.getValue();
    }

    public void saveWinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    public WinningLotto findWinningLotto() {
        return winningLotto;
    }

    public void issueLottos(int number) {
        List<Lotto> tempLottos = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            tempLottos.add(new Lotto(createRandomNumberList()));
        }

        lottoRepository.saveAll(new Lottos(new ArrayList<>(tempLottos)));
    }

    private List<Integer> createRandomNumberList(){
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size()<NUMBER_COUNT.getValue()){
            numberSet.add(getRandomNumber());
        }

        return new ArrayList<>(numberSet);
    }

    private int getRandomNumber() {
        return pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
    }


    public void checkWinningNumbers(){

    }

    public void calculatePrizeMoney(){

    }

}
