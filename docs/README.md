# 🎱 로또

## Model(Lotto)
- [ ] 로또 번호 랜덤
- [ ] 로또 번호 정렬
 
## View
#### - InputView
- [ ] 몇 장 구매할 지 입력
- [ ] 로또 번호 입력 6개
- [ ] 보너스 번호 입력

#### - OutputView
- [ ] 발행한 로또 수량 출력
- [ ] 발행한 로또 번호 출력
- [ ] 당첨 내역 출력
- [ ] 수익률 출력

##  Message(enum)
#### - ErrorMessage 
- [ ] 에러 메세지를 담고 있는 Enum

#### - InputViewMessage
- [ ] 입력 메세지를 담고 있는 Enum

#### - OutputViewMessage
- [ ] 출력 메세지를 담고 있는 Enum

## Controller
#### - InputValidator
- [ ] 공백
- [ ] 음수
- [ ] 1~45가 아닌 경우
- [ ] 쉼표 아닌 경우
- [ ] String
- [ ] 6개가 아닌 경우
- [ ] 1000원 단위가 아닌 경우

#### - CompareLottoNumbers
- [ ] 몇 개 맞았는지 비교
- [ ] 몇 등 짜리 몇 개

#### - ProfitRate
- [ ] 수익 총 계산 (add)
- [ ] 수익률 계산 (divide)

#### -LottoGame 
- [ ] 모두 합치는 기능