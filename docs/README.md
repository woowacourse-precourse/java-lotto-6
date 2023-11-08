# 💸 로또

### 로또 구입 금액 입력 ✅ 
K * 1000원  K개 구매 [✔️]
- 정수가 아닌 입력이면 예외처리 [✔️]

구입금액 객체 생성 [✔️]
- 1000원 단위가 아니면 예외처리 [✔️] 
### 발행한 로또 수량 및 번호 출력 ✅
K개 구매 : 
로또 객체 생성 [✔️]
- 발행한 로또의 숫자 개수가 6이 아니면 예외처리 [✔️]
- 발행한 로또의 번호가 1~45를 벗어나면 예외처리 [✔️]
- 발행한 로또의 번호가 중복된 번호면 예외처리 [✔️]
### 당첨 번호 입력 ✅
6개 숫자, 각 숫자의 범위는 1~45, 구분은 쉼표(,)로
  - 정수가 아닌 입력이면 예외처리 [✔️]
  - 쉼표가 없으면 예외처리 [✔️]

우승 번호 객체 생성 [✔️]
  - 우승 번호 숫자 개수가 6이 아니면 예외처리 [✔️]
  - 우승 번호가 범위를 벗어나면 예외처리 [✔️]
  - 중복된 우승 번호가 있으면 예외처리 [✔️]
### 보너스 번호 입력 ✅
- 정수가 아니면 예외처리 [✔️]

보너스 번호 객체 생성 [✔️]
- 우승 번호와 겹치면 예외처리 [✔️]
- 범위를 벗어나면 예외처리 [✔️]

### 결과 출력 ✅
영수증 객체 생성 [✔️]
3개 ~ 6개 일치 개수 별로 출력 [✔️]
- 5등 부터 1등 까지 [✔️]
수익률 출력 [✔️]

### 예외 처리 ✅
- 예외 상황 시 에러 문구를 출력 [✔️] 
- 에러 문구는 "[ERROR]"로 시작 [✔️]
- 에외 입력시 에러 문구 출력하고 재 입력 [✔️]


-----

## 📁 폴더링

### ⚙️ configurations
- SettingValue : 로또에 필요한 설정 값들
- Messages : 로또 프로그램 실행 시 출력되는 메시지들
- LottoConfigurations : 로또 프로그램 실행 시 필요한 환경설정 값들
- ErrorMessages : 로또 프로그램 실행 중 예외 발생 시 출력되는 메시지들

### 💾 model
- Lotto : 로또 객체
- PurchaseAmount : 구매 금액
- UserLottos : 사용자가 구매한 로또의 집합
- WinningNumbers : 당첨 번호
- BonusNumber : 보너스 번호
- Receipt : 로또 영수증

### 🖥️ view
- InputView : 입력기 (singleton)
- OutputVies : 출력기 (singleton)

### 🎮 controller
- LottoController : 사용자가 로또를 구매하게 하는 클래스 (singleton)
- ReceiptController : 사용자에게 결과를 보여주는 클래스 (singleton)

### 🔑 service
- LottoService : 로또를 실제로 생성하는 클래스 (singleton)
- ReceiptService : 결과를 생성하는 클래스 (singleton)
### 🗄️ repository
- LottoRepository : 생성한 로또를 저장하는 클래스 (singleton)
- ReceiptRepository : 생성한 결과를 저장하는 클래스 (singleton)

### 🛠️ util
- NumberConverter : 출력형식에 맞게 String 으로 바꿔주는 클래스


