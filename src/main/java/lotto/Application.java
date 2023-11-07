package lotto;

public class Application {

    public static void main(String[] args) {
        LottoProcessor lottoProcessor = new LottoProcessor();

        lottoProcessor.getLottoController().purchaseLotto();
        lottoProcessor.getRaffleController().setRaffle();
        lottoProcessor.getStaticsController().setStatics();
    }
}
