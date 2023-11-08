package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Customer;
import lotto.domain.Seller;
import util.InputValidator;

/**
 * packageName    : PACKAGE_NAME fileName       : lotto.LottoGameService author         : asdfz date           :
 * 2023-11-08 description : =============================================== DATE              AUTHOR             NOTE
 * ----------------------------------------------- 2023-11-08        asdfz       최초 생성
 */
public class LottoGameService {

    private final Customer customer;
    private final Seller seller;
    private final LottoValidator lottoValidator;


    public LottoGameService() {
        this.lottoValidator = new LottoValidator();
        this.customer = new Customer(askMoney());
        this.seller = new Seller();
    }

    public void playGame() {
        customer.buyLotto(seller);
        customer.showMyOrders();
        customer.checkMyWiningStatus();
    }

    private int askMoney() {
        int money = 0;
        try {
            money = askCustomerForMoney();
        } catch (IllegalArgumentException e) {
            askMoney();
        }

        return money;
    }

    private int askCustomerForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine();
        InputValidator.validNumberType(inputValue);

        int money = Integer.parseInt(inputValue);
        lottoValidator.validateMoneyValue(money);

        return money;
    }

}
