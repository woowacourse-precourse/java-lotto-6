## 🚀 구현 기능 목록 ▶ 로또

### * 로또 시작

#### * 로또 구입 금액 입력 기능 생성
##### [ 예외처리 ]
###### → 구입 금액이 1000원 단위가 아닌 경우

#### * 당첨 번호 입력 기능 생성
##### [ 예외처리 ]
###### → 각 번호가 쉼표로 구분되지 않은 경우
###### → 6개의 숫자를 입력하지 않은 경우
###### → 입력 번호에 중복된 숫자가 있는 경우
###### → 입력 숫자가 1~45 사이에 없는 경우

#### * 보너스 번호 입력 기능
##### [ 예외처리 ]
###### → 입력 숫자가 1~45 사이에 없는 경우
###### → 당첨 번호와 중복되는 경우

### * 로또 번호 일치 확인
### * 수익률 계산 및 출력

## <class 정리>

(class) Application

(class) Lotto
validate(): 예외 처리

(class) WinLotto
inputWinNum(): 당첨 번호 입력
setWinLotto(): 당첨 로또 설정
inputBonus(): 보너스 번호 입력

(class) UserData
money
inputMoney(): 금액 입력
validateMoney(): 금액에 대한 예외 처리
lottoCount
setLottoCount(): 로또 개수 설정
userLotto
getRandomLotto(): 로또 번호 랜덤 설정
setUserLotto(): 로또 수 만큼 로또 생성
returnRate
calculateReturnRate(): 수익률 계산
lottoResult
checkLotto(): 로또 번호 몇 개 맞추었는 지 확인
checkRank(): 등수 확인