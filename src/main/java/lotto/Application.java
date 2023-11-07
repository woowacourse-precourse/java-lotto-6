package lotto;

public class Application {
    private static ViewInput viewInput = new ViewInput();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = viewInput.getPurchaseAmount();

        System.out.println(result);
    }
}
