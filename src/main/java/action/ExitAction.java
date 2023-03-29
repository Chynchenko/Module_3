package action;

import java.time.LocalDateTime;

public class ExitAction implements Action {
    @Override
    public void execute() {
        logger.info("ExitAction was called. Time: " + LocalDateTime.now());
        System.out.println("Bye!");
        System.exit(0);
    }
}