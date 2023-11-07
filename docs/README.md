# 기능 구현 목록
## View
### Input View
- [x] 구입 금액 입력 받기 - 숫자를 입력받지 않으면 예외 발생 (inputMoney)
- [x] 당첨 번호 입력 받기 - 숫자를 입력받지 않으면 예외 발생 (inputWinningNumbers)
- [x] 보너스 볼 입력 받기 - 숫자를 입력받지 않으면 예외 발생 (inputBonusNumber)
### Output View
- [ ] 구입한 로또 갯수 출력
- [ ] 구입한 로또 번호 출력
- [ ] 당첨 통계 출력 - 3개 일치, 4개 일치, 5개 일치, 5개 일치 + 보너스 볼 일치, 6개 일치, 수익률
## Model(domain)
- 로또 번호 (LottoNumber)
  - [x] 로또 번호는 1 ~ 45 사이의 숫자 (validate)
  - [x] 로또 번호는 중복되지 않는다. (validateDistinct)
  - [x] 로또 번호가 몇개 일치하는지 확인 (matchNumbers)
  - [x] 로또 보너스 번호가 포함되어있는지 확인 (containsBonusNumber)
  - [x] 로또 번호 문자열 반환 (toString)
- 로또 (Lotto)
  - [x] 로또는 6개의 로또 번호를 가진다. (validate)
  - [x] 로또 번호 비교 (matchNumbers)
  - [x] 로또 보너스 번호 비교 (containBonusNumber)
  - [x] 로또 번호 문자열 반환 (toString)
- 로또 금액 (LottoMoney)
  - [x] 로또 금액은 1000 미만일 수 없다. (validate)
  - [x] 로또 금액에 맞는 로또 구매 갯수 반환 (getLottoCount)
- 로또 생성기 (LottoFactory)
  - [x] 로또를 생성 (createLotto) 
- 로또 리스트 (Lottos)
  - [x] 로또 리스트와 당첨 로또를 비교한다. (matchAllLotto)
  - [x] 로또 리스트를 반환한다
- 로또 결과 (LottoResult)
  - [x] 수익률 계산 (getProfitRate)
  - [x] 당첨금 계산 (getWinningMoney)
  - [x] 특정 등수의 개수를 반환 (countRank)
- 당첨 등수 (Rank)
 - [x] 등수 계산 (from)
 - [x] 등수에 맞는 당첨금 반환 (getWinningMoney)
 - [x] 등수에 맞는 번호 갯수 반환 (getMatchCount)
 - [x] 등수에 맞는 보너스 번호 일치 여부 반환 (getMatchBonusNumber)
 - [x] 당첨 번호 갯수와 보너스 번호 일치 여부를 가지고 당첨 결과 확인 (match)
- 당첨 로또
  - [x] 사용자에게 당첨 번호와 보너스 번호를 입력받아 당첨 로또를 생성한다. (WinningLotto)
  - [x] 당첨 로또와 로또를 비교한다. (match)
## Controller
- [ ] 로또 게임 진행 - 구입 금액, 당첨 번호, 보너스 볼을 입력받아 로또 게임을 진행