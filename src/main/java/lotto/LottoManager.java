package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.IntegerUtil.*;
import static lotto.StringUtil.*;

public class LottoManager {

    private static LottoManager lottoManager;

    private LottoManager() {

    }

    public static LottoManager getInstance() {
        if ( lottoManager == null ) {
            lottoManager = new LottoManager();
        }
        return lottoManager;
    }
    private int lottoTicketCount;

    public int generateLottoTickets(int payAmount) {

        if ( payAmount % PAY_AMOUNT_UNIT.getValue() != 0 ) {
            throw new IllegalArgumentException(PRINT_ERR_PAY_AMONUT.getMessage());
        }

        return payAmount / PAY_AMOUNT_UNIT.getValue();
    }

    public void setLottoTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> generateLottoList() {
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i < this.lottoTicketCount; i++ ) {
            Lotto lotto = new Lotto(generateLottoNumber());
            lottoList.add(lotto);
        }

        return lottoList;
    }

    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
