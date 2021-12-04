public class BlackCat extends Cat {
    public BlackCat(String name, int age, boolean sex) {
        super(name, age, sex, 350);
    }
    public String toString(){
        String temp;
        if(sex) temp="雄性";
        else temp="雌性";
        return "该猫名叫"+name+",是个黑猫,今年"+age+"岁了"+",性别是"+temp;
    }
}
