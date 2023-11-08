package lotto.adapter;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.port.InputPort;

public class UserInputAdaptor implements InputPort {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_DRAW_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    @Override
    public Integer readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine();


        // TODO: 유효성 검사 로직 추가

        return Integer.parseInt(input);
    }

    @Override
    public List<Integer> readDrawNumbers() {
        System.out.println(INPUT_DRAW_NUMBERS);
        String input = Console.readLine();

        // TODO: 유효성 검사 로직 추가

        return Arrays.stream(input.replaceAll(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Integer readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();

        // TODO: 유효성 검사 로직 추가


        return Integer.parseInt(input);
    }
}
