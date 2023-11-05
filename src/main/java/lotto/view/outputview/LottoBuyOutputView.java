package lotto.view.outputview;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.dto.BuyLottoDTO;
import lotto.dto.DTO;
import lotto.view.OutputView;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static lotto.view.ParameterConfig.BUY_LOTTO_DTO;

public final class LottoBuyOutputView implements OutputView {
    @Override
    public void view(Map<String, ? extends DTO.Output> model) {
        if (model.containsKey(BUY_LOTTO_DTO) && model.get(BUY_LOTTO_DTO) != null) {
            BuyLottoDTO.Output buyLottoDto = (BuyLottoDTO.Output) model.get(BUY_LOTTO_DTO);
            viewAllBuyLotto(buyLottoDto.getPurchasedLotto());
            return;
        }
        viewBuyPriceText();
    }

    private void viewAllBuyLotto(PurchasedLotto buyLotto) {
        System.out.println(buyLotto.lotto().size() + "개를 구매했습니다.");
        for (Lotto lotto : buyLotto.lotto()) {
            System.out.println(sortByAscendingOrder(lotto));
        }
    }

    private void viewBuyPriceText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private String sortByAscendingOrder(Lotto lotto) {
        List<Integer> sortedLotto = lotto.getNumbers()
                .stream()
                .sorted(Comparator.naturalOrder())
                .toList();

        return sortedLotto.toString();
    }
}
