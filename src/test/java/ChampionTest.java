import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

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

        assertThat(emptyList, empty());             //by LeeDongHun
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";

        assertThat(lck, notNullValue());            //by LeeDongHun
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;

        assertThat(lck, nullValue());               //by LeeDongHun
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString1, allOf(startsWith(startString), endsWith("Focus")));    // by KimDoHyun
        assertThat(sampleString2,anyOf(startsWith("flayer"),endsWith(endString)));      //by LeeDongHun

    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {

        assertThat(3.14, closeTo(3.5, 0.4));     //by LeeDongHun
        assertThat(4.256,closeTo(4.260,0.01));   //by JooJaeLin
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {

        assertThat(championList.get(4), anything());                    //by LeeDongHun

    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {

        assertThat(championList, hasSize(5));                            //by LeeDongHun
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");

        assertThat("타릭",equalTo(supportChamp.getName()));       //by LeeDongHun
    }

    //서폿 챔피언의 포지션이 탑이고 대소문자 상관 없는지 테스트 코드 작성
    @Test
    public void shouldSupportChampionPositionIsTop(){
        Champion supportChamp = new Champion("다리우스","Top");

        assertThat("TOP",equalToIgnoringCase(supportChamp.getPosition()));
    }   //by JooJaeLin


    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {

        assertThat(championList.get(1), hasProperty("name", equalTo("리신")));    //by KimDoHyun
        assertThat(championList.get(3),hasProperty("position",equalTo("바텀")));                  //by LeeDongHun
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");

        assertThat(champListNames.get(5), hasToString("블라디미르"));    //by KimDoHyun
        assertThat(champListNames.get(3), hasToString("갈리오"));                                    //by LeeDongHun
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");


        assertThat(championNames1, samePropertyValuesAs(championNames2));               //by LeeDongHun
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {

        Optional<Champion> filterdChampion = championList.stream()                      //Bring champion in championStream optionally
                .filter(c -> c.getPosition().equals("바텀"))                            //Filter object whose position is "바텀"
                .findFirst();                                                           //Bring first object
        System.out.println("result ::" + filterdChampion);
        String champName = filterdChampion.get().getName();
        assertThat("베인", is(champName));                                        //by LeeDongHun

    }

}