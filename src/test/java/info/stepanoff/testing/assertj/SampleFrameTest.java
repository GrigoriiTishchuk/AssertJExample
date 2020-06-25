package info.stepanoff.testing.assertj;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SampleFrameTest {

    private FrameFixture window;

    @Before
    public void setUp() {
        SampleFrame frame = GuiActionRunner.execute(() -> new SampleFrame());
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }

    
    @Test
    public void Test1() {
        window.textBox("MainStr").enterText("hushers");
        window.textBox("SubStr").enterText("hu");
        window.button("buttonSS").click();
        window.textBox("SubStr").enterText("she");
        window.button("buttonSS").click();
        window.textBox("SubStr").enterText("hers");
        window.button("buttonSS").click();
        window.button("buttonSearch").click();
        window.textBox("Res").requireText("{1=[0], 4=[1], 6=[2]}");
    }
    
    @Test
    public void Test2() {
        window.textBox("MainStr").enterText("hushers");
        window.textBox("SubStr").enterText("ddd");
        window.button("buttonSS").click();
        window.button("buttonSearch").click();
        window.textBox("Res").requireText("{}");
    }
    
    @Test
    public void Test3() {
        window.button("buttonSearch").requireDisabled();
    }
    
    @Test
    public void Test4() {
        window.textBox("MainStr").enterText("hushers");
        window.textBox("SubStr").enterText("ddd");
        window.button("buttonSS").click();
        window.button("buttonSearch").click();
        window.button("buttonCancel").click();
        window.textBox("MainStr").requireText("");
        window.textBox("SubStr").requireText("");
    }
    
    @Test
    public void Test5() {
        window.textBox("MainStr").enterText("hushers");
        window.textBox("SubStr").enterText("ddd");
        window.button("buttonSS").click();
        window.button("buttonSearch").click();
        window.textBox("Res").requireText("{}");
        window.button("buttonCancel").click();
        window.textBox("MainStr").enterText("hushers");
        window.textBox("SubStr").enterText("hu");
        window.button("buttonSS").click();
        window.textBox("SubStr").enterText("she");
        window.button("buttonSS").click();
        window.textBox("SubStr").enterText("hers");
        window.button("buttonSS").click();
        window.button("buttonSearch").click();
        window.textBox("Res").requireText("{1=[0], 4=[1], 6=[2]}");
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
