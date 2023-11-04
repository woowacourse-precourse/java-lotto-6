package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    //전체 게임 여기서 컨트롤
    static void gameStart() {
        //1) 구매 금액 입력받기
        int price = readLottoPrice();
        int lotto_count = price / 1000;

        //2) 구매 가능한 로또 개수만큼 로또 자동 발급 기능
        List<Lotto> lotto_list = generateLottoList(lotto_count);

        //3) 발급한 로또 번호 출력 기능

        //4) 당첨 번호 입력 기능

        //5) 보너스 번호 입력 기능

        //6) 당첨에 대한 통계 기능

        //7) 수익률 계산 기능

    }

    /**
     * 1) [로또 구매 금액] 입력받기 관련
     *
     * @return
     */
    //가격 입력받아서 가격을 리턴하고 구매할 로또
    static int readLottoPrice() {
        //메시지
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validateLottoPrice(input);
        return Integer.parseInt(input);
    }

    static void validateLottoPrice(String input) throws IllegalArgumentException {
        //1) 숫자 입력 아니면 예외
        for (char num : input.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("[ERROR] 구매 금액에는 숫자만 입력해야 합니다. ");
            }
        }

        //2) 숫자 범위 어긋난 경우 예외
        int input_number = Integer.parseInt(input);
        if (input_number < 1000 || input_number <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액의 범위는 1000원 이상이어야 합니다.");
        }

        //3) 1000원 단위로 나누어 떨어지지 않아도 예외
        if (input_number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR} 구매 금액은 1000원 단위로 작성되어야 합니다.");
        }

        //4) 불필요한 띄어쓰기, 공백 포함 시 예외
        for (char num : input.toCharArray()) {
            if (num == ' ') {
                throw new IllegalArgumentException("[ERROR] 구매 금액에 공백이 포함되면 안됩니다.");
            }
        }
    }

    /**
     * 2. 구매 가능한 로또 개수만큼 로또 자동 발급기능
     */
    static List<Lotto> generateLottoList(int lottoCount) {
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

}
