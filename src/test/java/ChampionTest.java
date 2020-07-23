import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();
    private List<Champion> agentList = new ArrayList<Champion>();

    @Before //@Before 다른 메소드가 실행 되기 전에 먼저 실행 된다.
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        Champion strikeAgent = new Champion("레이즈", "타격대");
        Champion scoutAgent = new Champion("브리치", "척후대");
        Champion supportAgent = new Champion("세이지", "지원가");
        Champion strategistAgent = new Champion("브림스톤", "전략가");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);

        agentList.add(strikeAgent);
        agentList.add(scoutAgent);
        agentList.add(supportAgent);
        agentList.add(strategistAgent);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
        assertTrue(emptyList.size() == 0);
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());
        assertFalse(lck == "");
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
        assertTrue(lck == null);
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";

        assertThat(sampleString1, anything());
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString2, is(endsWith(endString)));
        assertThat(sampleString2, anyOf(startsWith(startString), containsString(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(3, 0.2));
        assertThat(3.143, closeTo(3, 0.2));
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(2), anything()); //anything() <- 값의 존재 유무 파악
        assertThat(agentList.get(1), anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {

        assertTrue(championList.size() == 5);
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5)); //hasSize() 해당 리스트의 개수를 파악

        assertThat(agentList.size(), is(4));
        assertThat(agentList, hasSize(4));
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        Champion supportChamp1 = new Champion("카이사", "바텀");

        assertThat("타릭", is(supportChamp.getName()));
        assertTrue(supportChamp.getName().equals("타릭"));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));

        assertThat("카이사", is(supportChamp1.getName()));
        assertTrue(supportChamp1.getName().equals("카이사"));
        assertThat("바텀", is(supportChamp1.getPosition()));
        assertTrue(supportChamp1.getPosition().equals("바텀"));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트 -> Property는 객체 안의 데이터가 있는지 확인
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(2), hasProperty("name"));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        assertThat(championList.get(2), hasProperty("name", equalTo("르블랑")));

        System.out.println("champion :: " + championList.get(0));
        System.out.println("champion :: " + championList.get(2));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");

        assertThat(champListNames.get(0), hasToString("루시안"));
        assertTrue(champListNames.get(2).equals("렉사이"));
        assertThat(champListNames.get(3), hasToString("갈리오"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> valorantNames1 = Arrays.asList("브림스톤", "레이나", "피닉스", "제트", "세이지");
        List<String> valorantNames2 = Arrays.asList("브림스톤", "레이나", "피닉스", "제트", "세이지");

        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames1.get(1), equalTo(championNames2.get(1)));
        assertThat(valorantNames1, samePropertyValuesAs(valorantNames2));
        assertThat(valorantNames1.get(3), equalTo(valorantNames2.get(3)));

        System.out.println("champion :: " + championNames1.get(1));
        System.out.println("champion :: " + valorantNames1.get(3));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("바텀"))
                .findFirst();

        String champName = filterdChampion.get().getName();
        String champPosition = filterdChampion.get().getPosition();

        assertTrue(champName.equals("베인"));
        assertTrue(champPosition.equals("바텀"));

        assertThat(champPosition, is("바텀"));
        assertThat("베인", is(champName));
    }
}