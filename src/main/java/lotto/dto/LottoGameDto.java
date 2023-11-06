package lotto.dto;

public class LottoGameDto {
    public static class Response{
        private final Long lottoGameId;

        public Response(Long lottoGameId) {
            this.lottoGameId = lottoGameId;
        }

        public Long getLottoGameId() {
            return lottoGameId;
        }
    }

}
