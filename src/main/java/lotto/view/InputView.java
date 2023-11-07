package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.message.InputExceptionMessage;
import lotto.model.Lotto;

/**
 * 입력을 담당하는 뷰 클래스
 */
public class InputView {

    /**
     * 로또 한장당의 가격, 1000원
     */
    private static final int LOTTO_PRICE = 1000;
    /**
     * 숫자만 존재하는지 확인하는 정규식
     */
    private static final String ONLY_NUMBER = "^[0-9]+$";
    /**
     * 1부터 45사이 숫자인지 확인하는 정규식
     */
    private static final String VALID_LOTTO_NUMBER_PATTERN = "^[1-9]|[1-3][0-9]|4[0-5]+$";
    /**
     * 콤마로 구분된 1부터 45사이 숫자 6개의 로또 형식을 확인하는 정규식
     */
    private static final String VALID_LOTTO_LIST_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5]),(?:[1-9]|[1-3][0-9]|4[0-5])$";

    /**
     * 총 로또 구매 가격을 입력받는 메서드
     * @return totalPrice(총 구매 가격)
     */
    public int receiveTotalPrice() {
        while (true) {
            String input = Console.readLine();

            if (!input.matches(ONLY_NUMBER)) {
                System.out.println(InputExceptionMessage.INVALID_PRICE_TYPE);
                continue;
            }

            int totalPrice = Integer.parseInt(input);

            if (totalPrice % LOTTO_PRICE != 0) {
                System.out.println(InputExceptionMessage.INVALID_PRICE);
                continue;
            }
            return totalPrice;
        }
    }

    /**
     * 1등 로또 번호(당첨번호)를 입력받는 메서드
     * @return {@link Lotto} 1등 당첨번호
     */
    public Lotto receiveLottoWinning() {
        while (true) {
            String input = Console.readLine();

            if (!input.matches(VALID_LOTTO_LIST_PATTERN)) {
                System.out.println(InputExceptionMessage.INVALID_LOTTO_NUMBERS);
                continue;
            }

            Optional<List<Integer>> optionalList = getValidWinningList(input);
            if (optionalList.isEmpty()) {
                continue;
            }

            return new Lotto(optionalList.get());
        }
    }

    /**
     * 보너스 번호를 입력받는 메서드
     * @param lotto {@link Lotto} 1등 당첨 번호와 중복 방지를 위해 확인
     * @return 보너스 번호
     */
    public int receiveBonusNumber(Lotto lotto) {
        while (true) {
            String input = Console.readLine();
            if (!input.matches(VALID_LOTTO_NUMBER_PATTERN)) {
                System.out.println(InputExceptionMessage.INVALID_BONUS_NUMBER);
                continue;
            }
            int num = Integer.parseInt(input);

            if (lotto.getNumbers().contains(num)) {
                System.out.println(InputExceptionMessage.DUPLICATED_BONUS_NUMBER);
                continue;
            }

            return num;
        }
    }

    /**
     * 로또 번호의 중복을 확인하는 메서드
     * @param input {@link lotto.view.InputView#VALID_LOTTO_LIST_PATTERN} 형식의 로또 번호
     * @return {@literal Optional<List<Integer>>} 형식의 유효한 로또 번호 리스트
     */
    private static Optional<List<Integer>> getValidWinningList(String input) {
        List<Integer> winningList = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .sorted(Integer::compare)
                .toList();

        long uniqueLength = winningList.stream().distinct().count();

        if (winningList.size() != uniqueLength) {
            System.out.println(InputExceptionMessage.INVALID_LOTTO_DUPLICATED);
            return Optional.empty();
        }
        return Optional.of(winningList);
    }
}
