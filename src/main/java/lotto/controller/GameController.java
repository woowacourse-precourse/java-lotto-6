package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.domain.WinLottoResult;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GameService gameService = new GameService();
    WinLottoResult winLottoResult;

    //전체 게임 여기서 컨트롤
    public void gameStart() {
        //1) 구매 금액 입력받기
        int price = inputView.readLottoPrice();
        int lotto_count = price / 1000;

        //2) 구매 가능한 로또 개수만큼 로또 자동 발급 기능
        List<Lotto> lotto_list = gameService.generateLottoList(lotto_count);

        //3) 발급한 로또 번호 출력 기능
        outputView.printLottoCount(lotto_count);
        for (int i = 0; i < lotto_count; i++) {
            outputView.printCurrentLottoList(lotto_list.get(i));
        }

        WinLotto winLotto = new WinLotto();
        //4) 당첨 번호 입력 기능
        List<Integer> win_list = inputView.readWinningNumber();
        winLotto.setNumbers(win_list);

        //5) 보너스 번호 입력 기능
        int bonus_num = inputView.readBonusNumber();
        winLotto.setBonus_num(bonus_num);

        //6) 당첨에 대한 통계 기능
        judgePrizeLotto(winLotto, lotto_list, winLottoResult);
        printResultLottoPrize(winLottoResult);

        //7) 수익률 계산 기능

    }

    /**
     * 6. 당첨에 대한 통계 기능
     */
    static void judgePrizeLotto(WinLotto winLotto, List<Lotto> lottoList, WinLottoResult winLottoResult) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < lottoList.size(); i++) {
            int count = countWithNum(lottoList.get(i), winLotto);
            boolean flag = isBunus(lottoList.get(i), winLotto.getBonus_num());

            if (count == 3) {
                map.put("three", map.getOrDefault("three", 0) + 1);
            }
            if (count == 4) {
                map.put("four", map.getOrDefault("four", 0) + 1);
            }
            if (count == 5 && !flag) {
                map.put("five", map.getOrDefault("five", 0) + 1);
            }
            if (count == 5 && flag) {
                map.put("five_bonus", map.getOrDefault("five_bonus", 0) + 1);
            }
            if (count == 6) {
                map.put("six", map.getOrDefault("six", 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            for (WinLottoResult cur : winLottoResult.values()) {
                if (cur.getName().equals(key)) {
                    cur.setCount(map.get(key));
                }
            }
        }
    }

    static boolean isBunus(Lotto lotto, int bonus) {
        List<Integer> list = lotto.getNumbers();
        if (list.contains(bonus)) {
            return true;
        }

        return false;
    }

    //각 리스트별 카운팅 개수 리턴해서
    static int countWithNum(Lotto lotto, WinLotto winLotto) {
        List<String> lotto_num = lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        List<String> winLotto_list = winLotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        lotto_num.retainAll(winLotto_list);//중복되는 것만 남게

        return lotto_num.size();
    }

    /**
     * 결과 출력
     */
    static void printResultLottoPrize(WinLottoResult winLottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinLottoResult ans : winLottoResult.values()) {
            if (ans.getName().equals("three")) {
                System.out.println("3개 일치 (5,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("four")) {
                System.out.println("4개 일치 (50,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("five")) {
                System.out.println("5개 일치 (1,500,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("six")) {
                System.out.println("6개 일치 (2,000,000,000원) - " + ans.getCount() + "개");
            }
            if (ans.getName().equals("five_bonus")) {
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ans.getCount() + "개");
            }
        }
    }


}
