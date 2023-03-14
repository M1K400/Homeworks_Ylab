package RateLimitedPrinter.repository;

public class RateLimitedPrinterImpl implements RateLimitedPrinter {

    private int interval;

    private int complete_interval = 0;

    private boolean isLocked = false;

    public RateLimitedPrinterImpl(int interval) {
        this.interval = interval;
    }

    @Override
    public void print(String message) {
        if (isLocked && complete_interval >= interval){
            isLocked = false;
            complete_interval = 0;
        } else if (!isLocked) {
            isLocked = true;
            System.out.println(message);
        }
        complete_interval++;
    }


}
