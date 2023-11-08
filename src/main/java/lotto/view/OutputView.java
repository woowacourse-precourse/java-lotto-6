package lotto.view;

import lotto.Constants;
import lotto.domain.User;

public class OutputView {

    public void askBuyingPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void responseBuyingQuantity(User user) {
        System.out.println();
        System.out.println(getQuantity(user) + "개를 구매했습니다.");
    }

    public void responseUserLottoNumber(User user) {
        user.getLottos().forEach(userLotto -> {
            System.out.println(userLotto.getNumbers());
        });
    }

    public int getQuantity(User user) {
        return user.getBuyingPrice() / Constants.LOTTO_PRICE;
    }
}
