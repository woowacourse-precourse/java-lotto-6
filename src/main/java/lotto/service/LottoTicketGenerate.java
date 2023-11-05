package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoTicketEntity;

import java.util.List;

public class LottoTicketGenerate {
    static final int LOTTO_NUMBER_MAX = 45;
    static final int LOTTO_NUMBER_MIN = 1;
    static final int TOTAL_LOTTO_NUMBER_COUNT = 6;


    public LottoTicketEntity setLottoTicketsNumber() {
       LottoTicketEntity lottoTicketEntity = new LottoTicketEntity();

        List<Integer> lottoNumbers = randomNumberGenerate();
        lottoTicketEntity.setLottoNumbers(lottoNumbers);

        return lottoTicketEntity;
    }


    private static List<Integer> randomNumberGenerate() {
        List<Integer> lottoNumbers;

        lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, TOTAL_LOTTO_NUMBER_COUNT);
        LottoValidateRegistry.lottoTicketValidate(lottoNumbers);

        return lottoNumbers;
    }

}
