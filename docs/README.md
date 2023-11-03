## 주요 기능

### `Lotto.java`
- [ ] 6개의 숫자 List 변수 저장
- [ ] 해당 숫자가 유효한지 검증

### `LottoResultDTO`
- [ ] 로또 결과를 저장하는 DTO
- [ ] `LottoPrompt`에서 해당 DTO 출력

### `LottoGame.java`
- [ ] 중복되지 않는 6개 숫자 조합 생성 요구 (`LottoUtil`호출)
- [ ] N개의 Lotto 클래스 List 형태로 저장 로직
- [ ] 결과인 `LottoResultDTO`를 출력 요구 로직
- [ ] 이외 입출력들 요구 로직
 
### `LottoUtils.java`
- [ ] 중복되지 않는 6개의 숫자 조합 생성 로직
- [ ] 당첨번호와 로또번호 비교하는 로직
  - [ ] 비교 후, 결과를 `LottoResultDTO`에 저장하는 로직

## 입출력

### `LottoPrompt.java`
- [ ] 잘못된 입력시 예외 발생