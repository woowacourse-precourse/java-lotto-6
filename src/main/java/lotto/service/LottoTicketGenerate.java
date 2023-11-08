package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoTicketEntity;
import lotto.service.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.AppConstants.lottoConstants.*;

public class LottoTicketGenerate {
    private List<LottoTicketEntity> lottoTicketEntities = new ArrayList<>();


    public LottoTicketGenerate(int lottoTicketCount) {
        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers = randomNumberGenerate();
            LottoTicketEntity lottoTicketEntity = new LottoTicketEntity();

            lottoTicketEntity.setLottoNumbers(lottoNumbers);

            this.lottoTicketEntities.add(lottoTicketEntity);
        }
    }

    public List<LottoTicketEntity> getLottoTicketEntities() {
        return lottoTicketEntities;
    }

    private static List<Integer> randomNumberGenerate() {
        List<Integer> lottoNumbers;

        lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue(), TOTAL_LOTTO_NUMBER_COUNT.getValue());
        LottoValidator.lottoTicketValidate(lottoNumbers);

        return lottoNumbers;
    }

    public void sortLottoTicketEntities() {
        for (LottoTicketEntity lottoTicketEntity : lottoTicketEntities) {
            List<Integer> lottoNumbers = new ArrayList<>(lottoTicketEntity.getLottoNumbers());
            lottoNumbers.sort(Integer::compareTo);
            lottoTicketEntity.setLottoNumbers(lottoNumbers);
        }
    }

}
