package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        Customer user = new Customer();
        OutputView output = new OutputView();
        // 구입금액 입력받기 // 로또 생성하기
        user.buyLottos();
        // 생성된 로또내용 출력하기
        output.printPocket(user);
        // 당첨번호 입력받고 처리하기
        // 보너스 번호 입력받기
        // 당첨내용 판정하기
        // 당첨내용 출력하기
        // 수익률 계산하기
        // 수익률 출력하기
    }
}
