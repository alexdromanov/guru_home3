import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomeTest3 {

    @Test
    void shouldFindGithub() {
        Configuration.startMaximized = true;

        open("https://github.com/");
        $("[name=q]").setValue("Selenide").pressEnter();
        $("[data-search-type=Wikis]").click();
        $("[id=wiki_search_results]").shouldHave(Condition.text("SoftAssert"));
        $("[title=SoftAssertions]").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class")).shouldBe(Condition.visible);


    }
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

}
