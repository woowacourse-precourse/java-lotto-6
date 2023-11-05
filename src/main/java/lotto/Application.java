package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Integer paper = InputView.PaperNumber(InputView.InputMoney());
        InputView.makeLottoTicket(paper);
        InputView.InputNumbers();
        InputView.Score();
    }
}
