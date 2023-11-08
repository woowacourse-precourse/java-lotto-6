package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = purchaseAmountInput();
        System.out.println();

        Lotto winningLotto = winningLottoInput();
        System.out.println();

        int bonusNumber = bonusNumberInput(winningLotto);
        System.out.println();

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


    private static List<Lotto> makeLottoNumbersToLotto(List<List<Integer>> LottoNumbers) {
        return LottoNumbers.stream().map(Lotto::new).collect(Collectors.toList());
    }
}
