# 미션-로또

## 🔍 Class

### APP

| CLASS        | 역할                     | 속성              |
|--------------|------------------------|-----------------|
| LottoView    | 콘솔에 표기되는 내용을 출력하는 View ||
| LottoConsole | 사용자가 콘솔에 입력하는 것을 담당    |                 |
| LottoApp     | View와 Console을 총 담당    | LottoView       |
|              |                        | LottoConsole    |
|              |                        | LottoController |

### Controller

| CLASS           | 역할                         | 속성           |
|-----------------|----------------------------|--------------|
| LottoController | View 에서 Request 한 내용을 반환해줌 | Human        |
|                 |                            | WinningLotto |

### Domain

|     Class      |       역할        | 속성                           | 타입            |
|:--------------:|:---------------:|:-----------------------------|:--------------|
|     Lotto      |     로또 클래스      | numbers : 로또번호               | List<Integer> |
|     Human      | Lotto를 갖고있는 클래스 | Lottos : 로또번호 리스트            | List<Lotto>   |
|                |                 | budget : 사용자의 예산             | Long          |
|                |                 | winningResult : 당첨된 내역       | EnumMap       |
|  WinningLotto  |     당첨된 로또      | normalNumbers : 보너스번호가 아닌 번호 | List<Integer> |
|                |                 | bonusNumber: 보너스번호           | int           |
|   LottoDraw    |  로또 회차에 대한 정보   | winningLotto : 당첨된 로또번호      | WinningLotto  |

### Enum

| Enum        | 역할                  | 속성                                                               |
|-------------|---------------------|------------------------------------------------------------------|
| WinningType | 로또의 결과를 Enum 으로 나타냄 | FIFTH_PLACE, FORTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE |

### RandomGenerator

|     Class      |       역할        | 속성                           | 타입            |
|:--------------:|:---------------:|:-----------------------------|:--------------|
| LottoGenerator | 로또 번호를 생성하는 클래스 | numbers: 1~45를 갖고있는 리스트      | List<Integer> |