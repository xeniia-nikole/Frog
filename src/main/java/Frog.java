public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() { position = 5; }

    public boolean jump(int steps) {
            if ((steps >= 0) && ((position + steps) <= MAX_POSITION)) { // вправо
                position += steps;
                return true;
            }
            if ((steps < 0) && ((position + steps) >= MIN_POSITION)) { // влево
                position += steps;
                return true;

            } else {
                System.out.println("~ Прыжок больше лужи!");
                return false;
            }
    }


    public int getPosition() {
        return position;
    }
}

