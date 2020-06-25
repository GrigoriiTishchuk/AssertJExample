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
        window.textBox("SubStr").enterText("ddd");
        window.button("buttonSS").click();
        window.button("buttonSearch").click();
        window.textBox("Res").requireText("{}");
    }
    
    @Test
    public void Test2() {
        window.button("buttonSearch").requireDisabled();
    }
    
    

    @After
    public void tearDown() {
        window.cleanUp();
    }

}
