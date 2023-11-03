package lotto;

public class Application {
    public static void main(String[] args) {
        try { // 예외처리할 때 에러메세지 내고 "프로그램 종료"
            InputSystem input = new InputSystem();
            input.purchase();
        } catch (Exception e) {
            System.out.println("[ERROR]");
        }
    }

}
