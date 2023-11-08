package View;

import java.util.ArrayList;
import java.util.List;

public class TextView {
    public void inputPrice() {
        System.out.print("구입금액을 입력해 주세요.\n");
    }

    public void inputPrizeNum() {
        System.out.print("당첨 번호를 입력해 주세요.\n");
    }

    public void inputBonusNum() {
        System.out.print("보너스 번호를 입력해 주세요.\n");
    }

    public List<String> prizeDetails() {
        List<String> prize;
        prize = List.of(
                "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - ");
        return prize;
    }
}
