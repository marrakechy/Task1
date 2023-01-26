import java.util.Random;

public class Die {
    private int faceValue;
    private Random rand;
    private int numSides;

    public Die(){
        this(6);
    }

    public Die(int n){
        if (n <4){
            throw new IllegalArgumentException("Dice can't be that small");
        }
        numSides = n;
        rand = new Random();
        roll();
    }

    public int roll(){
        faceValue = rand.nextInt(numSides)+1;
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        if (faceValue> numSides){
            throw new IllegalArgumentException("Too big");
        }
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return "Die{" +
                "faceValue=" + faceValue +
                ", numSides=" + numSides +
                '}';
    }
}