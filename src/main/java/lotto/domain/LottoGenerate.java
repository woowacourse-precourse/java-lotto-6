package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Application;
import lotto.object.LottoNumber;

public class LottoGenerate {
    private static final int lottoPrice = 1000;

    public static void moneyCheck(String money) {
        try {
            Application.purchaseAmount = Integer.parseInt(money);
            if (Application.purchaseAmount % lottoPrice != 0) {
                throw new IllegalArgumentException();
            }
            Application.ticketNumber = Application.purchaseAmount / lottoPrice;
            System.out.println(Application.ticketNumber + "개를 구매했습니다.");
            makeLotto();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액을 1000 단위의 숫자만 입력하세요.");
            LottoStart.buyLotto();
        }
    }

    public static void makeLotto() {
        List<LottoNumber> saveLotto = new ArrayList<LottoNumber>();

        for (int i = 0; i < Application.ticketNumber; i++) {
            // 로또 티켓 각 장마다 인스턴스 생성
            int lottoIndex = 0;
            LottoNumber lottoInstance = new LottoNumber(lottoIndex, numberMaker());
            lottoIndex++;
            saveLotto.add(lottoInstance);
        }
        Application.lottoBox = saveLotto;
        printTicket(Application.lottoBox);
    }

    public static List<Integer> numberMaker() {
        List<Integer> computerNumber = new ArrayList<Integer>();

        computerNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(computerNumber); // 오름차순으로 정렬
        Application.computerNumber = computerNumber;
        return computerNumber;
    }

    public static void printTicket(List<LottoNumber> lottoList) {
        List<LottoNumber> lottoTicket = lottoList;

        for (LottoNumber tmpObj : lottoTicket) {
            System.out.println(tmpObj.getComputerNumber());
        }
    }
}