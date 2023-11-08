/**
 * @Package_name : lotto
 * @Class_name : Application
 * <p>
 * Create Date : 2023-11-08 Create User : 정은채
 */
package lotto;

import controller.LottoController;

public class Application {
    /**
     * Description : 메인
     *
     * @Method : main(String[] args)
     */
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.controlLotto();
    }
}
