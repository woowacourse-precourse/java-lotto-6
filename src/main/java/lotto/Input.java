package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int purchase(){
        System.out.println("구입금액을 입력해 주세요.\n");
        int input = Integer.parseInt(Console.readLine());
        return input;
    }
}
