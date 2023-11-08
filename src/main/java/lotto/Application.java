package lotto;

public class Application {
    public static void main(String[] args) {
        LottoViewResolver lottoViewResolver = new LottoViewResolver();
        LottoDispatcher lottoDispatcher = lottoViewResolver.getLottoDispatcher();
        Board board = new Board(lottoDispatcher);
        lottoViewResolver.staticsResult(board);
        lottoViewResolver.earningResult(board);
    }
}