package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var m = new LottoMachine();
        System.out.println("구입 금액을 입력해주세요.");
        var lottos  = m.buyLottos();
        m.goLotto(lottos);
    }
}
