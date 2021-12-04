public class OrangeCat extends Cat {
    public boolean isFat;

    public boolean isFat() {
        return isFat;
    }

    public void setFat(boolean fat) {
        isFat = fat;
    }

    public String toString() {
        String temp;
        if (sex) temp = "雄性";
        else temp = "雌性";
        if (isFat) temp += "而且是个胖猫";
        return "该猫名叫" + name + ",是个橘猫,今年" + age + "岁了" + ",性别是" + temp;
    }

    public OrangeCat(String name, int age, boolean sex, boolean isFat) {
        super(name, age, sex, 200);
        this.isFat = isFat;
    }
}
