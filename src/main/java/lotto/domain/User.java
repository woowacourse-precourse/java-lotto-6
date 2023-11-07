package lotto.domain;

public class User { //유저의 돈

    public static Integer PaperNumber(Integer input) {
        MoneyValidate(input);
        Integer paper = input / 1000;
        System.out.println(paper + "개를 구매했습니다.");
        return paper;
    }

    public static void MoneyValidate(Integer input) {
        if (input <= 0) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (input % 1000 != 0) {
            System.out.println("[ERROR] 1,000 단위로만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
