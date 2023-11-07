package lotto.view;



import static lotto.util.Phrase.OutputPhrase.BUY_HOWMUCH;

public class OutputView {

//    private enum OutputPhrase {
//        BUY_HOWMUCH("%d개를 구매했습니다.\n");
//        private final String message;
//
//        OutputPhrase(String message) {
//            this.message = message;
//        }
//
//    }


    public void printNumberOfLotto(int NumberOfLotto) {
        System.out.printf(BUY_HOWMUCH.printMessage(), NumberOfLotto);
    }

    public void printWinningNumber() {
        //비교 이후 구현
    }
}