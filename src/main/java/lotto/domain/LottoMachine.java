package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.config.LottoConfig;

public class LottoMachine {

    public static List<Lotto> generate(int amount){
        int lottoLimit = checkGenerateLimit(amount);

        List<Lotto> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < lottoLimit; i++){
            lottoNumbers.add(new Lotto(generateLottoTickets()));
        }
        return lottoNumbers;
    }

    public static int checkGenerateLimit(int amount){
        return amount / LottoConfig.LOTTO_LEAST_AMOUNT.getValue();
    }

    public static List<Integer> generateLottoTickets(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
