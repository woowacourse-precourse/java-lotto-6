package lotto;

public enum ExceptionMessage {

    로또_구입_비용_천원단위가아닌경우("로또를 구매비용은 천원 단위입니다."),
    로또_구입비용_숫자가아닐때("로또 구매비용을 정수로 입력해야합니다."),
    로또_비용_int_최대단위를넘긴경우("로또 구매비용은 최대 2,147,483,647원까지입니다."),
    당첨번호_중복("로또 번호는 중복될 수 없습니다."),
    보너스번호가_숫자가아닐때("보너스 번호를 1~45로 입력해야합니다."),
    보너스번호_중복("보너스번호는 당첨번호와 중복될 수 없습니다."),
    당첨번호_1_45_사이가아닌경우("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    당첨번호_6개가아닌경우("당첨번호는 1~45의 숫자로, 중복없이 6개만을 입력할 수 있습니다."),
    보너스번호_1개가아닌경우("보너스 번호를 하나 입력해야합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
