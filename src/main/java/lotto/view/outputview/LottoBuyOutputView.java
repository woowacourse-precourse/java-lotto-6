package lotto.view.outputview;

import lotto.domain.BuyLotto;
import lotto.domain.Lotto;
import lotto.dto.BuyLottoDto;
import lotto.dto.OutputDto;
import lotto.view.OutputView;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static lotto.view.ParameterConfig.BUY_PRICE;

public final class LottoBuyOutputView implements OutputView {
    @Override
    public void view(Map<String, OutputDto> model) {
        if (model.containsKey(BUY_PRICE) && model.get(BUY_PRICE) != null) {
            BuyLottoDto.Output buyLottoDto = (BuyLottoDto.Output) model.get(BUY_PRICE);
            viewAllBuyLotto(buyLottoDto.getBuyLotto());
            return;
        }
        viewBuyPriceText();
    }

    private void viewAllBuyLotto(BuyLotto buyLotto) {
        System.out.println(buyLotto.lotto().size() + "개를 구매했습니다.");
        for (Lotto lotto : buyLotto.lotto()) {
            System.out.println(sortByAscendingOrder(lotto));
        }
    }

    private String sortByAscendingOrder(Lotto lotto) {
        List<Integer> sortedLotto = lotto.getNumbers()
                .stream()
                .sorted(Comparator.naturalOrder())
                .toList();

        return sortedLotto.toString();
    }

    private void viewBuyPriceText() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
