package lotto;

import java.util.*;

import static lotto.LottoService.*;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();
    List<Lotto> lottos = new ArrayList<>();
    String lottoAmount;
    /*
    ***** static 변수 *****
    winNumbers  :  당첨 번호
    bonus       :  보너스 번호
    winResult   :  당첨 결과를 담은 객체
     */
    static List<Integer> winNumbers;
    static int bonus;
    static Map<Prize, Integer> winResult;


    public void LottoGamePlay() {
        int count = lottoPurchase();
        createLottoAsCount(count);
        for (Lotto lotto : lottos) {
            outputView.LottoNumber(lotto);
        }
        System.out.println();

        createWinNumber();
        createBonus();

        LottoResult();
    }

    private void LottoResult() {
        int winAmount = 0;
        ResultInit();
        for (Lotto lotto : lottos) {
            winAmount += lottoService.insertResult(lotto, winNumbers);
        }

        outputView.LottoGameResult(winResult);
        outputView.totalRating(lottoService.rateOfReturn(Integer.parseInt(lottoAmount),winAmount));

    }

    private void createBonus() {
        bonus = Integer.parseInt(inputView.bonusNumber());
        System.out.println();
    }

    private void createWinNumber() {
        List<String> inputSplit = Arrays.stream(inputView.winLottoNumber().split(",")).toList();
        winNumbers = new ArrayList<>();
        for (String number : inputSplit) {
            try {
                winNumbers.add(Integer.parseInt(number));
            } catch (IllegalArgumentException e) {
                System.out.println("정수로 변환할 수 없는 값입니다 : " + number);
            }
        }
        System.out.println();
    }

    private void createLottoAsCount(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = lottoService.createLottoNumber();
            lottos.add(new Lotto(lottoNumber));
        }
    }


    private int lottoPurchase() {
        lottoAmount = inputView.purchaseLotto();
        System.out.println();
        int count = lottoService.countingLottoByAmount(Integer.parseInt(lottoAmount));
        outputView.purchaseLottoCount(count);
        return count;
    }

    private void ResultInit() {
        winResult = new HashMap<>();
        winResult.put(Prize.THREE_CORRECT,0);
        winResult.put(Prize.FOUR_CORRECT,0);
        winResult.put(Prize.FIVE_CORRECT_NOT_BONUS,0);
        winResult.put(Prize.FIVE_CORRECT_MATCH_BONUS,0);
        winResult.put(Prize.SIX_CORRECT,0);
    }

}
