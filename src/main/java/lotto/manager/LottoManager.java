package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.InputValidator;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.utility.IntegerUtil.*;
import static lotto.utility.StringUtil.*;

public class LottoManager {

    private static LottoManager lottoManager;
    private int lottoTicketCount;
    private List<Integer> winningNumber;
    private int bonusNumber;


    private LottoManager() {

    }

    public static LottoManager getInstance() {
        if ( lottoManager == null ) {
            lottoManager = new LottoManager();
        }
        return lottoManager;
    }

    public int generateLottoTickets(int payAmount) {
        return payAmount / PAY_AMOUNT_UNIT.getValue();
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
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START_INCLUSIVE.getValue(),
                LOTTO_NUMBER_END_INCLUSIVE.getValue(),
                LOTTO_NUMBER_COUNT.getValue()
        );
    }

    public void setLottoTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
