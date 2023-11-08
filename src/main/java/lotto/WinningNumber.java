package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public WinningNumber(){

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
}
