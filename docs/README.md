# 기능 목록

## 기능
- [x] 구입 금액 입력 (OrderView.askOrderPrice)
- [ ] 개수만큼 로또 생성
- [x] 랜덤으로 만들어진 로또 보여줌 (OrderView.printOrderLottos)
  - [x] 로또를 출력할 때, 형식을 잡아줌 (Lotto.toString)
- [x] 당첨 번호 입력 (LottoView.askLottoNumbers)
- [x] 보너스 번호 입력 (LottoView.askBonusNumber)
- [ ] 생성된 로또의 결과 계산
- [ ] 결과를 종합하여 당첨 통계 생성
- [ ] 당첨 통계를 통해 수익률 계산
- [x] 입력을 검증 (InputValidator)
  - [x] 구입 금액 (validateOrderPrice)
    - [x] 숫자로 이루어져야 함
    - [x] 1000원 단위로 나누어져야 함
  - [x] 로또 번호 (validateLottoNumbers)
    - [x] 쉼표(,)로 구분된 6개의 수
    - [x] 각 수는 1부터 45의 수
  - [x] 보너스 번호 (validateBonusNumber)
    - [x] 1부터 45의 수 범위의 수여야 함

## 추가적인 요구 사항
- [x] Enum을 사용하기
  - Enum을 사용하여 로또의 결과를 나타냄 (LottoResult)
- [ ] 단위 테스트 진행