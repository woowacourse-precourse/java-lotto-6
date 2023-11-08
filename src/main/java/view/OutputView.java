package view;

import java.util.List;
import java.util.Map;
import model.PurchasedLotto;

public class OutputView {

    public void showPurchaseLotto(PurchasedLotto lottoVO) {
        System.out.println(lottoVO.getPurchaseLotto().size() + "개를 구매했습니다.");
        for (List<Integer> lottoNumbers : lottoVO.getPurchaseLotto()) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void showResult(Map<String, Integer> result) {
        System.out.println("3개 일치 (5,000원) - " + result.get("fifth") + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get("fourth") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get("third") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get("second") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get("first") + "개");
        System.out.println("3개 일치 (5,000원) - " + result.get("resultPercent") + "%입니다.");
    }
}
