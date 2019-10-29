package s16096.model;

import java.time.LocalDateTime;
import java.util.Date;

public class CustomerOrderDate  {
    private LocalDateTime executionTime;
    private LocalDateTime modernizeTime;
    private LocalDateTime lastReadingTime;

    public CustomerOrderDate() {

    }

    public CustomerOrderDate(LocalDateTime executionTime, LocalDateTime modernizeTime, LocalDateTime lastReadingTime) {
        this.executionTime = executionTime;
        this.modernizeTime = modernizeTime;
        this.lastReadingTime = lastReadingTime;
    }


    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public LocalDateTime getModernizeTime() {
        return modernizeTime;
    }

    public LocalDateTime getLastReadingTime() {
        return lastReadingTime;
    }
}


