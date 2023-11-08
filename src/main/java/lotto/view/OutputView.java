package lotto.view;

import java.util.Map;
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
        user.getLottos().stream().forEach(userLotto -> {
            System.out.println(userLotto.getNumbers());
        });
    }

    public void askLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    //통계 기능 구현 예정

    public int getQuantity(User user) {
        return user.getBuyingPrice() / 1000;
    }
}
