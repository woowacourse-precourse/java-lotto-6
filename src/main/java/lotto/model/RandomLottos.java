package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomLottos {
    private final List<Lotto> randomLottos;
    private final Integer lottoTicketNumber;
    private final Integer LOTTOPRICE = 1000;
    private final Integer NUMBERSPERLOTTO = 6;
    private final Integer LOTTONUMBERSTART = 1;
    private final Integer LOTTONUMBEREND = 45;

    public RandomLottos(LottoAmountofMoney lottoAmountofMoney) {
        this.lottoTicketNumber = lottoAmountofMoney.getLottoAmountofMoney() / LOTTOPRICE;
        this.randomLottos = generateRandomLottos();
    }

    private List<Lotto> generateRandomLottos(){
        List<Lotto> randomLottos = new ArrayList<>();
        for(int i=0; i<lottoTicketNumber; i++){
            randomLottos.add(generateLotto());
        }
        return randomLottos;
    }
    private Lotto generateLotto(){
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i=0; i<NUMBERSPERLOTTO; i++){
            Integer randomInt = Randoms.pickNumberInRange(LOTTONUMBERSTART, LOTTONUMBEREND);
            lottoNumbers.add(randomInt);
        }
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

}
