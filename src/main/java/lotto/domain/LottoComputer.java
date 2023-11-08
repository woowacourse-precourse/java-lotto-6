package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Application;
import lotto.object.LottoNumber;
import java.util.Collections;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractMasterDetailListProcessor;

public class LottoComputer {
    public static List<Integer> madeNumber = new ArrayList<>();

    public static void numberMaker() {
        madeNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(madeNumber);
        System.out.println(madeNumber);
    }
    public static List<LottoNumber> makingLottoIndex() {
        List<LottoNumber> numbers = new ArrayList<LottoNumber>();

        // 각 로또 티켓별 인스턴스 생성
        int lottoIndex = 0;
        for(int i = 0; i < Application.ticketNumber; i++) {
            numberMaker();
            LottoNumber tmpObj = new LottoNumber(lottoIndex, madeNumber);
            lottoIndex++;
            numbers.add(tmpObj);
        }
        return numbers;
    }
}
