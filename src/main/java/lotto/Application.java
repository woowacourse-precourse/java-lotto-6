package lotto;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력 및 로또 발행
        int purchaseAmount = 0; // 구입 금액 입력 로직 추가
        int manualLottoCount = 0; // 수동으로 구매할 로또 개수 입력 로직 추가
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount, manualLottoCount);

        // 당첨 번호 및 보너스 번호 입력
        String winningNumbersInput = ""; // 당첨 번호 입력 로직 추가
        int bonusNumber = 0; // 보너스 번호 입력 로직 추가
        WinningLotto winningLotto = WinningLotto.of(winningNumbersInput, bonusNumber);

        // 로또 결과 출력
        LottoResult lottoResult = lottoMachine.calculateResult(winningLotto);
        ResultView.printResult(lottoMachine, lottoResult);
    }
}
