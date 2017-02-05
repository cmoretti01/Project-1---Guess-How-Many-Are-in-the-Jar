import java.util.Random;

public class Jar {
    private String mItem;
    private int mAmount;
    private int mMaxAmount;

    public Jar(String item, int amount) {
        mItem = item;
        mAmount = amount;
    }

    public void fillJar(int number){
        Random random = new Random();
        mAmount = random.nextInt(number);
    }

    public String getItem() {
        return mItem;
    }

    public int getAmount() {
        return mAmount;
    }

    public int getMaxAmount() {
        return mMaxAmount;
    }

}
