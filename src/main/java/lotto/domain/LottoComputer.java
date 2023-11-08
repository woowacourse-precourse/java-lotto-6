package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Application;
import lotto.object.LottoNumber;
import java.util.Collections;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.AbstractMasterDetailListProcessor;

public class LottoComputer {

    public static List<Integer> numberMaker() {
        List<Integer> computerNumber = new ArrayList<Integer>();
        computerNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(computerNumber); // 오름차순으로 정렬

        return computerNumber; // 나중에 Application.computerNumber에 대입할 것
    }

    public static List<LottoNumber> lottoMaker() {
        List<LottoNumber> lottoList = new ArrayList<LottoNumber>();

        // 각 로또 티켓별 인스턴스 생성

        for (int i = 0; i < Application.ticketNumber; i++) {
            int lottoIndex = 0;
            LottoNumber lottoInstance  = new LottoNumber(lottoIndex, numberMaker());
            lottoIndex++;
            lottoList.add(lottoInstance );
        }
        return lottoList;
    }

    public static void printTicket(List<LottoNumber> lottoList) {
        List<LottoNumber> lottoTicket = lottoList;
        for (LottoNumber tmpObj : lottoTicket) {
            System.out.println(tmpObj.getComputerNumber());

        }
    }
}
