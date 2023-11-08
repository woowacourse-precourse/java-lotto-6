package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public int getNumberOfLotto(){
        System.out.println("구입금액을 입력해 주세요.\n");

        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);

        int numberOfLotto = calculate(money);
        return numberOfLotto;
    }

    private void validateMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE+" 로또는 1000원 단위로 구매가 가능합니다.");
        }
    }

    public List<Integer> getWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> numbers = Arrays
                .stream(Console.readLine().split(","))
                .map(number-> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());

        checkWinningNumberSize(numbers);
        checkSameNumberInWinningNumber(numbers);

        return numbers;
    }

    private void checkWinningNumberSize(List<Integer> numbers){
        if(numbers.size() > 6 || numbers.size() < 6){
            throw new IllegalArgumentException(ERROR_MESSAGE +" 당첨 번호는 총 6개로 이루어져 있습니다.");
        }
    }

    private void checkSameNumberInWinningNumber(List<Integer> numbers){
        boolean[] visited = new boolean[46];

        for(int i=0;i<6;i++){
            if(!visited[numbers.get(i)]){
                visited[numbers.get(i)] = true;
                continue;
            }

            throw new IllegalArgumentException(ERROR_MESSAGE+" 중복된 당첨 번호가 있습니다.");
        }
    }

    private int calculate(int money){
        return money / 1000;
    }
}
