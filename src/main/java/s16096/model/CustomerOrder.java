package s16096.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CustomerOrder {
    private long orderId;
    private boolean isDone = false;
    private ArrayList<String> orderedPizzas;
    private LocalDateTime executionTime;
    private LocalDateTime modernizeTime;
    private LocalDateTime lastReadingTime;
    private Customer customer;
    private boolean recordTimes;

    public CustomerOrder(){

    }

    public CustomerOrder(long id, ArrayList<String> orderedPizzas) {
        this.orderId = id;
        this.isDone = false;
        this.orderedPizzas = orderedPizzas;
        this.executionTime = LocalDateTime.now();
        this.modernizeTime = LocalDateTime.now();
        this.recordTimes = true;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public ArrayList<String> getOrderedPizzas() {
        return orderedPizzas;
    }

    public void setOrderedPizzas(ArrayList<String> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }

    public LocalDateTime getExecutionTime() { return executionTime; }

    public void setExecutionTime(LocalDateTime executionTime) { this.executionTime = executionTime; }

    public LocalDateTime getModernizeTime() { return modernizeTime; }

    public void setModernizeTime(LocalDateTime modernizeTime) { this.modernizeTime = modernizeTime; }

    public LocalDateTime getLastReadingTime() { return lastReadingTime; }

    public void setLastReadingTime(LocalDateTime lastReadingTime) { this.lastReadingTime = lastReadingTime; }

    public boolean isRecordTimes() { return recordTimes; }

    public void setRecordTimes(boolean recordTimes) { this.recordTimes = recordTimes; }

@Override
public String toString() {
    return "Customer Order{" +
            "id=" + orderId +
            ", isDone" + isDone +
            ", orderedPizzas" + orderedPizzas +
            ", executionTome" + executionTime +
            ", modernizeTime" + modernizeTime +
            ", lastReadingTime" + lastReadingTime +
            ", recordTimes" + recordTimes +
            '}';

    }

}
