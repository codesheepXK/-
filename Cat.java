public abstract class Cat {
    protected String name;
    protected int age;
    protected boolean sex;
    protected double price;

    @Override
    public  abstract String toString();

    public double getPrice(){
        return price;
    }
    public Cat(String name, int age, boolean sex, double price) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.price = price;
    }
}
