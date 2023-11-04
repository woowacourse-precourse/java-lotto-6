package lotto;

import java.util.*;

import static lotto.LottoService.*;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();
    List<Lotto> lottos = new ArrayList<>();
    String lottoAmount;
    List<Integer> winNumbers;
    int bonus;
    Map<String, Integer> winResult;

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
        winResult = new HashMap<>();
        winResult.put(THREE_CORRECT,0);
        winResult.put(FOUR_CORRECT,0);
        winResult.put(FIVE_CORRECT_MATCH_BONUS,0);
        winResult.put(FIVE_CORRECT_NOT_BONUS,0);
        winResult.put(SIX_CORRECT,0);
        int winAmount = 0;
        for (Lotto lotto : lottos) {
            int count = lottoService.sameNumberCount(lotto, winNumbers);
            if (count == 3) {
                winResult.put(THREE_CORRECT, winResult.get(THREE_CORRECT) + 1);
                winAmount += 5000;
            }
            if (count == 4) {
                winResult.put(FOUR_CORRECT, winResult.get(FOUR_CORRECT) + 1);
                winAmount += 50000;
            }
            if (count == 5) {
                if (lottoService.isSameBonusNumber(lotto, bonus)) {
                    winResult.put(FIVE_CORRECT_MATCH_BONUS, winResult.get(FIVE_CORRECT_MATCH_BONUS) + 1);
                    winAmount += 30000000;
                }
                if (!lottoService.isSameBonusNumber(lotto, bonus)) {
                    winResult.put(FIVE_CORRECT_NOT_BONUS, winResult.get(FIVE_CORRECT_NOT_BONUS) + 1);
                    winAmount += 1500000;
                }
            }
            if (count == 6) {
                winResult.put(SIX_CORRECT, winResult.get(SIX_CORRECT) + 1);
                winAmount += 2000000000;
            }
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

}
