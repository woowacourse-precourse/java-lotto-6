package lotto.Controller;

import lotto.Enum.LottoError;
import lotto.Enum.Prize;
import lotto.Lotto;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.*;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();
    List<Lotto> lottos = new ArrayList<>();
    String lottoAmount;
    static Lotto winNumber;
    public static int bonus;
    public static Map<Prize, Integer> winResult;


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
        for (Lotto lotto : lottos) {
            insertResult(lotto, winNumber);
        }
        int winAmount = lottoService.prizeAmount(winResult);
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
                System.err.println(e.getMessage());
            }
        }
        System.out.println();
    }

    private void createWinNumber() {
        boolean validateInput = false;
        while (!validateInput){
            List<Integer> numbers = splitNumber();
            validateInput = insertNumberToLotto(numbers);
        }
        System.out.println();
    }

    private boolean insertNumberToLotto(List<Integer> numbers) {
        try {
            winNumber = new Lotto(numbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private List<Integer> splitNumber() {
        List<String> inputSplit = Arrays.stream(inputView.winLottoNumber().split(",")).toList();
        List<Integer> numbers = new ArrayList<>();
        for(String number : inputSplit){
            try {
                int value = Integer.parseInt(number);
                numbers.add(value);
            } catch (NumberFormatException e) {
                System.err.println(LottoError.NumberFormat.getErrorMessage());
            }
        }
        return numbers;
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
                System.err.println(LottoError.AmountFormat.getErrorMessage());
            }
        }
        System.out.println();
        outputView.purchaseLottoCount(count);
        return count;
    }

    public void insertResult(Lotto lotto, Lotto winNumbers) {
        ResultInit();
        int count = lottoService.sameNumberCount(lotto, winNumbers);
        if (count == 3) {
            winResult.put(Prize.THREE_CORRECT, winResult.get(Prize.THREE_CORRECT) + 1);
        }
        if (count == 4) {
            winResult.put(Prize.FOUR_CORRECT, winResult.get(Prize.FOUR_CORRECT) + 1);
        }
        if (count == 5) {
            if (lottoService.isSameBonusNumber(lotto, bonus)) {
                winResult.put(Prize.FIVE_CORRECT_MATCH_BONUS, winResult.get(Prize.FIVE_CORRECT_MATCH_BONUS) + 1);
            }
            if (!lottoService.isSameBonusNumber(lotto, bonus)) {
                winResult.put(Prize.FIVE_CORRECT_NOT_BONUS, winResult.get(Prize.FIVE_CORRECT_NOT_BONUS) + 1);
            }
        }
        if (count == 6) {
            winResult.put(Prize.SIX_CORRECT, winResult.get(Prize.SIX_CORRECT) + 1);
        }
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
