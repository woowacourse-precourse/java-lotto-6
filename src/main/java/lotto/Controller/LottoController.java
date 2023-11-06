package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.Ranking;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoController {

    InputView inputView = new InputView();
    List<Lotto> purchaseLottoList;
    OutputView outputView = new OutputView();
    int bonusNum;
    int price;

    public void lottoStart() {
        price = inputPrice();
        purchase(price);

        System.out.println();

        Map<Ranking, Integer> result = compareLotto(createWinningLotto());
        outputView.outputResult(result);
        outputView.outputRateOfReturn(countRateOfReturn(result));
    }

    private Integer inputPrice() {
        String price = "";
        try {
            price = inputView.inputPrice();
            checkErrorPrice(price);
            checkDiv(Integer.parseInt(price));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액을 다시 입력해주세요.");
            inputPrice();
        }
        return Integer.parseInt(price);
    }

    private void checkErrorPrice(String price) throws IllegalArgumentException {
        final String REGEX = "[0-9]+";
        if(!price.matches(REGEX)) throw new IllegalArgumentException();
    }

    private void checkDiv(int price) throws IllegalArgumentException {
        if(price%1000 != 0) throw new IllegalArgumentException();
    }

    private void purchase(int price) {
        System.out.println();
        int countLotto = price / 1000;
        System.out.println(countLotto + "개를 구매했습니다.");

        purchaseLottoList = new ArrayList<>();
        for(int i = 0; i<countLotto; i++) {
            Lotto lotto = createLotto();
            outputView.outputLottoNum(lotto);
            purchaseLottoList.add(lotto);
        }
    }

    private Lotto createLotto() {
        List<Integer> lottoNumList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumList);
    }

    private Lotto createWinningLotto() {
        List<Integer> winningNum = inputView.inputWinningNum();
        bonusNum = inputView.inputBonusNum();

        return new Lotto(winningNum);
    }

    private Map<Ranking, Integer> compareLotto(Lotto winningLotto) {
        Map<Ranking, Integer> result = setResult();
        Ranking ranking;

        for(int i = 0; i<purchaseLottoList.size();i++) {
            ranking = match(purchaseLottoList.get(i), winningLotto);
            result.put(ranking, result.get(ranking) + 1);
        }

        return result;
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for(Ranking ranking : Ranking.values()) {
            result.put(ranking, 0);
        }
        return result;
    }

    private Ranking match(Lotto playerLotto, Lotto winningLotto) {
        List<Integer> matchList = playerLotto.getNumbers().stream().filter(o->winningLotto.getNumbers().stream()
                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
        boolean bonusNumCheck = playerLotto.getNumbers().contains(bonusNum);
        int matchCount = matchList.size();
        return Ranking.valueOf(matchCount, bonusNumCheck);
    }

    private Double countRateOfReturn(Map<Ranking, Integer> result) {
        double rate = 0;

        for(Ranking ranking : result.keySet()) {
            rate = rate + ((double)(ranking.getWinningAmount()) / price * (result.get(ranking)) * (100));
        }
        return rate;
    }
}
