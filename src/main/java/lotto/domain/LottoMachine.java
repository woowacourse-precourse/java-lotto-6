package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
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

    private static int checkGenerateLimit(int amount){
        return amount / LottoConfig.LOTTO_LEAST_AMOUNT.getValue();
    }

    private static List<Integer> generateLottoTickets(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConfig.LOTTO_START_NUMBER.getValue(),
                LottoConfig.LOTTO_LAST_NUMBER.getValue(), LottoConfig.LOTTO_LENGTH.getValue());
        return numbers;
    }
}
