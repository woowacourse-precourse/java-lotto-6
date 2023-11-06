package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        Lotto lt = new Lotto(numbers);
        System.out.println("구입금액을 입력해 주세요.");
        int buyLotto = Integer.parseInt(Console.readLine());
        // 1000원 단위 입력 확인(method로 추후 분리 예정)
        if (buyLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] ");
        }

        // 구매 확인 및 리스트
        int lottoNum = buyLotto / 1000;
        System.out.println(lottoNum + "개를 구매했습니다.");
        List<List<Integer>> listNumbers = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> tmpNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            listNumbers.add(tmpNum);
        }

        // 당첨번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumber = new ArrayList<>();
        String winNumber = Console.readLine();
        // ","을 기준으로 하여 각 경주 참가자들을 Array에 임시 저장
        String[] winNumberArray = winNumber.split(",");
        for (int i = 0; i < winNumberArray.length; i++) {
//            winNumber.add(convertInputToNumbers(winNumberArray[i]));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());


        // 당첨 통계


    }
}
