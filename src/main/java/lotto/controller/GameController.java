package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class GameController {
    InputView inputView = new InputView();

    //전체 게임 여기서 컨트롤
    public void gameStart() {
        //1) 구매 금액 입력받기
        int price = inputView.readLottoPrice();
        int lotto_count = price / 1000;

        //2) 구매 가능한 로또 개수만큼 로또 자동 발급 기능
        List<Lotto> lotto_list = generateLottoList(lotto_count);

        //3) 발급한 로또 번호 출력 기능
        printLottoCount(lotto_count);
        for (int i = 0; i < lotto_count; i++) {
            printCurrentLottoList(lotto_list.get(i));
        }
        //4) 당첨 번호 입력 기능
        List<Integer> win_list = inputView.readWinningNumber();

        //5) 보너스 번호 입력 기능
        int bonus_num = inputView.readBonusNumber();

        //6) 당첨에 대한 통계 기능

        //7) 수익률 계산 기능

    }

    /**
     * 2. 구매 가능한 로또 개수만큼 로또 자동 발급기능
     */
    public List<Lotto> generateLottoList(int lottoCount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            //랜덤 값 자동 생성 및 세팅
            list.add(new Lotto(getRandomNumList()));
        }
        return list;
    }

    static private List<Integer> getRandomNumList() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortRandomNumList(list); //정렬 시키기
        return list;
    }

    static private void sortRandomNumList(List<Integer> list) {
        Collections.sort(list);
    }


    /**
     * 3. 발급한 로또 번호 출력 기능
     */
    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printCurrentLottoList(Lotto lotto) {
        System.out.print("[");
        List<Integer> lotto_num_list = lotto.getNumbers();
        //-> 문자열로 변환해서
        List<String> lotto_str_num = lotto_num_list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", lotto_str_num));
        System.out.println("]");
    }


}
