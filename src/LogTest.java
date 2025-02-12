import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
    private static Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.info("INFO 레벨 메시지");
    }
}