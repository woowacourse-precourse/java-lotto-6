package lotto.dto.input;

public class GetLottoCountDto {
    private final int count;

    public GetLottoCountDto(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
