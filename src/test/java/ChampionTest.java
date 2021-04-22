import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertTrue(emptyList.isEmpty());
        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
    }

    //문자열 관련 테스트 anyOf, containsString, endWith, startWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";

//        assertThat(sampleString1, anyOf(notNullValue(), containsString("Focus")));
//        assertThat(sampleString2, containsString("yer"));
//        assertThat(startString, endsWith("yer"));
//        assertThat(endString, startsWith("po"));

        // anyOf 안에 포함된 조건들 중 하나라도 pass하면 ok
//        assertThat(sampleString1, startsWith("Player"));
//        assertThat(sampleString2, endsWith("point"));
//        assertThat(sampleString1, containsString("Fo"));
        assertThat(sampleString1, anyOf(startsWith("Player"), endsWith("focus")));
//        assertThat(sampleString2, allOf(startsWith("Player"), endsWith("point"), containsString("11")));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        double testDouble = 3.141592;
        assertThat(testDouble, closeTo(3, 0.2));
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        System.out.println("champion info :: " + championList.get(0));
        assertThat(championList.get(0), anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertThat(championList, hasSize(5));
    }

    //타릭 챔피언 객체를 만들고 이름과 포지션을 검증하세요.
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "서폿");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", equalTo(supportChamp.getName()));
        assertThat("서폿", equalTo(supportChamp.getPosition()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(1), hasProperty("name"));
        assertThat(championList.get(2), hasProperty("position", equalTo("미드")));
        System.out.println("champion :: " + championList.get(2));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(champListNames.get(1), hasToString("애쉬"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> champArray = championNames1;

        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames1, samePropertyValuesAs(champArray));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filteredChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();

        assertThat(filteredChampion.get().getName(), is("다리우스"));
        System.out.println("champ :: " + filteredChampion);
        assertTrue(filteredChampion.get().getPosition().equals("탑"));
    }

}