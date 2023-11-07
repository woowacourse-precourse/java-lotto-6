## 기능 목록
- [x] 로또 구입 금액 입력
  - [x] Exception: 1000원 단위가 아닐 시
- [x] 사용자 로또 설정 
- [ ] 당점 번호 입력
  - [ ] Exception: 쉼표로 구분되지 않는 경우
  - [ ] Exception: 6개의 숫자를 입력받지 않는 경우
  - [ ] Exception: 중복 되는 숫자가 있는 경우
  - [ ] Exception: 숫자의 범위가 1 ~ 45가 아닌 경우
- [ ] 보너스 번호 입력
  - [ ] Exception: 숫자의 범위가 1 ~ 45가 아닌 경우
  - [ ] Exception: 당첨 번호와 중복 되는 경우
- [ ] 로또 번호 일치 확인
- [ ] 수익률 계산


## 어떻게 구현할 것인가
<요구사항>
- [ ] 클래스 분리
- [ ] 도메인 로직에 대한 단위 테스트 작성
- [ ] 함수의 길이가 15라인을 넘지 않도록
  - 한 함수가 한 가지 기능만 담당하도록
- [ ] else 사용 X
- [ ] Java Enum 적용
  

- (class) Application
  
- (class) Lotto
  - validate(): 예외 처리
  
- (class) WinLotto
  - inputWinNum(): 당첨 번호 입력
  - inputBonus(): 보너스 번호 입력
  
- (class) UserData
  - money
    - inputMoney(): 금액 입력
    - validateMoney(): 금액에 대한 예외 처리
  - lottoCount
    - setLottoCount(): 로또 개수 설정
  - userLotto
    - getRandomLotto(): 로또 번호 랜덤 설정
    - setUserLotto(): 로또 수 만큼 로또 생성
  - returnRate
    - calculateReturnRate(): 수익률 계산
  - lottoResult
    - checkLottoNum(): 로또 번호 몇 개 맞추었는 지 확인
    - checkRank(): 등수 확인