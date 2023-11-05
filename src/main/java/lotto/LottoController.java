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
    static Lotto winNumber;
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
            winAmount += lottoService.insertResult(lotto, winNumber);
        }
        outputView.LottoGameResult(winResult);
        outputView.totalRating(lottoService.rateOfReturn(Integer.parseInt(lottoAmount),winAmount));
    }

    private void createBonus() {
        boolean validateInput = false;
        while (!validateInput){
            try {
                bonus = Integer.parseInt(inputView.bonusNumber());
                validateInput = true;
            } catch (IllegalArgumentException e){
                System.err.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        System.out.println();
    }

    private void createWinNumber() {
        boolean validateInput = false;
        while (!validateInput){
            List<String> inputSplit = Arrays.stream(inputView.winLottoNumber().split(",")).toList();
            List<Integer> numbers = new ArrayList<>();
            for(String number : inputSplit){
                try {
                    int value = Integer.parseInt(number);
                    numbers.add(value);
                } catch (NumberFormatException e) {
                    System.err.println("[ERROR] 올바른 정수로 변환할 수 없는 값: " + number);
                }
            }
            try {
                winNumber = new Lotto(numbers);
                validateInput = true;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
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
        boolean validInput =  false;
        int count =0;
        while(!validInput){
            try {
                lottoAmount = inputView.purchaseLotto();
                count = lottoService.countingLottoByAmount(Integer.parseInt(lottoAmount));
                validInput = true;
            } catch (IllegalArgumentException e){
                System.err.println(INPUT_ERROR_MESSAGE);
            }
        }
        System.out.println();
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
