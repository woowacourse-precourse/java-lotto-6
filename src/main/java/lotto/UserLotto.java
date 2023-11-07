package lotto;

import static org.mockito.ArgumentMatchers.intThat;

import camp.nextstep.edu.missionutils.Console;

public class UserLotto {
    private List<Integer> userNum;

    public void inputLotto() {
        String userNumString = Console.readLine();
        String[] userNumStringList = userNumString.split(",");

        for (int i = 0; i < userNumStringList.length; i++) {
            userNum.add(Integer.parseInt(userNumStringList[i]));
        }
    }
}
