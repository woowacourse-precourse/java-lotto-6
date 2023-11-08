package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoInputHandler inputHandler = new LottoInputHandler();
        LottoNumberFactory numberFactory = new LottoNumberFactory();
        LottoResultManager resultManager = new LottoResultManager();
        LottoAnalyzer analyzer = new LottoAnalyzer();

        int purchaseAmount = inputHandler.getPurchaseAmount(); // 구입금액 입력받기
        int lottoCount = purchaseAmount / 1000; // 구입한 로또 개수
        Lotto[] lotto = new Lotto[lottoCount];
        List<Integer> numbers;
        for(int i=0; i<lottoCount; i++) {
            numbers = numberFactory.generateNumbers(); // 로또번호 발행하기
            lotto[i] = new Lotto(numbers); // 로또 생성
        }
        Lotto.showTicketCount(lottoCount);

        for(int i=0 ; i<lottoCount; i++) {
            lotto[i].showTicketInfo(i, lotto);
        }

        List<Integer> winningNumbers = inputHandler.getWinningNumbers(); // 당첨로또번호 입력받기
        int bonusNumber = inputHandler.getBonusNumber(); // 보너스 번호 입력받기

        int[] matchCounts = new int[5];
        for(int i=0; i<lottoCount; i++){
            matchCounts = resultManager.calculateCount(winningNumbers,lotto,i,bonusNumber);
        }
        LottoResultManager.showWinningResults(matchCounts);
        double profitRate = analyzer.getProfitRate(matchCounts,purchaseAmount);

        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }
}
