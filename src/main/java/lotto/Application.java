package lotto;

public class Application {
    private final static LottoViewer lottoViewer = new LottoViewer();
    private static LottoController lottoController;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoController = new LottoController(lottoViewer);
    }
}
