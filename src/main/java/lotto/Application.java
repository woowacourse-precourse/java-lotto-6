package lotto;

import lotto.global.factory.LottoManagerFactory;
import lotto.module.manager.LottoManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO: 보너스 번호와 당첨번호를 분리해서 익셉션이 발생해도 이어서 입력받을 수 있도록
        LottoManager lottoManager = LottoManagerFactory.getSingletonLottoManager();
        lottoManager.run();
    }
}
