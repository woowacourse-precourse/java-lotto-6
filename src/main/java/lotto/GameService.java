package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class GameService {
    enum ERROR {
        ERROR1(-1), ERROR2(null);

        private final Object value;

        ERROR(Integer value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }

    GameRepository gameRepository = new GameRepository();

    public int validCash(String rawInput) throws IllegalArgumentException {
        try {
            int rawCash = Integer.parseInt(rawInput);
            if (rawCash % 1000 == 0 && rawCash > 0) {
                return rawCash / 1000;
            }
            throw new IllegalArgumentException("[ERROR] 1000원 단위, 1000원 이상의 로또 구입 금액을 입력해주세요.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 정확한 숫자여야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return (int) ERROR.ERROR1.getValue();
        }
    }

    public String generateNumber() {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        Collections.sort(numbers);
        gameRepository.saveNumber(numbers);
        return numbers.toString();
    }

    // 번호 포맷팅에 대한 검증만 실행, 로또 번호 검증(중복 수, 수의 범위, 번호 개수 등) 로직 : Lotto 실행
    public ArrayList<Integer> validWinNumber(String rawInput) throws IllegalArgumentException {
        try {
            ArrayList<Integer> rawWinNumber = Arrays.stream(rawInput.split(","))
                    .map(String::trim).map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));
            gameRepository.saveWinLottoNumber(rawWinNumber);
            return rawWinNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호를 정확하게 입력해주세요. (쉼표 기준, 여섯 개)");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return (ArrayList<Integer>) ERROR.ERROR2.getValue();
        }
    }
}
