package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
public class Controller {
    private static int ticketCnt;
    private static List<Lotto> lottoList;
    private static WinningResult winningNumber;
    private static int[] resultarr = new int[7];

    public static void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void start() throws IllegalArgumentException{
        //구입 금액
        ticketCnt = View.inputPrice();
        View.outputTicket(ticketCnt);

        //로또 번호 생성
        lottoList = createLottoList(ticketCnt);

        View.outputLotto(lottoList);

        //당첨 번호 보너스 번호 입력
        createWinning();


        //당첨 통계 출력
        resultCalculation();
        long rate = View.outputResult(resultarr);

        //수익률 출력
        View.outputPlus(rate);
    }

    private static List<Lotto> createLottoList(int ticketCnt) {
        List<Lotto> list = new ArrayList<>();

        for(int i=0; i<ticketCnt; i++) {
            list.add(createLotto());
        }

        return list;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    private static void createWinning() {
        //로또객체와 보너스 넘버
        Lotto lotto = new Lotto(View.inputWinning());
        int bonusNum = View.inputBonusNum();

        winningNumber = new WinningResult(lotto, bonusNum);

        List<Integer> lottoList = winningNumber.getLotto().getLotto();

        if(lottoList.contains(bonusNum)) {
            //중복이라면

        }

        winningNumber.setBonusNum(bonusNum);
    }

    private static void resultCalculation() {

        for(Lotto lotto : lottoList) {
            isRanking(lotto);
        }
    }

    private static void isRanking(Lotto lotto) {
        List<Integer> lottoNum = lotto.getLotto();
        List<Integer> winningNum = winningNumber.getLotto().getLotto();

        int cnt = 0;
        for(int i=0; i<lottoNum.size(); i++) {
            if(Objects.equals(lottoNum.get(i), winningNum.get(i))) cnt++;
        }

        if(cnt > 2) {
            if (cnt == 5) {
                if (lottoNum.contains(winningNumber.bonusNum)) {
                    resultarr[0]++;
                    return;
                }
                resultarr[cnt]++;
                return;
            }
            resultarr[cnt]++;
        }

    }
}
