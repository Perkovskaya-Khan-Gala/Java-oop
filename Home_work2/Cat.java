public class Cat {

    private String name;

    private int appetite;

    private boolean full;

    public Cat(String name, int appetite, boolean full) {
        this.name = name;
        this.appetite = appetite;
        this.full = full;
    }

    public boolean eat(int food) {
        if (food >= appetite) {
            full = true;
            return true;
        } else
            return false;
    }

    public void info() {
        System.out.printf("The cat %s has eaten - %s : \n", name, full);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

}
