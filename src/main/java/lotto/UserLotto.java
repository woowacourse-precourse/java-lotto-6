package lotto;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserLotto {
    private List<Integer> userNum;

    public void inputLotto() {
        String userNumString = Console.readLine();
        String[] userNumStringList = userNumString.split(",");

        for (int i = 0; i < userNumStringList.length; i++) {
            userNum.add(Integer.parseInt(userNumStringList[i]));
        }
        validate(userNum);
    }

    private void validate(List<Integer> userNum) {
        //6개의 숫자가 아닐 때
        if (userNum.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력하세요.");
        }
        //수가 중복될 때
    }
}
