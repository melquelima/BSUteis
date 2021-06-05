import com.automationanywhere.botcommand.samples.commands.basic.Start;
import org.testng.annotations.Test;
import com.automationanywhere.botcommand.data.impl.StringValue;

public class GlobalVarsTest {
    @Test
    public void teste(){
        Start a = new Start();
        StringValue date = a.action("37001056000170");
        System.out.println("==================");
        System.out.println("Expected First Value: " + date);
    }
}