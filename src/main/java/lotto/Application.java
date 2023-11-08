package lotto;

public class Application {
    public static final double ONE_LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = Ask.askPurchaseNumber();
        NumberGenerator[] purchaseNumbers = new NumberGenerator[purchaseAmount];
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        NumberGenerator.generateLottos(purchaseAmount, purchaseNumbers); // 구매한 개수만큼 로또 번호를 생성
        // 사용자에게 당첨 번호와 보너스 번호를 입력받음
        Lotto winningNumbers = Ask.askWiningNumber();
        int bonusNumber = Ask.askBonusNumber(winningNumbers);
        // 입력받은 당첨번호를 바탕으로 사용자가 구매한 로또 번호들의 당첨 결과를 계산
        Lotto[] userLotto = getLottos(purchaseAmount, purchaseNumbers);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningNumbers, userLotto, bonusNumber);
        lottoResultChecker.checkLottoResult();
        // 당첨 결과를 출력
        Prints.printResult(lottoResultChecker);
    }


    // NumGenerator 배열에서 Lotto들을 빼서 Lotto 배열을 만드는 메서드
    private static Lotto[] getLottos(int purchaseAmount, NumberGenerator[] purchaseNumbers) {
        Lotto[] userLotto = new Lotto[purchaseAmount];
        // NumGenerator 배열에서 Lotto들을 빼서 Lotto 배열을 만들기
        for (int i = 0; i < purchaseAmount; i++) {
            userLotto[i] = purchaseNumbers[i].getLotto();
        }
        return userLotto;
    }

    // 구입 금액에 해당하는 만큼 로또를 발행하는 메서드
    public static void generateLottos(int purchaseAmount, NumberGenerator[] purchaseNumbers) {
        for (int i = 0; i < purchaseAmount; i++) {
            purchaseNumbers[i] = new NumberGenerator();
            purchaseNumbers[i].generateLottoNumbers();
            System.out.println(purchaseNumbers[i].getLottoNumbers());
        }
    }


}
