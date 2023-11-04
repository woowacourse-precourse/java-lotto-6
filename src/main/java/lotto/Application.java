package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;

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
        printLottoCount(lotto_count);
        for (int i = 0; i < lotto_count; i++) {
            printCurrentLottoList(lotto_list.get(i));
        }
        //4) 당첨 번호 입력 기능
        List<Integer> win_list = readWinningNumber();

        //5) 보너스 번호 입력 기능
        int bonus_num = readBonusNumber();
        WinLotto winLotto = new WinLotto(win_list, bonus_num);

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


    /**
     * 3. 발급한 로또 번호 출력 기능
     */
    static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    static void printCurrentLottoList(Lotto lotto) {
        System.out.print("[");
        List<Integer> lotto_num_list = lotto.getNumbers();
        //-> 문자열로 변환해서
        List<String> lotto_str_num = lotto_num_list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", lotto_str_num));
        System.out.println("]");
    }

    /**
     * 4. 당첨 번호 입력 기능
     */

    static List<Integer> readWinningNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        //컴마 예외
        validateWinNumberComma(input);

        //변환
        List<String> list = Arrays.asList(input.split(","));
        //리스트 예외
        validateWinNumberList(list);

        return list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    static void validateWinNumberComma(String input) throws IllegalArgumentException {
        //1) 처음부터 컴마 입력 시
        if (input.charAt(0) == ',') {
            throw new IllegalArgumentException("[ERRPR] 당첨 번호에 처음부터 쉼표(,) 가 입력되면 안됩니다.");
        }

        //2) 중간 중복 컴마
        if (input.contains(",,")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 쉼표가 포함되면 안됩니다.");
        }

        //3) 끝에 컴마만 입력 시
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 끝에 쉼표(,)가 입력되면 안됩니다. ");
        }
    }

    static void validateWinNumberList(List<String> list) throws IllegalArgumentException {
        if (list.size() != 6) {
            throw new IllegalArgumentException();
        }

        //1) 숫자 아닌 값 포함 시 예외

        //2) 당첨 번호 범위 벗어난 경우

        //3) 공백 포함 시 예외

        //4) 당첨 번호와 중복 시 예외

        //5) 당첨 번호 개수가 6개 아닐 경우 예외
    }

    /**
     * 5. 보너스 번호 입력
     */

    static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String num = Console.readLine();

        //예외 처리
        validateBonusNumber(num);
        return Integer.parseInt(num);
    }

    static void validateBonusNumber(String input) throws IllegalArgumentException {
        //1) 숫자 아닌 값 예외

        //2) 범위 벗어난 값 예외

        //3) 공백 포함 시 예외

        //4) 앞선 6개 당첨 번호와 중복 시 예외

    }

}

