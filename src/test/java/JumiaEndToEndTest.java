import mainHandler.Handler;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;

public class JumiaEndToEndTest extends Handler {
    @Test
    public void loginTestUsingEmail(){
        HomePageEvents.verifyJumiaOpens();
    }
}
