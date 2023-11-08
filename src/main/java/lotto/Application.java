package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = purchaseAmountInput();
        System.out.println();

        List<Lotto> boughtLottos = buyLotto(purchaseAmount);
        printBoughtLottos(boughtLottos);
        System.out.println();

        Lotto winningLotto = winningLottoInput();
        System.out.println();

        int bonusNumber = bonusNumberInput(winningLotto);
        System.out.println();

        Map<LottoRank, Integer> winningResult = makeWinningResult(winningLotto, bonusNumber, boughtLottos);


    }

    public static int purchaseAmountInput() {
        System.out.println("구매금액을 입력해 주세요.");

        int purchaseAmount = InputManager.purchaseAmountInput();

        return purchaseAmount;
    }

    public static Lotto winningLottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningLotto = InputManager.winningLottoInput();

        return new Lotto(winningLotto);
    }

    public static int bonusNumberInput(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");

        int bonusNumber = InputManager.bonusNumberInput(winningLotto);

        return bonusNumber;
    }

    public static List<Lotto> buyLotto(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        List<List<Integer>> lottoNumbers = LottoNumberGenerator.generateLottoNumbers(purchaseAmount);
        List<Lotto> lottos = makeLottoNumbersToLotto(lottoNumbers);

        return lottos;
    }

    public static void printBoughtLottos(List<Lotto> boughtLottos) {
        for (Lotto lotto : boughtLottos) {
            System.out.println(lotto.toString());
        }
    }

    private static List<Lotto> makeLottoNumbersToLotto(List<List<Integer>> LottoNumbers) {
        return LottoNumbers.stream().map(Lotto::new).collect(Collectors.toList());
    }

    public static Map<LottoRank, Integer> makeWinningResult(Lotto winningLotto, int bonusNumber, List<Lotto> boughtLottos) {
        Map<LottoRank, Integer> winningResult = setWinningResult();

        for (Lotto lotto : boughtLottos) {
            LottoRank winningRanking = LottoNumberReader.checkRanking(winningLotto, bonusNumber, lotto);
            winningResult.put(winningRanking, winningResult.get(winningRanking) + 1);
        }

        return winningResult;
    }

    private static Map<LottoRank, Integer> setWinningResult() {
        Map<LottoRank, Integer> winningResult = new HashMap<>();
        winningResult.put(LottoRank.NO_WIN, 0);
        winningResult.put(LottoRank.FIFTH, 0);
        winningResult.put(LottoRank.FOURTH, 0);
        winningResult.put(LottoRank.THIRD, 0);
        winningResult.put(LottoRank.SECOND, 0);
        winningResult.put(LottoRank.FIRST, 0);

        return winningResult;
    }
}
