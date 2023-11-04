# 미션-로또

## 🔍 Class

|     Class      |       역할        | 속성                      | 타입            |
|:--------------:|:---------------:|:------------------------|:--------------|
|     Lotto      |     로또 클래스      | numbers : 로또번호          | List<Integer> |
|     Human      | Lotto를 갖고있는 클래스 | Lottos : 로또번호 리스트       | List<Lotto>   |
|                |                 | budget : 사용자의 예산        | Long          |
|                |                 | winningResult : 당첨된 내역  | EnumMap       |
|   LottoDraw    |  로또 회차에 대한 정보   | winningLotto : 당첨된 로또번호 | Lotto         |
| LottoGenerator | 로또 번호를 생성하는 클래스 | numbers: 1~45를 갖고있는 리스트 | List<Integer> |

## 🔢 Enum
| Enum        | 역할                  | 속성                                                              |
|-------------|---------------------|-----------------------------------------------------------------|
| WinningType | 로또의 결과를 Enum 으로 나타냄 | FIFTH_PLACE,FORTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE |