package action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.Service;

public interface Action {
    Service service = Service.getInstance();
    Logger logger = LoggerFactory.getLogger(Action.class) ;

    void execute();
}